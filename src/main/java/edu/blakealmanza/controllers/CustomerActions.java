package edu.blakealmanza.controllers;

import edu.blakealmanza.services.StoreFront;
import edu.blakealmanza.utils.IOUtilities;

/**
 * The CustomerActions class represents the actions that a customer can perform.
 * It provides methods to display the customer menu, view products, search for
 * products, add products to the cart, remove products from the cart, view the
 * cart, and checkout.
 */
public class CustomerActions {

    private StoreFront store;

    /**
     * Constructor for the CustomerActions class.
     * @param store the StoreFront object containing the store's inventory and
     *              other relevant data.
     */
    public CustomerActions(StoreFront store) {
        this.store = store;
    }

    /**
     * Handles the customer actions for the store.
     * It will display the customer menu, handle the user's choice, and repeat
     * until the user chooses to exit.
     * @param ioUtilities the ioUtilities object containing the methods
     *                       for reading input from the user.
     */
    public void handleCustomerActions(IOUtilities ioUtilities) {
        int choice;
        do {
            displayCustomerMenu();
            choice = ioUtilities.readInt("Enter your choice: ", 0, 6);
            System.out.println();
            switch (choice) {
                case 1:
                    viewProducts(store);
                    break;
                case 2:
                    searchProducts(store);
                    break;
                case 3:
                    addToCart(store);
                    break;
                case 4:
                    removeFromCart(store);
                    break;
                case 5:
                    viewCart(store);
                    break;
                case 6:
                    checkout(store);
                    break;
                case 0:
                    exit(ioUtilities);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    /**
     * Displays the customer menu to the user.
     * The menu displays the following options:
     * 1. View Products
     * 2. Search for Product by name or description
     * 3. Add Product to Cart
     * 4. Remove Product from Cart
     * 5. View Cart
     * 6. Checkout
     * 0. Exit
     */
    private void displayCustomerMenu() {
        System.out.println("\n---- Customer Menu ----\n1. View Products\n2. Search for Product by name or description\n3. Add Product to Cart\n4. Remove Product from Cart\n5. View Cart\n6. Checkout\n0. Exit");
    }

    /**
     * Displays all the products in the store's inventory to the user.
     * @param store the StoreFront object containing the store's inventory and
     *              other relevant data.
     */
    private void viewProducts(StoreFront store) {
        System.out.println("Viewing products...");
    }

    /**
     * Searches for products in the store's inventory that match a given name
     * or description.
     * @param store the StoreFront object containing the store's inventory and
     *              other relevant data.
     */
    private void searchProducts(StoreFront store) {
        System.out.println("Searching for products...");
    }

    /**
     * Adds a product to the user's cart.
     * This method prompts the user to enter the ID of the product to add
     * and then adds it to the user's cart.
     * @param store the StoreFront object containing the store's inventory
     *              and other relevant data.
     */
    private void addToCart(StoreFront store) {
        System.out.println("Adding product to cart...");
    }

    /**
     * Removes a product from the user's cart.
     * This method prompts the user to enter the ID of the product to remove
     * and then removes it from the user's cart.
     * @param store the StoreFront object containing the store's inventory
     *              and other relevant data.
     */
    private void removeFromCart(StoreFront store) {
        System.out.println("Removing product from cart...");
    }

    /**
     * Displays the contents of the user's cart.
     * @param store the StoreFront object containing the store's inventory
     *              and other relevant data.
     */
    private void viewCart(StoreFront store) {
        System.out.println("Viewing cart...");
    }

    /**
     * Simulates the checkout process for the user.
     * This method will calculate the total cost of the items in the user's cart,
     * prompt the user for payment information, and then simulate the transaction
     * by printing a successful transaction message.
     * @param store the StoreFront object containing the store's inventory
     *              and other relevant data.
     */
    private void checkout(StoreFront store) {
        System.out.println("Checking out...");
    }

    /**
     * Exits the application.
     * This method displays an exit message and terminates the program.
     */
    private void exit(IOUtilities ioUtilities) {
        System.out.println("Exiting...\n");
        ioUtilities.closeScanner();
        System.exit(0);
    }
    
}
