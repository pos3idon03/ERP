package ERP.Project.CostCenter;


import java.time.LocalDate;
import java.util.List;

public interface CostCenterService {
    CostCenter saveCostCenter(CostCenter costCenter);
    List<CostCenter> saveCostCenters(List<CostCenter> costCenters);
    List<CostCenter> getAllCostCenters();
    CostCenter getCostCenterById(String id);
    CostCenter updateCostCenter(CostCenter costCenter, String id);
    void deleteCostCenter(String id);
    CostCenterLedger createCostCenterLedger(String costCenterId);
    CostCenterLedger getCostCenterLedgerByDate(String costCenterId, LocalDate startDate, LocalDate endDate);
}
