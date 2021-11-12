package ERP.Project.Account;

import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntry.JournalEntryRepository;
import ERP.Project.JournalEntryLine.JournalEntryLine;
import ERP.Project.JournalEntryLine.JournalEntryLineRepository;
import ERP.Project.Ledger.AccountLedger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public AccountLedger getJournalEntriesPerAccount(String accountId){
        AccountLedger accountLedger = new AccountLedger();
        Account account = accountRepository.getById(accountId);
        accountLedger.setAccount(account.getAccountCode());
        List<JournalEntryLine> journalEntryLines = journalEntryLineRepository.findAll();

        List<JournalEntryLine> filteredJournalEntryLines = new ArrayList<JournalEntryLine>();

        for(int i = 0; i < journalEntryLines.size(); i++){
            if(journalEntryLines.get(i).getAccount().getAccountCodeId() == accountId){
                filteredJournalEntryLines.add(journalEntryLines.get(i));
            }
        }

        List<JournalEntry> journalEntries = journalEntryRepository.findAll();

        List<JournalEntry> filteredJournalEntries = new ArrayList<JournalEntry>();

        for(int i =0; i < filteredJournalEntryLines.size(); i++){
            for(int j=0; j < journalEntries.size(); j++){
                if(filteredJournalEntryLines.get(i).getJournalEntry().getJournalEntryId() == journalEntries.get(j).getJournalEntryId()){
                    filteredJournalEntries.add(journalEntries.get(j));
                }
            }
        }

        accountLedger.setJournalEntry(filteredJournalEntries);

        return accountLedger;
    }

}
