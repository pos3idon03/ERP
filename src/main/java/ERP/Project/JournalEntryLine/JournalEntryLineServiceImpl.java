package ERP.Project.JournalEntryLine;

import ERP.Project.Account.Account;
import ERP.Project.Account.AccountRepository;
import ERP.Project.Exception.ResourceNotFoundException;
import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntry.JournalEntryRepository;
import ERP.Project.JournalEntryLine.JournalEntryLine;
import ERP.Project.JournalEntryLine.JournalEntryLineRepository;
import ERP.Project.JournalEntryLine.JournalEntryLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryLineServiceImpl implements JournalEntryLineService {
    @Autowired
    private JournalEntryLineRepository journalEntryLineRepository;

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private AccountRepository accountRepository;

    public JournalEntryLineServiceImpl(JournalEntryLineRepository journalEntryLineRepository, JournalEntryRepository journalEntryRepository, AccountRepository accountRepository) {
        this.journalEntryLineRepository = journalEntryLineRepository;
        this.journalEntryRepository = journalEntryRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public JournalEntryLine saveJournalEntryLine(JournalEntryLine journalEntryLine, String journalEntryId, String accountId) {
        JournalEntry existingJournalEntry = journalEntryRepository.getById(journalEntryId);
        Account existingAccount = accountRepository.getById(accountId);
        journalEntryLine.setJournalEntry(existingJournalEntry);
        journalEntryLine.setAccount(existingAccount);
        return journalEntryLineRepository.save(journalEntryLine);
        /*
        return journalEntryRepository.findById(journalEntryId).map(journalEntry-> {
            journalEntryLine.setJournalEntry(journalEntry);
            return journalEntryLineRepository.save(journalEntryLine);
        }).orElseThrow(() -> new ResourceNotFoundException("JournalEntryId" + journalEntryId + "not found"));

         */
    }

    @Override
    public List<JournalEntryLine> getAllJournalEntryLines() {
        return journalEntryLineRepository.findAll();
    }

    @Override
    public JournalEntryLine getJournalEntryLineById(String id) {
        return journalEntryLineRepository.getById(id);
    }

    @Override
    public JournalEntryLine updateJournalEntryLine(JournalEntryLine journalEntryLine, String id) {
        JournalEntryLine existingJournalEntryLine = journalEntryLineRepository.getById(id);
        existingJournalEntryLine.setJournalEntryLineAmount(journalEntryLine.getJournalEntryLineAmount());

        journalEntryLineRepository.save(existingJournalEntryLine);
        return existingJournalEntryLine;
    }

    @Override
    public void deleteJournalEntryLine(String id) {
        journalEntryLineRepository.deleteById(id);
    }
}
