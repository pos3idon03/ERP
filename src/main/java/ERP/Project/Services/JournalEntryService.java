package ERP.Project.Services;

import ERP.Project.Models.JournalEntry;

import java.util.List;

public interface JournalEntryService {
    JournalEntry saveJournalEntry(JournalEntry journalEntry);
    List<JournalEntry> getAllJournalEntries();
    JournalEntry getJournalEntryById(long id);
    JournalEntry updateJournalEntry(JournalEntry journalEntry, long id);
    void deleteJournalEntry(long id);
}
