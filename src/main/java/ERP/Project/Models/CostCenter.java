package ERP.Project.Models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "costCenters")
public class CostCenter {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "COSTCENTER_PR_KEY")
    private String costCenterCodeId;
    @Column (name = "costCenterCode")
    private String costCenterCode;
    @Column (name = "description")
    private String description;
    @Column (name = "creationDate")
    private LocalDateTime creationDate = LocalDateTime.now();
    @OneToMany (mappedBy = "costCenter")
    private Set<JournalEntry> journalEntries;
}
