package ERP.Project.Models;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class JournalEntryLine {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ENTRYLINE_PR_KEY")
    private String journalEntryLineId;
    @Column(name = "amount")
    private Float amount;
    @ManyToOne
    @JoinColumn(name = "accountCodeId", nullable = false)
    private Account account;
    @ManyToOne
    @JoinColumn(name = "journalEntryId", nullable = false)
    private JournalEntry journalEntry;

}
