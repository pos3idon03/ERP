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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getJournalDate() {
        return journalDate;
    }

    public void setJournalDate(LocalDateTime journalDate) {
        this.journalDate = journalDate;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }

    public ArrayList<Pair<String, Integer>> getDebitEntry() {
        return debitEntry;
    }

    public void setDebitEntry(ArrayList<Pair<String, Integer>> debitEntry) {
        this.debitEntry = debitEntry;
    }

    public ArrayList<Pair<String, Integer>> getCreditEntry() {
        return creditEntry;
    }

    public void setCreditEntry(ArrayList<Pair<String, Integer>> creditEntry) {
        this.creditEntry = creditEntry;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    @Column(name = "recordDate", nullable = false)
    private LocalDateTime recordDate;
    @Column(name = "debitData")
    private ArrayList<Pair<String, Integer>> debitEntry = new ArrayList<Pair<String, Integer>>();
    @Column(name = "creditData")
    private ArrayList<Pair<String, Integer>> creditEntry = new ArrayList<Pair<String, Integer>>();
    @Column(name = "costCenter")
    private String costCenter;
}