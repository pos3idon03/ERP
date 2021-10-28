package ERP.Project.JournalEntryLine;


import ERP.Project.Account.Account;
import ERP.Project.JournalEntry.JournalEntry;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class JournalEntryLine {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "journalEntryLineKey")
    private String journalEntryLineId;
    @Column(name = "journalEntryLineAmount")
    private Float journalEntryLineAmount;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "accountCodeId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Account account;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "journalEntryId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JournalEntry journalEntry;

    public Float getJournalEntryLineAmount() {
        return journalEntryLineAmount;
    }

    public void setJournalEntryLineAmount(Float journalEntryLineAmount) {
        this.journalEntryLineAmount = journalEntryLineAmount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public JournalEntry getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(JournalEntry journalEntry) {
        this.journalEntry = journalEntry;
    }
}
