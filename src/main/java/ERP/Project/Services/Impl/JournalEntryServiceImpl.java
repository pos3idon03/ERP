package ERP.Project.Services.Impl;

import ERP.Project.Models.JournalEntry;
import ERP.Project.Models.JournalEntryLine;
import ERP.Project.Repositories.JournalEntryRepository;
import ERP.Project.Services.JournalEntryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryServiceImpl implements JournalEntryService {
    private JournalEntryRepository journalEntryRepository;

    public JournalEntryServiceImpl(JournalEntryRepository journalEntryRepository) {
        this.journalEntryRepository = journalEntryRepository;
    }

    @Override
    public JournalEntry saveJournalEntry(JournalEntry journalEntry) {
        return journalEntryRepository.save(journalEntry);
    }

    @Override
    public List<JournalEntry> getAllJournalEntries() {

        return journalEntryRepository.findAll();
    }

    @Override
    public JournalEntry getJournalEntryById(String id) {

        return journalEntryRepository.getById(id);
    }

    @Override
    public JournalEntry updateJournalEntry(JournalEntry journalEntry, String id) {
        JournalEntry existingJournalEntry = journalEntryRepository.getById(id);
        existingJournalEntry.setJournalDate(journalEntry.getJournalDate());
        existingJournalEntry.setCostCenter(journalEntry.getCostCenter());
        existingJournalEntry.setJournalEntryLines(journalEntry.getJournalEntryLines());

        journalEntryRepository.save(existingJournalEntry);
        return existingJournalEntry;
    }

    @Override
    public void deleteJournalEntry(String id) {
        journalEntryRepository.deleteById(id);
    }
}
