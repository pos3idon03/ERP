package ERP.Project.JournalEntry;

import ERP.Project.CostCenter.CostCenterRepository;
import ERP.Project.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping("/api/journalEntries")
public class JournalEntryController {
    private JournalEntryService journalEntryService;

    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }


    //build create journal entry mapped to cost center
    //http://localhost:8080/api/{costCenterId}/journalEntry
    @PostMapping("/api/{costCenterId}/journalEntry")
    public ResponseEntity<JournalEntry> createJournalEntry(@PathVariable (value = "costCenterId") String costCenterId, @RequestBody JournalEntry journalEntry){
        return new ResponseEntity<JournalEntry>(journalEntryService.saveJournalEntry(journalEntry, costCenterId), HttpStatus.CREATED);
    }

    //build update journal entry RestAPI
    //build delete journal entry RestAPI
    //build get journal entry by Id RestAPI
    //build get all journal entry RestAPI
}
