package ERP.Project.JournalEntryLine;

import ERP.Project.JournalEntry.JournalEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalEntryLineController {

    private JournalEntryLineService journalEntryLineService;

    public JournalEntryLineController(JournalEntryLineService journalEntryLineService) {
        super();
        this.journalEntryLineService = journalEntryLineService;
    }

    //build create journal entry mapped to cost center
    //http://localhost:8080/api/{costCenterId}/journalEntry
    @PostMapping("/api/JEId:{journalEntryId}/accountId:{accountId}/journalEntryLine")
    public ResponseEntity<JournalEntryLine> createJournalEntry(@PathVariable(value = "journalEntryId") String journalEntryId,
                                                           @PathVariable(value = "accountId") String accountId,
                                                           @RequestBody JournalEntryLine journalEntryLine){
        return new ResponseEntity<JournalEntryLine>(journalEntryLineService.saveJournalEntryLine(journalEntryLine, journalEntryId, accountId), HttpStatus.CREATED);
    }

    @GetMapping("/api/journalEntryLines")
    public List<JournalEntryLine> getAllJournalEntryLines(){
        return journalEntryLineService.getAllJournalEntriesLines();
    }

    @GetMapping("/api/journalEntryLine/{journalEntryLineId}")
    public ResponseEntity<JournalEntryLine> getJournalEntryLineById(@PathVariable(value = "journalEntryId") String journalEntryId){
        return new ResponseEntity<JournalEntryLine>(journalEntryLineService.getJournalEntryLineById(journalEntryId), HttpStatus.OK);
    }

    @DeleteMapping("/api/journalEntryLine/{journalEntryLineId}")
    public String deleteJournalEntryLineById(@PathVariable(value = "journalEntryLineId") String Id){
        journalEntryLineService.deleteJournalEntryLineById(Id);
        return "Journal Entry Line Deleted Successfully";
    }

    @PutMapping("/api/journalEntryLine/{journalEntryLineId}")
    public ResponseEntity<JournalEntryLine> updateJournalEntryLine(@PathVariable(value = "journalEntryId") String journalEntryId,
                                                                   @RequestBody JournalEntryLine journalEntryLine){
        return new ResponseEntity<JournalEntryLine>(journalEntryLineService.updateJournalEntryLine(journalEntryLine, journalEntryId), HttpStatus.OK);
    }


}
