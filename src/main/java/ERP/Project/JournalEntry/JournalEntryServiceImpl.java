package ERP.Project.JournalEntry;

import ERP.Project.CostCenter.CostCenterRepository;
import ERP.Project.Exception.ResourceNotFoundException;
import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntry.JournalEntryRepository;
import ERP.Project.JournalEntry.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryServiceImpl implements JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private CostCenterRepository costCenterRepository;

    public JournalEntryServiceImpl(JournalEntryRepository journalEntryRepository, CostCenterRepository costCenterRepository) {
        this.journalEntryRepository = journalEntryRepository;
        this.costCenterRepository = costCenterRepository;
    }

    @Override
    public JournalEntry saveJournalEntry(JournalEntry journalEntry, String costCenterId) {
        return costCenterRepository.findById(costCenterId).map(costCenter-> {
            journalEntry.setCostCenter(costCenter);
            return journalEntryRepository.save(journalEntry);
        }).orElseThrow(() -> new ResourceNotFoundException("CostCenterId" + costCenterId + "not found"));
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
        existingJournalEntry.setJournalEntryDate(journalEntry.getJournalEntryDate());
        existingJournalEntry.setJournalEntryLines(journalEntry.getJournalEntryLines());

        journalEntryRepository.save(existingJournalEntry);
        return existingJournalEntry;
    }

    @Override
    public void deleteJournalEntry(String id) {
        journalEntryRepository.deleteById(id);
    }


}
