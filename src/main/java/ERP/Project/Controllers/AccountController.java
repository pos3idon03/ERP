package ERP.Project.Controllers;

import ERP.Project.Models.Account;
import ERP.Project.Services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //build create account RestAPI
    @PostMapping
    //http://localhost:8080/api/accounts
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return new ResponseEntity<Account>(accountService.saveAccount(account), HttpStatus.CREATED);
    }
    //build update account RestAPI
    //http://localhost:8080/api/accounts/1
    @PutMapping("{id}")
    public  ResponseEntity<Account> updateAccount(@PathVariable Account account,
                                                  @RequestBody String code){
        return new ResponseEntity<Account>(accountService.updateAccount(account, code), HttpStatus.OK);
    }

    //build delete account RestAPI
    //http://localhost:8080/api/accounts/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@RequestBody String code){
        accountService.deleteAccount(code);
        return new ResponseEntity<String>("Account Deleted", HttpStatus.OK);
    }
    //build get account by Id RestAPI
    //http://localhost:8080/api/accounts/1
    @GetMapping("{id}")
    public ResponseEntity<Account> getAccountById(@RequestBody String code){
        return new ResponseEntity<Account>(accountService.getAccountById(code),HttpStatus.OK);
    }
    //build get all accounts RestAPI
    //http://localhost:8080/api/accounts
    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }


}


