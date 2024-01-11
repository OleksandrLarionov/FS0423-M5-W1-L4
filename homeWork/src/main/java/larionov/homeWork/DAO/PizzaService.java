package larionov.homeWork.DAO;

import larionov.homeWork.entities.Pizza;

import larionov.homeWork.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaService {
    @Autowired
    private PizzaDAO pizzaDAO;

    public void savePizza(Pizza pizza){
        pizzaDAO.save(pizza);
        log.info("La pizza è stata salvata correttamente nel DB");
    }

    public Pizza findById(long id) throws ItemNotFoundException {
        return pizzaDAO.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }
    public List<Pizza> findAll() {
        return pizzaDAO.findAll();
    }

    public void findByIdAndDelete(long id) {
        Pizza found = this.findById(id);
        pizzaDAO.delete(found);
        log.info("Pizza con id " + id + " eliminata con successo!");
    }
    public void findByIdAndUpdate(long id, Pizza pizza) {
        // 1. Cerco lo pizza per id
        Pizza found = this.findById(id);
        // 2. Aggiorno i dati con quelli passati come parametro di questo metodo
        found.setBase(pizza.getBase());
        found.setNome(pizza.getNome());
        found.setPrezzo(pizza.getPrezzo());
        found.setCalorie(pizza.getCalorie());
        // 3. Risalvo le pizze modificate
        pizzaDAO.save(found);
        log.info("Pizza con id " + id + " aggiornata con successo!");
    }

    public long count(){
        return pizzaDAO.count();
    }

    public List<Pizza> filterByBase(String base) {
        return pizzaDAO.findByBase(base);
    }

    public List<Pizza> filterByNome(String nome) {
        return pizzaDAO.findByNome(nome);
    }

    public List<Pizza> filterByCalorie(int calorie) {
        return pizzaDAO.findByCalorie(calorie);
    }

public List<Pizza> filterByPrezzo(double prezzo) {return pizzaDAO.findByPrezzo(prezzo);}
}
