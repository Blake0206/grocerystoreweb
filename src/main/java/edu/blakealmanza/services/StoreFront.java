package edu.blakealmanza.services;

/**
 * The StoreFront class represents a store front with an inventory manager.
 * It provides methods to get the inventory manager, save inventory to file,
 * and load inventory from file.
 */
public class StoreFront {
    private InventoryManager inventoryManager;
    
    /**
     * Constructs a new StoreFront object with an empty inventory manager.
     */
    public StoreFront() {
        this.inventoryManager = new InventoryManager(true);
    }

    /**
     * Returns the inventory manager associated with the store front.
     *
     * @return the InventoryManager object managing the store's inventory.
     */
    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    /**
     * Saves the store's inventory to a file with the given name.
     * @param fileName the name of the file to which the inventory should be saved.
     * @return true if the file was saved successfully, false otherwise.
     */
    public boolean saveInventoryToFile(String fileName) {
        return false;
    }

    /**
     * Loads the store's inventory from a file with the given name.
     * If the file is successfully loaded, updates the inventory manager
     * with the new inventory data.
     *
     * @param fileName the name of the file from which the inventory should be loaded.
     * @return true if the inventory was loaded successfully, false otherwise.
     */
    public boolean loadInventoryFromFile(String fileName) {
        return false;
    }
    
}
