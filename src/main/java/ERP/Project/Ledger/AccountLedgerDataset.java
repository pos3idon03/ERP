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
    private List<JournalEntry> journalEntries;
    private List<Account> accounts;
    private List<JournalEntryLine> journalEntryLines;

    public AccountLedgerDataset(List<JournalEntry> journalEntries, List<Account> accounts, List<JournalEntryLine> journalEntryLines) {
        this.journalEntries = journalEntries;
        this.accounts = accounts;
        this.journalEntryLines = journalEntryLines;
    }

    public List<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(List<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<JournalEntryLine> getJournalEntryLines() {
        return journalEntryLines;
    }

    public void setJournalEntryLines(List<JournalEntryLine> journalEntryLines) {
        this.journalEntryLines = journalEntryLines;
    }
}
