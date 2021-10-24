package ERP.Project.CostCenter;

import ERP.Project.CostCenter.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostCenterRepository extends JpaRepository<CostCenter, String> {
}
