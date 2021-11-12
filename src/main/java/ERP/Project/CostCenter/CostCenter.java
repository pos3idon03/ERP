package ERP.Project.CostCenter;

import ERP.Project.JournalEntry.JournalEntry;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "costCenters")
@JsonTypeName("cost center")
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
    private LocalDate costCenterCreationDate = LocalDate.now();
    @OneToMany (mappedBy = "costCenter", cascade = CascadeType.ALL)
    @JsonManagedReference(value="costCenter")
    private Set<JournalEntry> journalEntries;

    public String getCostCenterCodeId() {
        return costCenterCodeId;
    }

    public void setCostCenterCodeId(String costCenterCodeId) {
        this.costCenterCodeId = costCenterCodeId;
    }

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

    public LocalDate getCostCenterCreationDate() {
        return costCenterCreationDate;
    }

    public void setCostCenterCreationDate(LocalDate costCenterCreationDate) {
        this.costCenterCreationDate = costCenterCreationDate;
    }

    public Set<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(Set<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }
}
