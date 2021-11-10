package ERP.Project.TrialBalance;

import ERP.Project.JournalEntry.JournalEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TrialBalanceController {
    private TrialBalanceService triaBalanceService;

    public TrialBalanceController(TrialBalanceService triaBalanceService) {
        super();
        this.triaBalanceService = triaBalanceService;
    }

    @GetMapping("/api/trialBalanceAccount/{startDate}/{endDate}")
    public TrialBalance getTrialBalanceAccount(@PathVariable (value = "startDate") String startDate,
                                              @PathVariable (value = "endDate") String endDate){
        LocalDate reportStartDate = LocalDate.parse(startDate);
        LocalDate reportEndDate = LocalDate.parse(endDate);

        return triaBalanceService.getJournalEntriesDatePerAccount(reportStartDate, reportEndDate);
    }

    @GetMapping("/api/trialBalanceCostCenter/{startDate}/{endDate}")
    public TrialBalance getTrialBalanceCostCenter(@PathVariable (value = "startDate") String startDate,
                                        @PathVariable (value = "endDate") String endDate){
        LocalDate reportStartDate = LocalDate.parse(startDate);
        LocalDate reportEndDate = LocalDate.parse(endDate);

        return triaBalanceService.getJournalEntriesDatePerCostCenter(reportStartDate, reportEndDate);
    }




    @GetMapping("/api/trialBalance")
    public LocalDate getTrialBalance(){
        return LocalDate.now();
    }
}
