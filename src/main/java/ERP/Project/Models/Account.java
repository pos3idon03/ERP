package ERP.Project.Models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PR_KEY")
    private String accountCodeId;
    @Column(name = "accountCode", nullable = false)
    private String accountCode;
    @Column(name = "description", nullable = false)
    private String accountDescription;
    @OneToMany(mappedBy = "account")
    private Set<JournalEntryLine> journalEntryLines;
}
