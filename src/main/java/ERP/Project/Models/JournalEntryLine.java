package ERP.Project.Models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class JournalEntryLine {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long journalEntryLineId;
    @Column(name = "amount")
    private Float amount;
    @ManyToOne
    @JoinColumn(name = "accountCode", nullable = false)
    private Account account;
    @ManyToOne
    @JoinColumn(name = "journalEntryId", nullable = false)
    private JournalEntry journalEntry;

}
