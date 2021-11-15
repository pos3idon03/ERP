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

    @PostMapping("/api/account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return new ResponseEntity<Account>(accountService.saveAccount(account), HttpStatus.CREATED);
    }

    @PostMapping("api/accounts")
    public List<Account> createAccounts(@RequestBody List<Account> accounts){
        return accountService.saveAccounts(accounts);
    }

    @PutMapping("/api/accounts/{id}")
    public  ResponseEntity<Account> updateAccount(@PathVariable("id") String accountCode,
                                                  @RequestBody Account account){
        return new ResponseEntity<Account>(accountService.updateAccount(account, accountCode), HttpStatus.OK);
    }

    @DeleteMapping("/api/accounts/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") String code){
        accountService.deleteAccount(code);
        return new ResponseEntity<String>("Account Deleted", HttpStatus.OK);
    }

    @GetMapping("/api/accounts/id:{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") String code){
        return new ResponseEntity<Account>(accountService.getAccountById(code),HttpStatus.OK);
    }

    @GetMapping("/api/accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/api/accountsLedger/{id}")
    public ResponseEntity<AccountLedger> getAccountLedgerById(@PathVariable("id") String accountId){
        return new ResponseEntity<AccountLedger>(accountService.createAccountLedger(accountId), HttpStatus.OK);
    }
}


