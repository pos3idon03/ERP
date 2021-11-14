package ERP.Project.TrialBalance;

import ERP.Project.Enums.Status;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class TrialBalance {
    private LocalDate startDate;
    private LocalDate endDate;
    private Map<String,Long> figures;
    private Status Status;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Map<String, Long> getFigures() {
        return figures;
    }
    public void setFigures(Map<String, Long> figures) {
        this.figures = figures;
    }

    public ERP.Project.Enums.Status getStatus() {
        return Status;
    }

    public void setStatus(ERP.Project.Enums.Status status) {
        Status = status;
    }
}
