package ERP.Project.Models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
@Table(name = "journalEntries")
public class JournalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long journalEntryId;
    @Column(name = "entryDate", nullable = false)
    private LocalDateTime journalDate;
    @Column(name = "recordDate", nullable = false)
    private LocalDateTime recordDate;
    @OneToMany(mappedBy = "journalEntry")
    private Set<JournalEntryLine> journalEntryLines;
    @ManyToOne
    @JoinColumn(name = "costCenterCode", nullable = false)
    private CostCenter costCenter;
}