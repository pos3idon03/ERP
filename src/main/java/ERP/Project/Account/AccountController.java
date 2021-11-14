package ERP.Project.Account;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        super();
        this.accountService = accountService;
    }

    //build create account RestAPI
    @PostMapping("/api/accounts")
    //http://localhost:8080/api/accounts
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return new ResponseEntity<Account>(accountService.saveAccount(account), HttpStatus.CREATED);
    }

    //build update account RestAPI
    //http://localhost:8080/api/accounts/1
    @PutMapping("/api/accounts/{id}")
    public  ResponseEntity<Account> updateAccount(@PathVariable("id") String accountCode,
                                                  @RequestBody Account account){
        return new ResponseEntity<Account>(accountService.updateAccount(account, accountCode), HttpStatus.OK);
    }


    //build delete account RestAPI
    //http://localhost:8080/api/accounts/1
    @DeleteMapping("/api/accounts/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") String code){
        accountService.deleteAccount(code);
        return new ResponseEntity<String>("Account Deleted", HttpStatus.OK);
    }
    //build get account by Id RestAPI
    //http://localhost:8080/api/accounts/1
    @GetMapping("/api/accounts/id:{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") String code){
        return new ResponseEntity<Account>(accountService.getAccountById(code),HttpStatus.OK);
    }
    //build get all accounts RestAPI
    //http://localhost:8080/api/accounts
    @GetMapping("/api/accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/api/accountsLedger/{id}")
    public ResponseEntity<AccountLedger> getAccountLedgerById(@PathVariable("id") String accountId){
        return new ResponseEntity<AccountLedger>(accountService.getJournalEntriesPerAccount(accountId), HttpStatus.OK);
    }
}


