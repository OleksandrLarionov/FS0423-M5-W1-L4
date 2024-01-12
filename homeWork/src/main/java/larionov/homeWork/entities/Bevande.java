package larionov.homeWork.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("bevande")
public class Bevande extends MenuItem{
    @ManyToMany
    @JoinTable(
            name = "menu_item_bevande", // Nome della tabella nel database
            joinColumns = @JoinColumn(name = "bevande_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private List<MenuItem> menuItems;
    public Bevande(String nome, double prezzo, int calorie) {
        super(nome, prezzo, calorie);
    }

    @Override
    public String toString() {
        return getNome() + " " + "Prezzo: " + getPrezzo() + " Euro\n";
    }
}
