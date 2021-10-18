package ERP.Project.Controllers;

import ERP.Project.Services.JournalEntryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/journalEntries")
public class JournalEntryController {
    private JournalEntryService journalEntryService;

    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    //build create journal entry RestAPI
    //build update journal entry RestAPI
    //build delete journal entry RestAPI
    //build get journal entry by Id RestAPI
    //build get all journal entry RestAPI
}
