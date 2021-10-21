package ERP.Project.Repositories;

import ERP.Project.Models.JournalEntryLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryLineRepository extends JpaRepository<JournalEntryLine, String> {
}
