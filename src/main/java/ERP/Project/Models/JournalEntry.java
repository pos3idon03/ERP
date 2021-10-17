package ERP.Project.Models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "journalEntries")
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")
    private long id;
    @Column(name = "entryDate", nullable = false)
    private LocalDateTime journalDate;
    @Column(name = "recordDate", nullable = false)
    private LocalDateTime recordDate;
    @Column(name = "entryAmount", nullable = false)
    private long Amount;
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "accounts_id", referencedColumnName = "id")
    //private Account debitAccount;
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "accounts_id", referencedColumnName = "id")
    //private Account creditAccount;
    @OneToMany(mappedBy = "journalEntry", cascade = CascadeType.ALL)
    private List<Account> debitCreditAccount = new ArrayList<>();

}
