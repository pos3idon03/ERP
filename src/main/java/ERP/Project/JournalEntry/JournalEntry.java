package ERP.Project.JournalEntry;

import ERP.Project.CostCenter.CostCenter;
import ERP.Project.JournalEntryLine.JournalEntryLine;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "journalEntries")
public class JournalEntry implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "journalEntryKey")
    private String journalEntryId;
    @Column(name = "journalEntryDate", nullable = false)
    private LocalDateTime journalEntryDate = LocalDateTime.now();
    @Column(name = "journalEntryRecordDate", nullable = false)
    private LocalDateTime journalEntryRecordDate = LocalDateTime.now();
    @OneToMany(mappedBy = "journalEntry")
    private Set<JournalEntryLine> journalEntryLines;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "costCenterCodeId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CostCenter costCenter;

    public LocalDateTime getJournalEntryDate() {
        return journalEntryDate;
    }

    public void setJournalEntryDate(LocalDateTime journalEntryDate) {
        this.journalEntryDate = journalEntryDate;
    }

    public LocalDateTime getJournalEntryRecordDate() {
        return journalEntryRecordDate;
    }

    public void setJournalEntryRecordDate(LocalDateTime journalEntryRecordDate) {
        this.journalEntryRecordDate = journalEntryRecordDate;
    }

    public Set<JournalEntryLine> getJournalEntryLines() {
        return journalEntryLines;
    }

    public void setJournalEntryLines(Set<JournalEntryLine> journalEntryLines) {
        this.journalEntryLines = journalEntryLines;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }
}