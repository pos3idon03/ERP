package ERP.Project.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        super();
        this.accountRepository = accountRepository;
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(String id) {
        return accountRepository.getById(id);
    }

    @Override
    public Account updateAccount(Account account, String id) {
        Account existingAccount = accountRepository.getById(id);
        existingAccount.setAccountCode(account.getAccountCode());
        existingAccount.setAccountDescription(account.getAccountDescription());

        accountRepository.save(existingAccount);
        return existingAccount;
    }


    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
