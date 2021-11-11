package ERP.Project.Ledger;

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

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AccountLedgerServiceImpl implements AccountLedgerService{
    @Autowired
    private AccountRepository accountRepository;
    private AccountService accountService;

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    private JournalEntryService journalEntryService;

    @Autowired
    private JournalEntryLineRepository journalEntryLineRepository;
    private JournalEntryLineService journalEntryLineService;

    public AccountLedgerServiceImpl(AccountRepository accountRepository,
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
    public AccountLedger getAccountLedger(LocalDate startDate, LocalDate endDate) {
        List<JournalEntry> allJournalEntries = journalEntryService.getAllJournalEntries();
        List<JournalEntryLine> allJournalEntriesLines = journalEntryLineService.getAllJournalEntryLines();
        List<Account> allAccounts = accountService.getAllAccounts();

        List<JournalEntry> dataset = filterJournalEntryByDate(startDate, endDate, allJournalEntries);


        AccountLedgerDataset result1 = new AccountLedgerDataset("a", dataset);
        AccountLedger result = new AccountLedger(startDate, endDate, result1, "True");

        return result;
    }

    private List<JournalEntry> filterJournalEntryByDate(LocalDate startDate, LocalDate endDate,List<JournalEntry> allJournalEntries){
        Predicate<JournalEntry> byDate = journalEntry ->
                journalEntry.getJournalEntryDate().isAfter(startDate.minusDays(1)) && journalEntry.getJournalEntryDate().isBefore(endDate.plusDays(1));
        List<JournalEntry> result = allJournalEntries.stream().filter(byDate).collect(Collectors.toList());

        return result;
    }
}
