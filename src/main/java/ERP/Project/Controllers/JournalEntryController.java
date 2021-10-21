package ERP.Project.Controllers;

import ERP.Project.Models.JournalEntry;
import ERP.Project.Models.JournalEntryLine;
import ERP.Project.Services.JournalEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping
    //http://localhost:8080/api/journalEntryLine
    public ResponseEntity<JournalEntry> createCostCenter(@RequestBody JournalEntry journalEntry){
        return new ResponseEntity<JournalEntry>(journalEntryService.saveJournalEntry(journalEntry), HttpStatus.CREATED);
    }
    //build update journal entry RestAPI
    //build delete journal entry RestAPI
    //build get journal entry by Id RestAPI
    //build get all journal entry RestAPI
}
