package ERP.Project.Ledger;

import java.time.LocalDate;

public interface AccountLedgerService {
    public AccountLedger getAccountLedger(LocalDate startDate, LocalDate endDate);
}
