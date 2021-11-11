package ERP.Project.Ledger;

import ERP.Project.Account.Account;
import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntryLine.JournalEntryLine;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class AccountLedgerDataset {
    private String account;
    private List<JournalEntry> journalEntries;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }
}
