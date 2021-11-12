package ERP.Project.JournalEntryLine;

import ERP.Project.JournalEntry.JournalEntry;

import java.util.List;

public interface JournalEntryLineService {
    JournalEntryLine saveJournalEntryLine(JournalEntryLine journalEntry, String JournalEntryId,  String AccountId);
    List<JournalEntryLine> getAllJournalEntriesLines();
    JournalEntryLine getJournalEntryLineById(String id);
    JournalEntryLine updateJournalEntryLine(JournalEntryLine journalEntryLine, String id);
    void deleteJournalEntryLineById(String id);
}
