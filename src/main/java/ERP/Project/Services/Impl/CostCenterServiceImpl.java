package ERP.Project.Services.Impl;

import ERP.Project.Models.Account;
import ERP.Project.Models.CostCenter;
import ERP.Project.Repositories.CostCenterRepository;
import ERP.Project.Services.CostCenterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostCenterServiceImpl implements CostCenterService {
    private CostCenterRepository costCenterRepository;

    public CostCenterServiceImpl(CostCenterRepository costCenterRepository) {
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
        existingCostCenter.setDescription(costCenter.getDescription());

        costCenterRepository.save(existingCostCenter);
        return existingCostCenter;
    }

    @Override
    public void deleteCostCenter(String id) {
        costCenterRepository.deleteById(id);
    }
}
