package ERP.Project.Models;

import lombok.Data;
import org.springframework.data.util.Pair;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "journalEntries")
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "entryDate", nullable = false)
    private LocalDateTime journalDate;
    @Column(name = "recordDate", nullable = false)
    private LocalDateTime recordDate;
    @Column(name = "debitData")
    private ArrayList<Pair<String, Integer>> debitEntry = new ArrayList<Pair<String, Integer>>();
    @Column(name = "creditData")
    private ArrayList<Pair<String, Integer>> creditEntry = new ArrayList<Pair<String, Integer>>();
    @Column(name = "costCenter")
    private String costCenter;
}