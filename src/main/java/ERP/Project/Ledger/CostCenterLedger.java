package ERP.Project.Ledger;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class CostCenterLedger {
    private LocalDate startDate;
    private LocalDate endDate;
}
