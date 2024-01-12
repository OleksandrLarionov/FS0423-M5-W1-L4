package larionov.homeWork.DAO;

import larionov.homeWork.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemDAO extends JpaRepository<MenuItem, Long> {
}
