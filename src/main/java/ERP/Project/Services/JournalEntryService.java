package ERP.Project.Services;

import ERP.Project.Models.JournalEntry;

import java.util.List;

public interface JournalEntryService {
    JournalEntry saveJournalEntry(JournalEntry journalEntry);
    List<JournalEntry> getAllJournalEntries();
    JournalEntry getJournalEntryById(String id);
    JournalEntry updateJournalEntry(JournalEntry journalEntry, String id);
    void deleteJournalEntry(String id);
}
