package larionov.homeWork.entities;

import larionov.homeWork.DAO.PizzaService;
import larionov.homeWork.HomeWorkApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    PizzaService pizzaService;
    public static AnnotationConfigApplicationContext ctx;
    @Override
    public void run(String... args) throws Exception {
        ctx = new AnnotationConfigApplicationContext(HomeWorkApplication.class);

        Pizza margherita = ctx.getBean("margherita", Pizza.class);
        for(int i=0 ; i < 20; i++){
        pizzaService.savePizza(margherita);

        }

        pizzaService.filterByNome("margherita").forEach(System.out::println);
        pizzaService.filterByBase("Mozzarella e Pommidoro").forEach(System.out::println);

    }
}
