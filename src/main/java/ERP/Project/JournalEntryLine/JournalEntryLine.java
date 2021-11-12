package ERP.Project.JournalEntryLine;


import ERP.Project.Account.Account;
import ERP.Project.JournalEntry.JournalEntry;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntryLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JELId")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "journalEntryId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value="journalEntry")
    private JournalEntry journalEntry;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "accountCodeId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference(value="account")
    private Account account;

    private Long amount;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public JournalEntry getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(JournalEntry journalEntry) {
        this.journalEntry = journalEntry;
    }
}
