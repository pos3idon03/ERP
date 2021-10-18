package ERP.Project.Repositories;

import ERP.Project.Models.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCenterRepository extends JpaRepository<CostCenter, String> {
}
