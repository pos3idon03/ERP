package ERP.Project.JournalEntryLine;

import ERP.Project.JournalEntryLine.JournalEntryLine;

import java.util.List;

public interface JournalEntryLineService {
    JournalEntryLine saveJournalEntryLine(JournalEntryLine journalEntryLine, String journalEntryId, String accountId);
    List<JournalEntryLine> getAllJournalEntryLines();
    JournalEntryLine getJournalEntryLineById(String id);
    JournalEntryLine updateJournalEntryLine(JournalEntryLine journalEntryLine, String id);
    void deleteJournalEntryLine(String id);
}
