package larionov.homeWork;

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
}
