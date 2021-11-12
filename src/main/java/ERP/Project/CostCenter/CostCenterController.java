package ERP.Project.CostCenter;

import ERP.Project.Ledger.CostCenterLedger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CostCenterController {
    private CostCenterService costCenterService;

    public CostCenterController(CostCenterService costCenterService) {
        super();
        this.costCenterService = costCenterService;
    }

    //build create cost center RestAPI
    @PostMapping("/api/costCenters")
    //http://localhost:8080/api/costCenters
    public ResponseEntity<CostCenter> createCostCenter(@RequestBody CostCenter costCenter){
        return new ResponseEntity<CostCenter>(costCenterService.saveCostCenter(costCenter), HttpStatus.CREATED);
    }

    //build update cost center RestAPI
    //http://localhost:8080/api/costCenters/1
    @PutMapping("/api/costCenter/{id}")
    public ResponseEntity<CostCenter> updateCostCenter(@PathVariable(value = "id") String costCenterCode,
                                                       @RequestBody CostCenter costCenter){
        return new ResponseEntity<CostCenter>(costCenterService.updateCostCenter(costCenter, costCenterCode), HttpStatus.OK);
    }

    //build delete cost center RestAPI
    //http://localhost:8080/api/costCenters/1
    @DeleteMapping("/api/costCenter/{id}")
    public String deleteCostCenter(@PathVariable(value = "id") String costCenterCode){
        costCenterService.deleteCostCenter(costCenterCode);
        return "Cost center deleted successfully";
    }

    //build get cost center by Id RestAPI
    //http://localhost:8080/api/costCenters/1
    @GetMapping("/api/costCenter/{id}")
    public ResponseEntity<CostCenter> getCostCenterById(@PathVariable(value = "id") String costCenterCode){
        return new ResponseEntity<CostCenter>(costCenterService.getCostCenterById(costCenterCode), HttpStatus.OK);
    }


    //build get all cost center RestAPI
    //http://localhost:8080/api/costCenters
    @GetMapping("/api/costCenters")
    public List<CostCenter> getAllCostCenters(){
        return costCenterService.getAllCostCenters();
    }

    @GetMapping("/api/costCenterLedger/{startDate}/{endDate}/{costCenterId}")
    public ResponseEntity<CostCenterLedger> getCostCenterLedgerByDate(@PathVariable(value = "startDate")LocalDate startDate,
                                                                      @PathVariable(value = "endDate")LocalDate endDate,
                                                                      @PathVariable(value = "costCenterId") String costCenterId){
        return new ResponseEntity<CostCenterLedger>(costCenterService.getCostCenterLedgerByDate(costCenterId,startDate,endDate), HttpStatus.OK);
    }
}
