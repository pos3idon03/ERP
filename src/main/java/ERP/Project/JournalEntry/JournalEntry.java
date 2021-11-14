package ERP.Project.JournalEntry;

import ERP.Project.CostCenter.CostCenter;
import ERP.Project.JournalEntryLine.JournalEntryLine;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
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
    private String Id;

    @Column(name = "PostedDate", nullable = false)
    private LocalDate Date = LocalDate.now();

    @Column(name = "RecordDate", nullable = false)
    private LocalDate RecordDate = LocalDate.now();

    @OneToMany (mappedBy = "journalEntry", cascade = CascadeType.ALL)
    @JsonManagedReference(value="journalEntry")
    private Set<JournalEntryLine> journalEntryLines;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "costCenterCodeId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value="costCenter")
    private CostCenter costCenter;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public LocalDate getRecordDate() {
        return RecordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        RecordDate = recordDate;
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