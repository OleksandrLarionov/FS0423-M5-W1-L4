package larionov.homeWork;

import larionov.homeWork.entities.Bevande;
import larionov.homeWork.entities.Condimenti;
import larionov.homeWork.entities.Pizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class BeansConfiguration {
    @Bean
    Pizza margherita(){
        return new Pizza("Margherita", 25,2000);
    }
    @Bean
    Bevande fanta(){
        return new Bevande("Fanta",5,400);
    }
    @Bean
    Condimenti wurstell(){
        return new Condimenti("Wurstel", 0.50, 100);
    }

    @Bean
    Pizza margheritaConWurstell(){
        Pizza pizzaBase = margherita();
        pizzaBase.aggiungiIlCondimentoAllaPizza(wurstell());
        return pizzaBase;
    }
}
