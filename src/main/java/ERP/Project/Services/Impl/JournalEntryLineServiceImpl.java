package ERP.Project.Services.Impl;

import ERP.Project.Models.CostCenter;
import ERP.Project.Models.JournalEntryLine;
import ERP.Project.Repositories.JournalEntryLineRepository;
import ERP.Project.Services.JournalEntryLineService;

import java.util.List;

public class JournalEntryLineServiceImpl implements JournalEntryLineService {
    private JournalEntryLineRepository journalEntryLineRepository;

    public JournalEntryLineServiceImpl(JournalEntryLineRepository journalEntryLineRepository) {
        this.journalEntryLineRepository = journalEntryLineRepository;
    }

    @Override
    public JournalEntryLine saveJournalEntryLine(JournalEntryLine journalEntryLine) {
        return journalEntryLineRepository.save(journalEntryLine);
    }

    @Override
    public List<JournalEntryLine> getAllJournalEntryLines() {
        return journalEntryLineRepository.findAll();
    }

    @Override
    public JournalEntryLine getJournalEntryLineById(String id) {
        return journalEntryLineRepository.getById(id);
    }

    @Override
    public JournalEntryLine updateJournalEntryLine(JournalEntryLine journalEntryLine, String id) {
        JournalEntryLine existingJournalEntryLine = journalEntryLineRepository.getById(id);
        existingJournalEntryLine.setAmount(journalEntryLine.getAmount());
        existingJournalEntryLine.setJournalEntry(journalEntryLine.getJournalEntry());
        existingJournalEntryLine.setAccount(journalEntryLine.getAccount());

        journalEntryLineRepository.save(existingJournalEntryLine);
        return existingJournalEntryLine;
    }

    @Override
    public void deleteJournalEntryLine(String id) {
        journalEntryLineRepository.deleteById(id);
    }
}
