package ERP.Project.Services;

import ERP.Project.Models.Account;

import java.util.List;

public interface AccountService {
    Account saveAccount(Account account);
    List<Account> getAllAccounts();
    Account getAccountById(String id);
    Account updateAccount(Account account, String id);
    void deleteAccount(String id);
}
