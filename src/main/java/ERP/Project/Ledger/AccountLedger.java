package ERP.Project.Ledger;

import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntryLine.JournalEntryLine;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class AccountLedger {
    private String Account;
    private List<JournalEntry> journalEntry;


    public List<JournalEntry> getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(List<JournalEntry> journalEntry) {
        this.journalEntry = journalEntry;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }
}
