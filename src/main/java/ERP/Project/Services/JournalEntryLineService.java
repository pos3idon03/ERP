package ERP.Project.Services;

import ERP.Project.Models.JournalEntryLine;

import java.util.List;

public interface JournalEntryLineService {
    JournalEntryLine saveJournalEntryLine(JournalEntryLine journalEntryLine);
    List<JournalEntryLine> getAllJournalEntryLines();
    JournalEntryLine getJournalEntryLineById(long id);
    JournalEntryLine updateJournalEntryLine(JournalEntryLine journalEntryLine, long id);
    void deleteJournalEntryLine(long id);
}
