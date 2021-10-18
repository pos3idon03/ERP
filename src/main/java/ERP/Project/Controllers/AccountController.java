package ERP.Project.Controllers;

import ERP.Project.Services.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //build create employee RestAPI
    //build update employee RestAPI
    //build delete employee RestAPI
    //build get employee by Id RestAPI
    //build get all employees RestAPI


}


