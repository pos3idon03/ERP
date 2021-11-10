package ERP.Project.TrialBalance;

import ERP.Project.Account.Account;
import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntryLine.JournalEntryLine;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public interface TrialBalanceService {
    public TrialBalance getJournalEntriesDatePerAccount(LocalDate startDate, LocalDate endDate);
    public TrialBalance getJournalEntriesDatePerCostCenter(LocalDate startDate, LocalDate endDate);
}
