package ERP.Project.JournalEntryLine;

import ERP.Project.JournalEntryLine.JournalEntryLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalEntryLineRepository extends JpaRepository<JournalEntryLine, String> {

}
