package ERP.Project.Ledger;

import ERP.Project.Account.Account;
import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntryLine.JournalEntryLine;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class AccountLedger {
    private LocalDate startDate;
    private LocalDate endDate;
    private AccountLedgerDataset accountLedgerDataset;
    private String status;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public AccountLedgerDataset getAccountLedgerDataset() {
        return accountLedgerDataset;
    }

    public void setAccountLedgerDataset(AccountLedgerDataset accountLedgerDataset) {
        this.accountLedgerDataset = accountLedgerDataset;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
