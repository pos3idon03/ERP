package ERP.Project.Controllers;

import ERP.Project.Models.Account;
import ERP.Project.Models.CostCenter;
import ERP.Project.Services.CostCenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/costCenters")
public class CostCenterController {
    private CostCenterService costCenterService;

    public CostCenterController(CostCenterService costCenterService) {
        super();
        this.costCenterService = costCenterService;
    }

    //build create cost center RestAPI
    @PostMapping
    //http://localhost:8080/api/costCenters
    public ResponseEntity<CostCenter> createCostCenter(@RequestBody CostCenter costCenter){
        return new ResponseEntity<CostCenter>(costCenterService.saveCostCenter(costCenter), HttpStatus.CREATED);
    }
    //build update cost center RestAPI
    //build delete cost center RestAPI
    //build get cost center by Id RestAPI
    //build get all cost center RestAPI
}
