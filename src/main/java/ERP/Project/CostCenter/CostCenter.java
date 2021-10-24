package ERP.Project.CostCenter;

import ERP.Project.JournalEntry.JournalEntry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "costCenters")
public class CostCenter implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "costCenterKey")
    private String costCenterCodeId;
    @Column (name = "costCenterCode")
    private String costCenterCode;
    @Column (name = "costCenterDescription")
    private String costCenterDescription;
    @Column (name = "costCenterCreationDate")
    private LocalDateTime costCenterCreationDate = LocalDateTime.now();
    @OneToMany (mappedBy = "costCenter",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private Set<JournalEntry> journalEntries;

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getCostCenterDescription() {
        return costCenterDescription;
    }

    public void setCostCenterDescription(String costCenterDescription) {
        this.costCenterDescription = costCenterDescription;
    }

    public LocalDateTime getCostCenterCreationDate() {
        return costCenterCreationDate;
    }

    public void setCostCenterCreationDate(LocalDateTime costCenterCreationDate) {
        this.costCenterCreationDate = costCenterCreationDate;
    }

    public Set<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(Set<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }
}
