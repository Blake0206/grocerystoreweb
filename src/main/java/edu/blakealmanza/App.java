package edu.blakealmanza;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.blakealmanza.models.Beverage;
import edu.blakealmanza.models.Fruit;
import edu.blakealmanza.services.ProductWithQuantity;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Bean
  CommandLineRunner runner(ProductRepository repository) {
    return _ -> {
      ProductWithQuantity product1 = new ProductWithQuantity(
          new Fruit("Apple", "Fresh and juicy apples", LocalDate.now(), 1.99, "Red Delicious", 1.5), 2);

      ProductWithQuantity product2 = new ProductWithQuantity(
          new Beverage("Soda", "Tasty soda", LocalDate.now(), 1.99, 60, true, new ArrayList<String>()), 99);

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
