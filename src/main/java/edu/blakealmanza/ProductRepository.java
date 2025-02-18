package edu.blakealmanza;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.blakealmanza.services.ProductWithQuantity;

public interface ProductRepository extends MongoRepository<ProductWithQuantity, String> {

  Optional<ProductWithQuantity> findProductWithQuantityByProduct_NameContaining(String searchTerm);

}
