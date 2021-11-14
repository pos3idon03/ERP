package ERP.Project.CostCenter;

import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntry.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CostCenterServiceImpl implements CostCenterService {
    @Autowired
    private CostCenterRepository costCenterRepository;

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public CostCenterServiceImpl(CostCenterRepository costCenterRepository) {
        super();
        this.costCenterRepository = costCenterRepository;
    }

    @Override
    public CostCenter saveCostCenter(CostCenter costCenter) {
        return costCenterRepository.save(costCenter);
    }

    @Override
    public List<CostCenter> getAllCostCenters() {
        return costCenterRepository.findAll();
    }

    @Override
    public CostCenter getCostCenterById(String id) {
        return costCenterRepository.getById(id);
    }

    @Override
    public CostCenter updateCostCenter(CostCenter costCenter, String id) {
        CostCenter existingCostCenter = costCenterRepository.getById(id);
        existingCostCenter.setCode(costCenter.getCode());
        existingCostCenter.setDescription(costCenter.getDescription());

        costCenterRepository.save(existingCostCenter);
        return existingCostCenter;
    }

    @Override
    public void deleteCostCenter(String id) {
        costCenterRepository.deleteById(id);
    }

    @Override
    public CostCenterLedger getCostCenterLedger(String costCenterId) {
        CostCenterLedger costCenterLedger = new CostCenterLedger();
        CostCenter costCenter = costCenterRepository.getById(costCenterId);
        costCenterLedger.setCostCenter(costCenter.getCode());
        List<JournalEntry> journalEntries = journalEntryRepository.findAll();

        List<JournalEntry> filteredJournalEntries = new ArrayList<JournalEntry>();

        for(int i = 0; i < journalEntries.size(); i++){
            if(journalEntries.get(i).getCostCenter().getId() == costCenterId){
               filteredJournalEntries.add(journalEntries.get(i));
            }
        }

        costCenterLedger.setJournalEntry(filteredJournalEntries);

        return costCenterLedger;
    }

    @Override
    public CostCenterLedger getCostCenterLedgerByDate(String costCenterId, LocalDate startDate, LocalDate endDate) {
        CostCenterLedger costCenterLedger = getCostCenterLedger(costCenterId);
       /*
        for(int i=0; i < costCenterLedger.getJournalEntry().size(); i++){
            if(costCenterLedger.getJournalEntry().get(i).getJournalEntryDate().isBefore(startDate.minusDays(1)) &&
            costCenterLedger.getJournalEntry().get(i).getJournalEntryDate().isAfter(endDate.plusDays(1))){
                costCenterLedger.getJournalEntry().remove(costCenterLedger.getJournalEntry().get(i));
            }
        }

        */

        return costCenterLedger;
    }


}



