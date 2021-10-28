package ERP.Project.TrialBalance;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrialBalanceController {
    private TrialBalanceService triaBalanceService;

    public TrialBalanceController(TrialBalanceService triaBalanceService) {
        super();
        this.triaBalanceService = triaBalanceService;
    }
}
