package ERP.Project.Models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ACCOUNT_PR_KEY")
    private String accountCodeId;
    @Column(name = "accountCode", nullable = false)
    private String accountCode;
    @Column(name = "description", nullable = false)
    private String accountDescription;
    @Column(name = "creationDate")
    private LocalDateTime accountCreationDate = LocalDateTime.now();
    @OneToMany(mappedBy = "account")
    private Set<JournalEntryLine> journalEntryLines;
}
