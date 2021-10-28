package ERP.Project.Account;

import ERP.Project.JournalEntryLine.JournalEntryLine;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "accounts")
public class Account {
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
    private LocalDateTime accountCreationDate = LocalDateTime.now();
    @OneToMany(mappedBy = "account")
    private Set<JournalEntryLine> journalEntryLines;
}
