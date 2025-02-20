package edu.blakealmanza.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.blakealmanza.model.Product;
import edu.blakealmanza.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
        // InventoryManager inventoryManager = new InventoryManager(true);
        // return inventoryManager.getAllProducts();
    }
}
