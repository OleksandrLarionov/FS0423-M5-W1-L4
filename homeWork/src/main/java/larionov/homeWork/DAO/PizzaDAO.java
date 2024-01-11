package larionov.homeWork.DAO;

import larionov.homeWork.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaDAO extends JpaRepository<Pizza, Long> {
    List<Pizza> findByNome(String nome);
    List<Pizza> findByBase(String base);
    List<Pizza> findByCalorie(int calorie);
}
