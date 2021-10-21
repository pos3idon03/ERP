package ERP.Project.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "accountCode", nullable = false)
    private String accountCode;
    @Column(name = "description", nullable = false)
    private String accountDescription;
    @OneToMany(mappedBy = "account")
    private Set<JournalEntryLine> journalEntryLines;
}
