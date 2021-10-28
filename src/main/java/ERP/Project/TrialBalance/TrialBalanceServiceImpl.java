package ERP.Project.TrialBalance;

import ERP.Project.Account.Account;
import ERP.Project.Account.AccountService;
import ERP.Project.JournalEntry.JournalEntry;
import ERP.Project.JournalEntry.JournalEntryService;
import ERP.Project.JournalEntryLine.JournalEntryLine;
import ERP.Project.JournalEntryLine.JournalEntryLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrialBalanceServiceImpl implements TrialBalanceService {
    @Autowired
    private AccountService accountService;

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private JournalEntryLineService journalEntryLineService;

    public TrialBalanceServiceImpl(AccountService accountService, JournalEntryService journalEntryService, JournalEntryLineService journalEntryLineService) {
        this.accountService = accountService;
        this.journalEntryService = journalEntryService;
        this.journalEntryLineService = journalEntryLineService;
    }
}
