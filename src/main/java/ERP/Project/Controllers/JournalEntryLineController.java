package ERP.Project.Controllers;

import ERP.Project.Models.CostCenter;
import ERP.Project.Models.JournalEntryLine;
import ERP.Project.Services.JournalEntryLineService;
import ERP.Project.Services.JournalEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class JournalEntryLineController {
    private JournalEntryLineService journalEntryLineService;

    public JournalEntryLineController(JournalEntryLineService journalEntryLineService) {
        this.journalEntryLineService = journalEntryLineService;
    }

    //build create journal entry line RestAPI
    @PostMapping
    //http://localhost:8080/api/journalEntryLine
    public ResponseEntity<JournalEntryLine> createCostCenter(@RequestBody JournalEntryLine journalEntryLine){
        return new ResponseEntity<JournalEntryLine>(journalEntryLineService.saveJournalEntryLine(journalEntryLine), HttpStatus.CREATED);
    }
    //build update cost center RestAPI
    //build delete cost center RestAPI
    //build get cost center by Id RestAPI
    //build get all cost center RestAPI
}
