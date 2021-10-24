package ERP.Project.JournalEntryLine;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JournalEntryLineController {
    private JournalEntryLineService journalEntryLineService;

    public JournalEntryLineController(JournalEntryLineService journalEntryLineService) {
        this.journalEntryLineService = journalEntryLineService;
    }

    @PostMapping("/api/{journalEntryId}/{accountId}/journalEntryLine")
    public ResponseEntity<JournalEntryLine> createJournalEntryLine(@PathVariable (value = "journalEntryId") String journalEntryId,
                                                                   @PathVariable (value = "accountId") String accountId,
                                                                   @RequestBody JournalEntryLine journalEntryLine ){
        return new ResponseEntity<JournalEntryLine>(journalEntryLineService.saveJournalEntryLine(journalEntryLine, journalEntryId, accountId), HttpStatus.CREATED);
    }
    //build update cost center RestAPI
    //build delete cost center RestAPI
    //build get cost center by Id RestAPI
    //build get all cost center RestAPI
}
