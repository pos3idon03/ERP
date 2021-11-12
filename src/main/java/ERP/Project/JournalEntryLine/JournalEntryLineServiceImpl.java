package ERP.Project.JournalEntryLine;

import ERP.Project.Account.Account;
import ERP.Project.Account.AccountRepository;
import ERP.Project.Exception.ResourceNotFoundException;
import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntry.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryLineServiceImpl implements JournalEntryLineService{

    @Autowired
    private JournalEntryLineRepository journalEntryLineRepository;

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private AccountRepository accountRepository;

    public JournalEntryLineServiceImpl(JournalEntryLineRepository journalEntryLineRepository,
                                       JournalEntryRepository journalEntryRepository,
                                       AccountRepository accountRepository) {
        this.journalEntryLineRepository = journalEntryLineRepository;
        this.journalEntryRepository = journalEntryRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public JournalEntryLine saveJournalEntryLine(JournalEntryLine journalEntryLine, String journalEntryId, String accountId) {
        JournalEntry journalEntry = journalEntryRepository.getById(journalEntryId);
        Account account = accountRepository.getById(accountId);

        journalEntryLine.setJournalEntry(journalEntry);
        journalEntryLine.setAccount(account);

        journalEntryLineRepository.save(journalEntryLine);
        return journalEntryLine;

    }

    @Override
    public List<JournalEntryLine> getAllJournalEntriesLines() {

        return journalEntryLineRepository.findAll();
    }

    @Override
    public JournalEntryLine getJournalEntryLineById(String id) {

        return journalEntryLineRepository.getById(id);
    }

    @Override
    public JournalEntryLine updateJournalEntryLine(JournalEntryLine journalEntryLine, String id) {
        JournalEntryLine existingJournalEntryLine = journalEntryLineRepository.getById(id);
        existingJournalEntryLine.setJournalEntry(journalEntryLine.getJournalEntry());
        existingJournalEntryLine.setAccount(journalEntryLine.getAccount());
        existingJournalEntryLine.setAmount(journalEntryLine.getAmount());

        journalEntryLineRepository.save(existingJournalEntryLine);
        return existingJournalEntryLine;
    }

    @Override
    public void deleteJournalEntryLineById(String id) {

        journalEntryLineRepository.deleteById(id);
    }
}
