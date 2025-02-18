package edu.blakealmanza.controllers;

import edu.blakealmanza.services.StoreFront;
import edu.blakealmanza.utils.IOUtilities;

/**
 * The StartingActions class represents the initial actions of the application.
 * It provides methods to greet the user and prompt them to select their role,
 * either as a customer or a store manager. Based on the user's choice, it
 * initializes the respective actions for handling customer or manager
 * operations.
 */
public class StartingActions {

    /**
     * The start method serves as the entry point for the application.
     * It initializes the store inventory as an empty ArrayList of SalableProduct
     * objects and creates a StartingActions instance to begin the application.
     * The user is prompted to select their role, either as a customer or a 
     * store manager, and the respective actions are initialized.
     *
     * @param store the store inventory to be used in the application
     */
    public void start(StoreFront store) {
        IOUtilities ioUtilities = new IOUtilities();

        System.out.println("\n\n=============================================");
        System.out.println("|       ---- Welcome to the Store ----      |");
        System.out.println("|          Please select your role:         |");
        System.out.println("=============================================");
        System.out.printf("| %s ) %-37s |%n", "1", "Customer");
        System.out.printf("| %s ) %-37s |%n", "2", "Store Manager");
        System.out.println("=============================================");
        int choice = ioUtilities.readInt("| Enter your choice: ", 1, 2, 44);
        System.out.println("=============================================\n");

        if (choice == 1) {
            CustomerActions ca = new CustomerActions(store);
            ca.handleCustomerActions(ioUtilities);
        } else {
            ManagerActions ma = new ManagerActions(store);
            ma.handleManagerActions(ioUtilities);
        }
    }
}
