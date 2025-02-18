package edu.blakealmanza.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import edu.blakealmanza.models.Fruit;
import edu.blakealmanza.models.SalableProduct;
import edu.blakealmanza.models.Vegetable;
import edu.blakealmanza.models.Beverage;
import edu.blakealmanza.services.ProductWithQuantity;
import edu.blakealmanza.services.StoreFront;
import edu.blakealmanza.utils.IOUtilities;

/**
 * The ManagerActions class represents the actions that a store manager can
 * perform.
 * It provides methods to display the manager menu, view products, search for
 * products,
 * add products, remove products, update products, save inventory to file, and
 * load
 * inventory from file.
 */
public class ManagerActions {

  private StoreFront store;

  /**
   * Constructor for the ManagerActions class.
   *
   * @param store the StoreFront object containing the store's inventory and other
   *              relevant data.
   */
  public ManagerActions(StoreFront store) {
    this.store = store;
  }

  /**
   * Handles the manager actions for the store inventory management system.
   * Displays the manager menu to the user and prompts them to select an action.
   * Based on the user's choice, it performs the respective action such as viewing
   * products, searching for products, adding products, removing products,
   * updating
   * products, saving inventory to file, loading inventory from file, and exiting
   * the application.
   *
   * @param ioUtilities the ioUtilities object used to read input from the user.
   */
  public void handleManagerActions(IOUtilities ioUtilities) {
    int choice;
    do {
      displayManagerMenu();
      choice = ioUtilities.readInt("| Enter your choice: ", 0, 7, 51);
      System.out.println("====================================================\n");
      switch (choice) {
        case 1:
          viewProducts(store, ioUtilities);
          break;
        case 2:
          searchProducts(store, ioUtilities);
          break;
        case 3:
          addProduct(store, ioUtilities);
          break;
        case 4:
          removeProduct(store, ioUtilities);
          break;
        case 5:
          updateProduct(store, ioUtilities);
          break;
        case 6:
          saveInventoryToFile(store);
          break;
        case 7:
          loadInventoryFromFile(store);
          break;
        case 0:
          exit(ioUtilities);
          break;
      }

    } while (choice != 0);

    exit(ioUtilities); // Just in case someone gets here
  }

  /**
   * Displays the manager menu to the user.
   * The menu provides options for the following actions:
   * 1. View Products
   * 2. Search for a product by name or description
   * 3. Add Product to Inventory
   * 4. Remove Product from Inventory
   * 5. Update Product in Inventory
   * 6. Save Inventory to File
   * 7. Load Inventory from File
   * 0. Exit
   */
  private void displayManagerMenu() {
    System.out.println("\n\n====================================================");
    System.out.println("|               ---- Manager Menu ----             |");
    System.out.println("====================================================");
    System.out.printf("| %s ) %-44s |%n", "1", "View Products");
    System.out.printf("| %s ) %-44s |%n", "2", "Search for a product by name or description");
    System.out.printf("| %s ) %-44s |%n", "3", "Add Product to Inventory");
    System.out.printf("| %s ) %-44s |%n", "4", "Remove Product from Inventory");
    System.out.printf("| %s ) %-44s |%n", "5", "Update Product in Inventory");
    System.out.printf("| %s ) %-44s |%n", "6", "Save Inventory to File");
    System.out.printf("| %s ) %-44s |%n", "7", "Load Inventory from File");
    System.out.printf("| %s ) %-44s |%n", "0", "Exit");
    System.out.println("====================================================");
  }

  /**
   * Displays all the products in the store's inventory to the user in a tabular
   * format.
   * The products are retrieved from the inventory manager and sorted by ID before
   * being
   * displayed.
   *
   * @param store       the StoreFront object containing the store's inventory and
   *                    other relevant data.
   * @param ioUtilities the IOUtilities object used to print the product table to
   *                    the console.
   */
  private void viewProducts(StoreFront store, IOUtilities ioUtilities) {
    List<ProductWithQuantity> products = store.getInventoryManager().getAllProducts();
    ioUtilities.printProductTable(products);
  }

