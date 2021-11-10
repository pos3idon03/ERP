package ERP.Project.JournalEntry;

import ERP.Project.CostCenter.CostCenter;
import ERP.Project.JournalEntryLine.JournalEntryLine;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "journalEntries")
@JsonTypeName("journal entry")
public class JournalEntry implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "journalEntryKey")
    private String journalEntryId;

    @Column(name = "journalEntryDate", nullable = false)
    private LocalDate journalEntryDate = LocalDate.now();

    @Column(name = "journalEntryRecordDate", nullable = false)
    private LocalDate journalEntryRecordDate = LocalDate.now();

    @OneToMany(mappedBy = "journalEntry")
    @JsonManagedReference
    private Set<JournalEntryLine> journalEntryLines;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "costCenterCodeId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value="costCenter")
    private CostCenter costCenter;

    public LocalDate getJournalEntryDate() {
        return journalEntryDate;
    }

    public void setJournalEntryDate(LocalDate journalEntryDate) {
        this.journalEntryDate = journalEntryDate;
    }

    public LocalDate getJournalEntryRecordDate() {
        return journalEntryRecordDate;
    }

    public void setJournalEntryRecordDate(LocalDate journalEntryRecordDate) {
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