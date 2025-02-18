package edu.blakealmanza.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.blakealmanza.ProductRepository;

@Service
public class ManagerService {

  private final ProductRepository productRepository;

  public ManagerService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<ProductWithQuantity> getAllProducts() {
    return productRepository.findAll();
    // InventoryManager inventoryManager = new InventoryManager(true);
    // return inventoryManager.getAllProducts();
  }
}
