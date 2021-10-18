package ERP.Project.Controllers;

import ERP.Project.Services.CostCenterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/costCenters")
public class CostCenterController {
    private CostCenterService costCenterService;

    public CostCenterController(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    //build create cost center RestAPI
    //build update cost center RestAPI
    //build delete cost center RestAPI
    //build get cost center by Id RestAPI
    //build get all cost center RestAPI
}
