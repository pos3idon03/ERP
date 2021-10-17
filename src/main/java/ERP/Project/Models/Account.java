package ERP.Project.Models;

import lombok.Data;

import javax.persistence.*;


//@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "code", nullable = false)
    private String accountCode;
    @Column(name = "description", nullable = false)
    private String accountDescription;
    //@OneToOne(mappedBy = "debitAccount")
    //private JournalEntry journalEntryDebit;
    //@OneToOne(mappedBy = "creditAccount")
    //private JournalEntry journalEntryCredit;
    @ManyToOne
    @JoinColumn(name = "journalEntry_id", nullable = false)
    private JournalEntry journalEntry;

}
