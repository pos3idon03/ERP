package ERP.Project.TrialBalance;

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
    private String Status;

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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
