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
    private String accountCodeId;

    @Column(name = "accountCode", nullable = false)
    private String accountCode;

    @Column(name = "accountDescription", nullable = false)
    private String accountDescription;

    @Column(name = "accountCreationDate")
    private LocalDate accountCreationDate = LocalDate.now();

    @OneToMany (mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference(value="account")
    Set<JournalEntryLine> journalEntryLines;

    public String getAccountCodeId() {
        return accountCodeId;
    }

    public void setAccountCodeId(String accountCodeId) {
        this.accountCodeId = accountCodeId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDate accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public Set<JournalEntryLine> getJournalEntryLines() {
        return journalEntryLines;
    }

    public void setJournalEntryLines(Set<JournalEntryLine> journalEntryLines) {
        this.journalEntryLines = journalEntryLines;
    }
}
