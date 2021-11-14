package ERP.Project.CostCenter;

import ERP.Project.JournalEntry.JournalEntry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CostCenterLedger {
    private String CostCenter;
    private List<JournalEntry> journalEntry;

    public String getCostCenter() {
        return CostCenter;
    }

    public void setCostCenter(String costCenter) {
        CostCenter = costCenter;
    }

    public List<JournalEntry> getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(List<JournalEntry> journalEntry) {
        this.journalEntry = journalEntry;
    }
}
