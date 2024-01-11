package larionov.homeWork.entities;

import com.github.javafaker.Faker;
import larionov.homeWork.DAO.PizzaService;
import larionov.homeWork.HomeWorkApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    PizzaService pizzaService;
    Faker faker = new Faker();
    Random rndm = new Random();

    public static AnnotationConfigApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        ctx = new AnnotationConfigApplicationContext(HomeWorkApplication.class);

        Pizza margherita = ctx.getBean("margherita", Pizza.class);
//        pizzaService.savePizza(margherita);
        for (int i = 0; i < 20; i++) {

            int numeroRandom = rndm.nextInt(1, 100);
            Pizza pizzaNuova = new Pizza(faker.name().name(), numeroRandom, numeroRandom);
//            pizzaService.savePizza(pizzaNuova);

        }

        pizzaService.filterByNome("margherita").forEach(System.out::println);

        pizzaService.filterByPrezzo(10).forEach(System.out::println);

    }
}
