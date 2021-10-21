package ERP.Project.Repositories;

import ERP.Project.Models.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, String> {
}
