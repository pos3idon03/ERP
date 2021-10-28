package ERP.Project.CostCenter;

import ERP.Project.CostCenter.CostCenter;
import ERP.Project.CostCenter.CostCenterRepository;
import ERP.Project.CostCenter.CostCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostCenterServiceImpl implements CostCenterService {
    @Autowired
    private CostCenterRepository costCenterRepository;

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
        existingCostCenter.setCostCenterCode(costCenter.getCostCenterCode());
        existingCostCenter.setCostCenterDescription(costCenter.getCostCenterDescription());

        costCenterRepository.save(existingCostCenter);
        return existingCostCenter;
    }


    @Override
    public void deleteCostCenter(String id) {
        costCenterRepository.deleteById(id);
    }
}