  /**
   * Searches for products in the store's inventory that match a given name
   * or description.
   *
   * @param store       the StoreFront object containing the store's inventory and
   *                    other relevant data.
   * @param ioUtilities the IOUtilities object containing the methods
   *                    for reading input from the user and printing the
   *                    product table to the console.
   */
  private void searchProducts(StoreFront store, IOUtilities ioUtilities) {
    List<ProductWithQuantity> matchingProducts = new ArrayList<ProductWithQuantity>();
    System.out.println("=============================================");
    System.out.println("|               Search Products             |");
    System.out.println("=============================================");
    System.out.printf("| %s ) %-37s |%n", "1", "Search by name");
    System.out.printf("| %s ) %-37s |%n", "2", "Search by description");
    System.out.println("---------------------------------------------");
    int choice = ioUtilities.readInt("| Enter your choice: ", 1, 2, 44);
    System.out.println("---------------------------------------------");
    String searchTerm = ioUtilities.readString("| Enter the search term: ", 44);
    System.out.println("=============================================\n");

    switch (choice) {
      case 1:
        matchingProducts = store.getInventoryManager().searchProductsByName(searchTerm);
        break;
      case 2:
        matchingProducts = store.getInventoryManager().searchProductsByDescription(searchTerm);
        break;
    }
    ioUtilities.printProductTable(matchingProducts);
  }

  /**
   * Adds a product to the store's inventory.
   * This method prompts the user to enter the type of product, name, description,
   * manufacture date, price, and quantity of the product to add.
   * It then creates a SalableProduct object based on the user's input and adds
   * it to the store's inventory.
   *
   * @param store       the StoreFront object containing the store's inventory and
   *                    other relevant data.
   * @param ioUtilities the IOUtilities object containing the methods
   *                    for reading input from the user and printing the
   *                    product table to the console.
   */
  private void addProduct(StoreFront store, IOUtilities ioUtilities) {
    SalableProduct salableProduct = null;
    System.out.println("==================================================================");
    System.out.println("|                            Add Product                         |");
    System.out.println("==================================================================");
    String type = ioUtilities.readString(String.format("| %-17s | ", "Type of Product"),
        List.of("fruit", "vegetable", "beverage"), 65);
    String name = ioUtilities.readString(String.format("| %-17s | ", "Name"), 65);
    String description = ioUtilities.readString(String.format("| %-17s | ", "Description"), 65);
    LocalDate date = ioUtilities.readDate(String.format("| %-17s | ", "Manufacture Date"), "MM-dd-yyyy", 65);
    double price = ioUtilities.readDouble(String.format("| %-17s | $", "Price (USD)"), 65);

    switch (type) {
      case "fruit":
        String variety = ioUtilities.readString(String.format("| %-17s | ", "Variety"), 65);
        double weight = ioUtilities.readDouble(String.format("| %-17s | ", "Weight (lbs)"), 65);

        salableProduct = new Fruit(name, description, date, price, variety, weight);
        break;

      case "vegetable":
        String vType = ioUtilities.readString(String.format("| %-17s | ", "Type"), 65);
        int calories = ioUtilities.readInt(String.format("| %-17s | ", "Calories"), 0, Integer.MAX_VALUE, 65);
        salableProduct = new Vegetable(name, description, date, price, vType, calories);
        break;

      case "beverage":
        int volume = ioUtilities.readInt(String.format("| %-17s | ", "Volume (ml)"), 0, Integer.MAX_VALUE, 65);
        boolean isCarbonated = ioUtilities.readBoolean(String.format("| %-17s | ", "Carbonated?"), 65);
        List<String> ingredients = ioUtilities.readStringList(String.format("| %-17s | ", "Ingredients"), 65);

        salableProduct = new Beverage(name, description, date, price, volume, isCarbonated, ingredients);
        break;
    }

    int quantity = ioUtilities.readInt(String.format("| %-17s | ", "Quantity"), 0, Integer.MAX_VALUE, 65);

    System.out.println("==================================================================");
    ProductWithQuantity productWithQuantity = new ProductWithQuantity(salableProduct, quantity);
    store.getInventoryManager().addProduct(productWithQuantity);
  }

