package larionov.homeWork.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("condimenti")
public class Condimenti extends MenuItem{

    @ManyToMany
    @JoinTable(
            name = "menu_item_condimenti", // Nome della tabella nel database
            joinColumns = @JoinColumn(name = "condimenti_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private List<MenuItem> menuItems;

    @ManyToMany(mappedBy = "condimentiList")
    private List<Pizza> pizzaList;
    public Condimenti(String nome, double prezzo, int calorie) {
        super(nome, prezzo, calorie);
    }

    public String getNomeCondimento() {
        return getNome();
    }

    @Override
    public String toString() {
        return getNome() + ": " + " Calorie: " + getCalorie() + " kal. " + "Supplemento: " + getPrezzo() + " Euro\n";
    }
}