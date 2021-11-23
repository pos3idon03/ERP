package ERP.Project.Account;

import ERP.Project.Exception.ResourceNotFoundException;
import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntry.JournalEntryRepository;
import ERP.Project.JournalEntryLine.JournalEntryLine;
import ERP.Project.JournalEntryLine.JournalEntryLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private JournalEntryLineRepository journalEntryLineRepository;

    public AccountServiceImpl(AccountRepository accountRepository,
                              JournalEntryRepository journalEntryRepository,
                              JournalEntryLineRepository journalEntryLineRepository) {
        super();
        this.accountRepository = accountRepository;
        this.journalEntryRepository = journalEntryRepository;
        this.journalEntryLineRepository = journalEntryLineRepository;
    }

    @Override
    public Account saveAccount(Account account) {
      return accountRepository.save(account);
    }

    @Override
    public List<Account> saveAccounts(List<Account> accounts) {
        if(accounts.size() != 0){
            for(int acc = 0;acc < accounts.size(); acc++ ){
                accountRepository.save(accounts.get(acc));
            }
            return accounts;
        }
        else{
            throw new ResourceNotFoundException("The List is empty");
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            return account.get();
        }
        else{
            throw new ResourceNotFoundException("Account ID not found:" + id);
        }
    }

    @Override
    public Account updateAccount(Account account, String id) {
        if(accountRepository.findById(id).isPresent()) {
            Account existingAccount = accountRepository.getById(id);
            existingAccount.setCode(account.getCode());
            existingAccount.setDescription(account.getDescription());
            accountRepository.save(existingAccount);
            return existingAccount;
        }
        else{
            throw new ResourceNotFoundException("Account ID not found:" + id);
        }
    }

    @Override
    public void deleteAccount(String id) {
        if(accountRepository.findById(id).isPresent()) {
            accountRepository.deleteById(id);}
        else{
            throw new ResourceNotFoundException("Account ID not found:" + id);
        }

    }

    @Override
    public AccountLedger createAccountLedger(String accountId){
        AccountLedger accountLedger = new AccountLedger();
        Account account = accountRepository.getById(accountId);
        accountLedger.setAccount(account.getCode());
        List<JournalEntryLine> filteredJournalEntryLines = journalEntryLineRepository.findAll().stream().map(Account::getId).collect(Collectors.toList());




        /*
        AccountLedger accountLedger = new AccountLedger();
        Account account = accountRepository.getById(accountId);
        accountLedger.setAccount(account.getCode());
        List<JournalEntryLine> journalEntryLines = journalEntryLineRepository.findAll();

        List<JournalEntryLine> filteredJournalEntryLines = new ArrayList<JournalEntryLine>();

        for(int i = 0; i < journalEntryLines.size(); i++){
            if(journalEntryLines.get(i).getAccount().getId() == accountId){
                filteredJournalEntryLines.add(journalEntryLines.get(i));
            }
        }

        List<JournalEntry> journalEntries = journalEntryRepository.findAll();

        List<JournalEntry> filteredJournalEntries = new ArrayList<JournalEntry>();

        for(int i =0; i < filteredJournalEntryLines.size(); i++){
            for(int j=0; j < journalEntries.size(); j++){
                if(filteredJournalEntryLines.get(i).getJournalEntry().getId() == journalEntries.get(j).getId()){
                    filteredJournalEntries.add(journalEntries.get(j));
                }
            }
        }

        accountLedger.setJournalEntry(filteredJournalEntries);

        return accountLedger;
         */
    }



}
