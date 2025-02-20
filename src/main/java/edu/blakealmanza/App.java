package edu.blakealmanza;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.blakealmanza.model.Beverage;
import edu.blakealmanza.model.Fruit;
import edu.blakealmanza.model.Product;
import edu.blakealmanza.repository.ProductRepository;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository repository) {
        return _ -> {
            Product product1 = new Fruit("Apple", "Fresh and juicy apples", LocalDate.now(), 1.99, 3, "Red Delicious",
                    1.5);

            Product product2 = new Beverage("Soda", "Tasty soda", LocalDate.now(), 1.99, 5, 60, true,
                    new ArrayList<>(List.of("Sugar", "Carbonated Water")));

            repository.deleteAll();
            repository.insert(product1);
            repository.insert(product2);

            // repository.findProductWithQuantityByProduct_NameContaining("a").ifPresentOrElse(product
            // -> {
            // System.out.println(product + " was found");
            // }, () -> {
            // System.out.println("Product not found");
            // });
        };
    }

}
