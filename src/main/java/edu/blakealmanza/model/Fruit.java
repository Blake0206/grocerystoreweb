package edu.blakealmanza.model;

import java.time.LocalDate;

/**
 * The Fruit class represents a fruit in a store.
 * It extends the SalableProduct class and contains additional information
 * specific to fruits.
 */
public class Fruit extends Product {
    private String variety;
    private double weight;

    /**
     * Constructs a Fruit object with the specified parameters.
     *
     * @param id                the ID of the fruit
     * @param name              the name of the fruit
     * @param description       the description of the fruit
     * @param dateOfManufacture the date of manufacture of the fruit
     * @param price             the price of the fruit
     * @param variety           the variety of the fruit
     * @param weight            the weight of the fruit
     */
    public Fruit(String name, String description, LocalDate dateOfManufacture, double price, int quantity,
            String variety,
            double weight) {
        super(name, description, dateOfManufacture, price, quantity);
        this.variety = variety;
        this.weight = weight;
    }

    /**
     * Returns the variety of this fruit.
     *
     * @return the variety of this fruit
     */
    public String getVariety() {
        return variety;
    }

    /**
     * Returns the weight of this fruit.
     *
     * @return the weight of this fruit
     */
    public double getWeight() {
        return weight;
    }

}
