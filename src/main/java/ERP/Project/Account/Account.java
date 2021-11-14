package ERP.Project.Account;

import ERP.Project.JournalEntryLine.JournalEntryLine;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "accounts")
@JsonTypeName("accounts")
public class Account implements Serializable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "accountKey")
    private String Id;

    @Column(name = "accountCode", nullable = false)
    private String Code;

    @Column(name = "accountDescription", nullable = false)
    private String Description;

    @Column(name = "accountCreationDate")
    private LocalDate CreationDate = LocalDate.now();

    @OneToMany (mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference(value="account")
    Set<JournalEntryLine> journalEntryLines;

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

    public Set<JournalEntryLine> getJournalEntryLines() {
        return journalEntryLines;
    }

    public void setJournalEntryLines(Set<JournalEntryLine> journalEntryLines) {
        this.journalEntryLines = journalEntryLines;
    }
}
