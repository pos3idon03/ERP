package ERP.Project.Models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "costCenters")
public class CostCenter {
    @Id
    @Column (name = "costCenterCode")
    private String costCenterCode;
    @Column (name = "description")
    private String description;
    @Column (name = "creationDate")
    private LocalDateTime creationDate;
    @OneToMany (mappedBy = "costCenter")
    private Set<JournalEntry> journalEntries;

}
