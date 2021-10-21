package ERP.Project.Services;

import ERP.Project.Models.JournalEntryLine;

import java.util.List;

public interface JournalEntryLineService {
    JournalEntryLine saveJournalEntryLine(JournalEntryLine journalEntryLine);
    List<JournalEntryLine> getAllJournalEntryLines();
    JournalEntryLine getJournalEntryLineById(String id);
    JournalEntryLine updateJournalEntryLine(JournalEntryLine journalEntryLine, String id);
    void deleteJournalEntryLine(String id);
}
