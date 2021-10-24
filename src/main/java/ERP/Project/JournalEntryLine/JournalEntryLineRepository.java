package ERP.Project.JournalEntryLine;

import ERP.Project.JournalEntryLine.JournalEntryLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryLineRepository extends JpaRepository<JournalEntryLine, String> {
}
