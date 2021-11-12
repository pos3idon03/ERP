package ERP.Project.Account;

import ERP.Project.Ledger.AccountLedger;

import java.time.LocalDate;
import java.util.List;

public interface AccountService {
    Account saveAccount(Account account);
    List<Account> getAllAccounts();
    Account getAccountById(String id);
    Account updateAccount(Account account, String id);
    void deleteAccount(String id);
    AccountLedger getJournalEntriesPerAccount( String accountId);
}
