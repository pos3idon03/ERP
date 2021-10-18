package ERP.Project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

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
}
