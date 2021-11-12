package ERP.Project.TrialBalance;

import java.time.LocalDate;

public interface TrialBalanceService {
    public TrialBalance getJournalEntriesDatePerAccount(LocalDate startDate, LocalDate endDate);
    public TrialBalance getJournalEntriesDatePerCostCenter(LocalDate startDate, LocalDate endDate);
}
