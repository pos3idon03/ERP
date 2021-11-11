package ERP.Project.TrialBalance;

import ERP.Project.Account.Account;
import ERP.Project.Account.AccountRepository;
import ERP.Project.Account.AccountService;
import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntry.JournalEntryRepository;
import ERP.Project.JournalEntry.JournalEntryService;
import ERP.Project.JournalEntryLine.JournalEntryLine;
import ERP.Project.JournalEntryLine.JournalEntryLineRepository;
import ERP.Project.JournalEntryLine.JournalEntryLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TrialBalanceServiceImpl implements TrialBalanceService {
    @Autowired
    private AccountRepository accountRepository;

    private AccountService accountService;

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    private JournalEntryService journalEntryService;

    @Autowired
    private JournalEntryLineRepository journalEntryLineRepository;

    private JournalEntryLineService journalEntryLineService;

    public TrialBalanceServiceImpl(AccountRepository accountRepository,
                                   AccountService accountService,
                                   JournalEntryRepository journalEntryRepository,
                                   JournalEntryService journalEntryService,
                                   JournalEntryLineRepository journalEntryLineRepository,
                                   JournalEntryLineService journalEntryLineService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.journalEntryRepository = journalEntryRepository;
        this.journalEntryService = journalEntryService;
        this.journalEntryLineRepository = journalEntryLineRepository;
        this.journalEntryLineService = journalEntryLineService;
    }

    @Override
    public TrialBalance getJournalEntriesDatePerAccount(LocalDate startDate, LocalDate endDate){
        List<JournalEntry> allJournalEntries = journalEntryService.getAllJournalEntries();
        List<JournalEntry> result = filterJournalEntryByDate(startDate, endDate, allJournalEntries);
        Map<String, Long> figures = sumFiguresPerAccount(result);
        String status = checkSum(figures);
        return new TrialBalance(startDate, endDate, figures, status);
    }
    @Override
    public TrialBalance getJournalEntriesDatePerCostCenter(LocalDate startDate, LocalDate endDate){
        List<JournalEntry> allJournalEntries = journalEntryService.getAllJournalEntries();
        List<JournalEntry> result = filterJournalEntryByDate(startDate, endDate, allJournalEntries);
        Map<String, Long> figures = sumFiguresPerCostCenter(result);
        return new TrialBalance(startDate, endDate, figures, "OK");
    }

    private List<Figure> getFigureListPerAccount(List<JournalEntry> result) {
        List<Figure> figures = new ArrayList<>();
        for (JournalEntry journalEntry : result) {
            for (JournalEntryLine journalEntryLine : journalEntry.getJournalEntryLines()) {
                figures.add(new Figure(
                    journalEntryLine.getAccount().getAccountCode(),
                    journalEntryLine.getJournalEntryLineAmount().longValue()
                ));
            }
        }
        return figures;
    }
    private List<Figure> getFigureListPerCostCenter(List<JournalEntry> result) {
        List<Figure> figures = new ArrayList<>();
        for (JournalEntry journalEntry : result) {
            for (JournalEntryLine journalEntryLine : journalEntry.getJournalEntryLines()) {
                figures.add(new Figure(
                        journalEntry.getCostCenter().getCostCenterCode(),
                        journalEntryLine.getJournalEntryLineAmount().longValue()
                ));
            }
        }
        return figures;
    }
    private Map<String,Long> sumFiguresPerAccount(List<JournalEntry> result){
        List<Figure> figures = getFigureListPerAccount(result);
        Map<String, Long> totalByAccount = figures.stream().collect(Collectors.groupingBy(Figure::getCode,
                Collectors.summingLong(Figure::getAmount)));
        return totalByAccount;
    }
    private Map<String,Long> sumFiguresPerCostCenter(List<JournalEntry> result){
        List<Figure> figures = getFigureListPerCostCenter(result);
        Map<String, Long> totalByCostCenter = figures.stream().collect(Collectors.groupingBy(Figure::getCode,
                Collectors.summingLong(Figure::getAmount)));
        return totalByCostCenter;
    }
    private String checkSum(Map<String, Long> figuresList){
        Long sum = 0L;
        for(Long l : figuresList.values()){
            sum += l;
        }

        String status;
        if(figuresList.size() == 0){
            status = "No entries exist";
        }
        else if (sum == 0L){
            status = "Trial Balance is OK";
        }
        else{
            status = "Trial Balance has missing entries";
        }

        return status;
    }
    private List<JournalEntry> filterJournalEntryByDate(LocalDate startDate, LocalDate endDate,List<JournalEntry> allJournalEntries){
        Predicate<JournalEntry> byDate = journalEntry ->
                journalEntry.getJournalEntryDate().isAfter(startDate.minusDays(1)) && journalEntry.getJournalEntryDate().isBefore(endDate.plusDays(1));
        List<JournalEntry> result = allJournalEntries.stream().filter(byDate).collect(Collectors.toList());

        return result;
    }
}

