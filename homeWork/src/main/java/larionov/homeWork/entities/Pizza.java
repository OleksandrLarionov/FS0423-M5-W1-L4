package larionov.homeWork.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("pizza")
public class Pizza extends MenuItem {
    private String base;

    @ManyToMany
    @JoinTable(
            name = "menu_item_pizza", // Nome della tabella nel database
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private List<MenuItem> menuItems;

    @ManyToMany
    @JoinTable(
            name = "pizza_condimenti", // Nome della tabella nel database
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "condimento_id")
    )
    private List<Condimenti> condimentiList;

    public Pizza(String nome, double prezzo, int calorie) {
        super(nome, prezzo, calorie);
        this.base = "Mozzarella e Pommidoro";
        this.condimentiList = new ArrayList<>();
    }

    public void aggiungiIlCondimentoAllaPizza(Condimenti condimento){
        condimentiList.add(condimento);
    }
    @Override
    public String toString() {
        return "Pizza{" +
                "menuItems=" + getNome() +
                '}';
    }
}
