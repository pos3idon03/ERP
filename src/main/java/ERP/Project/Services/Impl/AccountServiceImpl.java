package ERP.Project.Services.Impl;

import ERP.Project.Models.Account;
import ERP.Project.Repositories.AccountRepository;
import ERP.Project.Services.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
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
