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
    private String Id;
    @Column (name = "Code")
    private String Code;
    @Column (name = "Description")
    private String Description;
    @Column (name = "CreationDate")
    private LocalDate CreationDate = LocalDate.now();
    @OneToMany (mappedBy = "costCenter", cascade = CascadeType.ALL)
    @JsonManagedReference(value="costCenter")
    private Set<JournalEntry> journalEntries;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    public Set<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public void setJournalEntries(Set<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }
}
