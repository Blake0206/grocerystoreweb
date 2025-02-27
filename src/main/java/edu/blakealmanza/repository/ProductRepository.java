package edu.blakealmanza.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.blakealmanza.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findProductByNameContaining(String searchTerm);

}
