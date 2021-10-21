package ERP.Project.Models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
@Table(name = "journalEntries")
public class JournalEntry {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ENTRY_PR_KEY")
    private String journalEntryId;
    @Column(name = "entryDate", nullable = false)
    private LocalDateTime journalDate;
    @Column(name = "recordDate", nullable = false)
    private LocalDateTime recordDate;
    @OneToMany(mappedBy = "journalEntry")
    private Set<JournalEntryLine> journalEntryLines;
    @ManyToOne
    @JoinColumn(name = "costCenterCodeId", nullable = false)
    private CostCenter costCenter;
}