  /**
   * Removes a product from the store's inventory.
   * This method prompts the user to enter the ID of the product to remove
   * and then removes it from the store's inventory.
   *
   * @param store       the StoreFront object containing the store's inventory and
   *                    other relevant data.
   * @param ioUtilities the IOUtilities object containing the methods
   *                    for reading input from the user and printing the
   *                    product table to the console.
   */
  private void removeProduct(StoreFront store, IOUtilities ioUtilities) {

    System.out.println("=============================================");
    System.out.println("|               Remove Product              |");
    System.out.println("=============================================");
    int id = ioUtilities.readInt("| Product ID: ", 1, store.getInventoryManager().getAllProducts().size(), 44);
    System.out.println("---------------------------------------------");

    ProductWithQuantity product = store.getInventoryManager().getProductById(id);
    store.getInventoryManager().removeProduct(product);

    System.out.printf("| %-41s |%n", "Product " + id + " was successfully removed");
    System.out.println("=============================================\n");

  }

  /**
   * Updates a product in the store's inventory.
   * This method prompts the user to enter the ID of the product to update
   * and then updates it in the store's inventory.
   *
   * @param store       the StoreFront object containing the store's inventory and
   *                    other relevant data.
   * @param ioUtilities the IOUtilities object containing the methods
   *                    for reading input from the user and printing the
   *                    product table to the console.
   */
  private void updateProduct(StoreFront store, IOUtilities ioUtilities) {
    System.out.println("\n===========================================================");
    System.out.println("|                      Update Product                     |");
    System.out.println("===========================================================");
    int id = 0;
    int counter = 0;
    ProductWithQuantity productWithQuantity = null;
    while (productWithQuantity == null) {
      String prompt = String.format("| %-17s | ", "Product ID");
      id = ioUtilities.readInt(prompt, 1, store.getInventoryManager().getAllProducts().size(), 58);
      productWithQuantity = store.getInventoryManager().getProductById(id);
      if (productWithQuantity == null) {
        if (counter > 0) {
          System.out.print("\033[F\033[F\033[K"); // Move up and clear line
        } else {
          System.out.print("\033[F\033[K"); // Move up and clear line
        }
        System.out.println("\033[31m" + prompt + id + " (item not found)"); // re-print line in red with error
        System.out.print("\033[F"); // Move cursor up
        System.out.print("\033[" + (58) + "C"); // Move cursor forward
        System.out.println("|\033[0m");
      }
      counter++;
    }

    SalableProduct product = productWithQuantity.getProduct();

    // General product info
    System.out.printf("| %-17s | %-35s |%n", "Name", product.getName());
    String name = ioUtilities.readString(String.format("| %-17s | ", "Name"), product.getName(), 58);

    System.out.printf("| %-17s | %-35s |%n", "Description", product.getDescription());
    String description = ioUtilities.readString(String.format("| %-17s | ", "Description"), product.getDescription(),
        58);

    System.out.printf("| %-17s | %-35s |%n", "Manufacture Date",
        product.getDateOfManufacture().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
    LocalDate date = ioUtilities.readDate(String.format("| %-17s | ", "Manufacture Date"), "MM-dd-yyyy",
        product.getDateOfManufacture(), 58);

    System.out.printf("| %-17s | $%-34s |%n", "Price (USD)", product.getPrice());
    double price = ioUtilities.readDouble(String.format("| %-17s | $", "Price (USD)"), product.getPrice(), 58);

    // Update product based on type
    if (product instanceof Fruit fruit) {
      System.out.printf("| %-17s | %-35s |%n", "Variety", fruit.getVariety());
      String variety = ioUtilities.readString(String.format("| %-17s | ", "Variety"), fruit.getVariety(), 58);
      System.out.printf("| %-17s | %-35s |%n", "Weight (lbs)", fruit.getWeight());
      double weight = ioUtilities.readDouble(String.format("| %-17s | ", "Weight (lbs)"), fruit.getWeight(), 58);

      product = new Fruit(name, description, date, price, variety, weight);
    } else if (product instanceof Vegetable vegetable) {
      System.out.printf("| %-17s | %-35s |%n", "Type", vegetable.getType());
      String type = ioUtilities.readString(String.format("| %-17s | ", "Type"), vegetable.getType(), 58);
      System.out.printf("| %-17s | %-35s |%n", "Calories", vegetable.getCalories());
      int calories = ioUtilities.readInt(String.format("| %-17s | ", "Calories"), 0, Integer.MAX_VALUE,
          vegetable.getCalories(), 58);

      product = new Vegetable(name, description, date, price, type, calories);
    } else if (product instanceof Beverage beverage) {
      System.out.printf("| %-17s | %-35s |%n", "Volume (ml)", beverage.getVolume());
      int volume = ioUtilities.readInt(String.format("| %-17s | ", "Volume (ml)"), 0, Integer.MAX_VALUE,
          beverage.getVolume(), 58);
      System.out.printf("| %-17s | %-35s |%n", "Carbonated?", beverage.isCarbonated() ? "Yes" : "No");
      boolean isCarbonated = ioUtilities.readBoolean(String.format("| %-17s | ", "Carbonated?"),
          beverage.isCarbonated(), 58);
      System.out.printf("| %-17s | %-35s |%n", "Ingredients", String.join(", ", beverage.getIngredients()));
      List<String> ingredients = ioUtilities.readStringList(String.format("| %-17s | ", "Ingredients"),
          beverage.getIngredients(), 58);

      product = new Beverage(name, description, date, price, volume, isCarbonated, ingredients);
    }

    System.out.printf("| %-17s | %-35s |%n", "Quantity", productWithQuantity.getQuantity());
    int quantity = ioUtilities.readInt(String.format("| %-17s | ", "Quantity"), 0, 999,
        productWithQuantity.getQuantity(), 58);

    System.out.println("===========================================================");

    // Save updates
    store.getInventoryManager().updateProduct(new ProductWithQuantity(product, quantity));

    System.out.printf("\033[32m| %-55s |\033[0m%n", "Product " + id + " was successfully updated");
    System.out.println("===========================================================");
  }

  /**
   * Saves the current inventory of the store to a file.
   * This method retrieves the inventory data from the StoreFront object
   * and writes it to a specified file, allowing for persistent storage
   * of inventory information.
   *
   * @param store the StoreFront object containing the store's inventory
   *              and other relevant data.
   */
  private void saveInventoryToFile(StoreFront store) {
    System.out.println("Saving inventory to file...");
  }

  /**
   * Loads the store's inventory from a file.
   * This method retrieves the inventory data from a specified file and
   * updates the store's inventory with the loaded data.
   *
   * @param store the StoreFront object containing the store's inventory
   *              and other relevant data.
   */
  private void loadInventoryFromFile(StoreFront store) {
    System.out.println("Loading inventory from file...");
  }

  /**
   * Exits the application with an option to save the inventory.
   * This method prompts the user to decide whether to save the current
   * inventory before exiting. If the user chooses to save, it invokes the
   * saveInventoryToFile method. It then displays an exit message and
   * terminates the program.
   *
   * @param ioUtilities the IOUtilities object used to read user input
   *                    and close the scanner before exiting.
   */
  private void exit(IOUtilities ioUtilities) {
    boolean saveOnExit = ioUtilities.readDecision("Do you want to save the inventory before exiting? (y/n): ");
    if (saveOnExit) {
      saveInventoryToFile(store);
    }
    System.out.println("Exiting...\n");
    ioUtilities.closeScanner();
    System.exit(0);
  }

}
