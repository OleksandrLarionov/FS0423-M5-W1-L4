package larionov.homeWork.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "pizze")
public class Pizza {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String base;
    private Double prezzo;
    private Integer calorie;

    public Pizza(String nome, double prezzo, int calorie) {
        this.calorie = calorie;
        this.nome = nome;
        this.base = "Mozzarella e Pommidoro";
        this.prezzo = prezzo;
    }
}
