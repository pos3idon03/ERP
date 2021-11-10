package ERP.Project.JournalEntry;

import ERP.Project.JournalEntry.JournalEntry;

import java.time.LocalDate;
import java.util.List;

public interface JournalEntryService {
    JournalEntry saveJournalEntry(JournalEntry journalEntry, String costCenterId);
    List<JournalEntry> getAllJournalEntries();
    JournalEntry getJournalEntryById(String id);
    JournalEntry updateJournalEntry(JournalEntry journalEntry, String id);
    void deleteJournalEntry(String id);
    List<JournalEntry> getJournalEntriesDatePeriod(LocalDate startDate, LocalDate endDate);
}
