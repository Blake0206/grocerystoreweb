package edu.blakealmanza.model;

import java.time.LocalDate;
import java.util.List;

/**
 * The Beverage class represents a beverage in a store.
 * It extends the SalableProduct class and contains additional information
 * specific to beverages.
 */
public class Beverage extends Product {
    private int volume;
    private boolean isCarbonated;
    private List<String> ingredients;

    /**
     * Constructs a new Beverage object with the given information.
     *
     * @param id                the ID of the beverage
     * @param name              the name of the beverage
     * @param description       the description of the beverage
     * @param dateOfManufacture the date of manufacture of the beverage
     * @param price             the price of the beverage
     * @param volume            the volume of the beverage in milliliters
     * @param isCarbonated      true if the beverage is carbonated, false otherwise
     * @param ingredients       the list of ingredients of the beverage
     */
    public Beverage(String name, String description, LocalDate dateOfManufacture, double price, int quantity,
            int volume,
            boolean isCarbonated, List<String> ingredients) {
        super(name, description, dateOfManufacture, price, quantity);
        this.volume = volume;
        this.isCarbonated = isCarbonated;
        this.ingredients = ingredients;
    }

    /**
     * Gets the volume of this beverage in milliliters.
     *
     * @return volume of this beverage in milliliters
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Indicates whether this beverage is carbonated.
     *
     * @return true if the beverage is carbonated, false otherwise
     */
    public boolean isCarbonated() {
        return isCarbonated;
    }

    /**
     * Returns the list of ingredients of this beverage.
     *
     * @return the list of ingredients of this beverage
     */
    public List<String> getIngredients() {
        return ingredients;
    }

}
