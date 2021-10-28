package ERP.Project.JournalEntryLine;

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

    @PostMapping("/api/{journalEntryId}/{accountId}/journalEntryLine")
    public ResponseEntity<JournalEntryLine> createJournalEntryLine(@PathVariable (value = "journalEntryId") String journalEntryId,
                                                                   @PathVariable (value = "accountId") String accountId,
                                                                   @RequestBody JournalEntryLine journalEntryLine ){
        return new ResponseEntity<JournalEntryLine>(journalEntryLineService.saveJournalEntryLine(journalEntryLine, journalEntryId, accountId), HttpStatus.CREATED);
    }

    //build update cost center RestAPI
    @PutMapping("/api/journalEntryLine/{id}")
    public ResponseEntity<JournalEntryLine> updateJournalEntryLine(@PathVariable (value = "id") String journalEntryId,
                                                                   @RequestBody JournalEntryLine journalEntryLine){
        return new ResponseEntity<JournalEntryLine>(journalEntryLineService.updateJournalEntryLine(journalEntryLine, journalEntryId), HttpStatus.OK);
    }

    //build delete cost center RestAPI
    @DeleteMapping("/api/journalEntryLine/{id}")
    public String deleteJournalEntryLine(@PathVariable(value = "id") String journalEntryLineId){
        journalEntryLineService.deleteJournalEntryLine(journalEntryLineId);
        return "Journal Entry Line deleted successfully";
    }

    //build get cost center by Id RestAPI
    @GetMapping("/api/journalEntryLine/{id}")
    public ResponseEntity<JournalEntryLine> getJournalEntryLineById(@PathVariable(value = "id") String journalEntryLineId){
        return new ResponseEntity<JournalEntryLine>(journalEntryLineService.getJournalEntryLineById(journalEntryLineId),  HttpStatus.OK);
    }

    //build get all journal entry lines RestAPI
    @GetMapping("/api/journalEntryLines")
    public List<JournalEntryLine> getAllJournalEntryLines(){
        return journalEntryLineService.getAllJournalEntryLines();
    }


}
