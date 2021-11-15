package ERP.Project.CostCenter;

import ERP.Project.Exception.ResourceNotFoundException;
import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntry.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if(costCenter.getCode().isEmpty() || costCenter.getDescription().isEmpty()){
            throw new ResourceNotFoundException("Code or Description is empty");
        }
        else{
            return costCenterRepository.save(costCenter);
        }
    }

    @Override
    public List<CostCenter> saveCostCenters(List<CostCenter> costCenters) {
        if(costCenters.size() != 0){
            for(int costCenter = 0; costCenter < costCenters.size(); costCenter++){
                costCenterRepository.save(costCenters.get(costCenter));
            }
            return costCenters;
        }
        else{
            throw new ResourceNotFoundException("Cost center List is Empty");
        }
    }

    @Override
    public List<CostCenter> getAllCostCenters() {
        return costCenterRepository.findAll();
    }

    @Override
    public CostCenter getCostCenterById(String id) {
        Optional<CostCenter> costCenter = costCenterRepository.findById(id);
        if(costCenter.isPresent()) {
            return costCenter.get();
        }
        else{
            throw new ResourceNotFoundException("Cost center does not exist with ID:" + id);
        }

    }

    @Override
    public CostCenter updateCostCenter(CostCenter costCenter, String id) {
        if(costCenterRepository.findById(id).isPresent()) {
            CostCenter existingCostCenter = costCenterRepository.getById(id);
            existingCostCenter.setCode(costCenter.getCode());
            existingCostCenter.setDescription(costCenter.getDescription());
            costCenterRepository.save(existingCostCenter);
            return existingCostCenter;
        }
        else{
            throw new ResourceNotFoundException("Cost center does not exist with Id: " + id);
        }
    }

    @Override
    public void deleteCostCenter(String id) {
        if(costCenterRepository.findById(id).isPresent()) {
            costCenterRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("Cost center does not exist with Id: " + id);
        }
    }

    @Override
    public CostCenterLedger createCostCenterLedger(String costCenterId) {
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
        CostCenterLedger costCenterLedger = createCostCenterLedger(costCenterId);
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



