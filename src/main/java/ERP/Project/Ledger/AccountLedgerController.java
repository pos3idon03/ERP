package ERP.Project.Ledger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

public class AccountLedgerController {
    private AccountLedgerService accountLedgerService;

    public AccountLedgerController(AccountLedgerService accountLedgerService) {
        super();
        this.accountLedgerService = accountLedgerService;
    }

    @GetMapping("/api/accountLedger/{startDate}/{endDate}")
    public AccountLedger getAccountLedger(@PathVariable (value = "startDate") String startDate,
                                          @PathVariable (value = "endDate") String endDate){
        LocalDate reportStartDate = LocalDate.parse(startDate);
        LocalDate reportEndDate = LocalDate.parse(endDate);

        return accountLedgerService.getAccountLedger(reportStartDate, reportEndDate);
    }

}
