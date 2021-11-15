package ERP.Project.JournalEntry;

import ERP.Project.CostCenter.CostCenterRepository;
import ERP.Project.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api/journalEntries")
public class JournalEntryController {
    private JournalEntryService journalEntryService;

    public JournalEntryController(JournalEntryService journalEntryService) {
        super();
        this.journalEntryService = journalEntryService;
    }


    //build create journal entry mapped to cost center
    //http://localhost:8080/api/{costCenterId}/journalEntry
    @PostMapping("/api/journalEntry/costCenterId:{CostCenterId}")
    public ResponseEntity<JournalEntry> createJournalEntry(@PathVariable (value = "CostCenterId") String costCenterId,
                                                           @RequestBody JournalEntry journalEntry){
        return new ResponseEntity<JournalEntry>(journalEntryService.saveJournalEntry(journalEntry, costCenterId), HttpStatus.CREATED);
    }

    //build update journal entry RestAPI
    @PutMapping("/api/journalEntry/{Id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable (value = "Id") String journalEntryId,
                                                           @RequestBody JournalEntry journalEntry){
        return new ResponseEntity<JournalEntry>(journalEntryService.updateJournalEntry(journalEntry, journalEntryId), HttpStatus.OK);
    }

    //build delete journal entry RestAPI
    @DeleteMapping("/api/journalEntry/{JournalEntryId}")
    public String deleteJournalEntry(@PathVariable (value = "JournalEntryId") String journalEntryId){
        journalEntryService.deleteJournalEntry(journalEntryId);
        return "Journal Entry Deleted Successfully";
    }


    //build get journal entry by Id RestAPI
    @GetMapping("/api/journalEntry/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable (value = "id") String journalEntryId){
        return new ResponseEntity<JournalEntry>(journalEntryService.getJournalEntryById(journalEntryId), HttpStatus.OK);
    }

    //build get all journal entry RestAPI
    @GetMapping("/api/journalEntries")
    public List<JournalEntry> getAllJournalEntries(){
        return journalEntryService.getAllJournalEntries();
    }



}
