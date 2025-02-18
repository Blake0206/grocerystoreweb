package edu.blakealmanza.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.blakealmanza.models.Beverage;
import edu.blakealmanza.models.Fruit;
import edu.blakealmanza.models.SalableProduct;
import edu.blakealmanza.models.Vegetable;

/**
 * The InventoryManager class is responsible for managing the store's inventory.
 * It provides methods to add, remove, and retrieve products from the inventory.
 */
public class InventoryManager {

  private List<ProductWithQuantity> inventoryList;

  /**
   * Constructor for the InventoryManager class.
   * 
   * @param shouldInitialize true if the inventory should be initialized with
   *                         sample data, false otherwise
   */
  public InventoryManager(Boolean shouldInitialize) {
    inventoryList = new ArrayList<ProductWithQuantity>();
    if (shouldInitialize) {
      initializeInventory();
    }
  }

  /**
   * Initializes the inventory with a predefined set of sample products.
   * This method adds a variety of fruits, vegetables, and beverages
   * with specific attributes and quantities to the inventory list.
   */
  private void initializeInventory() {
    SalableProduct product1 = new Fruit("Apple", "Fresh and juicy apples", LocalDate.now(), 1.99, "Red Delicious", 1.5);
    SalableProduct product2 = new Fruit("Banana", "Ripe and sweet bananas", LocalDate.now(), 0.99, "Yellow", 0.5);

    SalableProduct product3 = new Vegetable("Carrot", "Crunchy and sweet carrots", LocalDate.now(), 0.79, "Orange", 23);
    SalableProduct product4 = new Vegetable("Broccoli", "Fresh and nutritious broccoli", LocalDate.now(), 1.29, "Green",
        42);

    SalableProduct product5 = new Beverage("Soda", "Fizzy and refreshing soda", LocalDate.now(), 1.99, 60, true,
        new ArrayList<String>() {
          {
            add("Sugar");
            add("Flavoring");
          }
        });
    SalableProduct product6 = new Beverage("Juice", "Freshly squeezed orange juice", LocalDate.now(), 2.49, 100, false,
        new ArrayList<String>() {
          {
            add("Oranges");
            add("Sugar");
          }
        });

    inventoryList.add(new ProductWithQuantity(product1, 3));
    inventoryList.add(new ProductWithQuantity(product2, 1));
    inventoryList.add(new ProductWithQuantity(product3, 7));
    inventoryList.add(new ProductWithQuantity(product4, 2));
    inventoryList.add(new ProductWithQuantity(product5, 9));
    inventoryList.add(new ProductWithQuantity(product6, 5));
  }

  /**
   * Retrieves all products in the inventory with their respective quantities.
   *
   * @return a list of ProductWithQuantity objects representing the inventory
   */
  public List<ProductWithQuantity> getAllProducts() {
    return inventoryList;
  }

  /**
   * Retrieves a product with its quantity from the inventory by its ID.
   *
   * @param id the ID of the product to search for
   * @return a ProductWithQuantity object if found, null otherwise
   */
  public ProductWithQuantity getProductById(int id) {
    for (ProductWithQuantity product : inventoryList) {
      if (product.getProduct().getId() == id) {
        return product;
      }
    }
    return null;
  }

  /**
   * Searches for products in the inventory by their name.
   *
   * @param searchTerm the search term to look for in the product names
   * @return a list of ProductWithQuantity objects matching the search term
   */
  public List<ProductWithQuantity> searchProductsByName(String searchTerm) {
    List<ProductWithQuantity> matchingProducts = new ArrayList<ProductWithQuantity>();
    for (ProductWithQuantity product : inventoryList) {
      if (product.getProduct().getName().toLowerCase().contains(searchTerm.toLowerCase())) {
        matchingProducts.add(product);
      }
    }
    return matchingProducts;
  }

  /**
   * Searches for products in the inventory by their description.
   *
   * @param searchTerm the search term to look for in the product descriptions
   * @return a list of ProductWithQuantity objects matching the search term
   */
  public List<ProductWithQuantity> searchProductsByDescription(String searchTerm) {
    List<ProductWithQuantity> matchingProducts = new ArrayList<ProductWithQuantity>();
    for (ProductWithQuantity product : inventoryList) {
      if (product.getProduct().getDescription().toLowerCase().contains(searchTerm.toLowerCase())) {
        matchingProducts.add(product);
      }
    }
    return matchingProducts;
  }

  /**
   * Updates the quantity of a product in the inventory.
   *
   * @param product the ProductWithQuantity object containing the ID and new
   *                quantity of the product to update
   * @return the updated list of ProductWithQuantity objects, or null if the
   *         product was not found
   */
  public List<ProductWithQuantity> updateProduct(ProductWithQuantity product) {
    for (int i = 0; i < inventoryList.size(); i++) {
      if (inventoryList.get(i).getProduct().getId() == product.getProduct().getId()) {
        inventoryList.set(i, product);
        return inventoryList;
      }
    }
    return null;
  }

  /**
   * Removes a product from the inventory.
   *
   * @param product the ProductWithQuantity object to remove
   * @return the updated list of ProductWithQuantity objects, or null if the
   *         product was not found
   */
  public List<ProductWithQuantity> removeProduct(ProductWithQuantity product) {
    inventoryList.remove(product);
    return inventoryList;
  }

  /**
   * Adds a product to the inventory.
   *
   * @param product the ProductWithQuantity object to add
   * @return the updated list of ProductWithQuantity objects
   */
  public List<ProductWithQuantity> addProduct(ProductWithQuantity product) {
    inventoryList.add(product);
    return inventoryList;
  }

  /**
   * Removes all products from the inventory.
   *
   * @return the now empty list of ProductWithQuantity objects
   */
  public List<ProductWithQuantity> clearInventory() {
    inventoryList.clear();
    return inventoryList;
  }
}
