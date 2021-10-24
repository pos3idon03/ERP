package ERP.Project.CostCenter;


import ERP.Project.CostCenter.CostCenter;

import java.util.List;

public interface CostCenterService {
    CostCenter saveCostCenter(CostCenter costCenter);
    List<CostCenter> getAllCostCenters();
    CostCenter getCostCenterById(String id);
    CostCenter updateCostCenter(CostCenter costCenter, String id);
    void deleteCostCenter(String id);
}
