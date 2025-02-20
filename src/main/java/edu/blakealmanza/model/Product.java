package edu.blakealmanza.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The SalableProduct class represents a salable product in a store.
 * It contains information such as the product's ID, name, description,
 * date of manufacture, and price.
 */
@Document
public abstract class Product implements Comparable<Product> {
    /**
     * The ID of the product.
     */
    @Id
    protected String id;

    /**
     * The name of the product.
     */
    protected String name;

    /**
     * The description of the product.
     */
    protected String description;

    /**
     * The date of manufacture of the product.
     */
    protected LocalDate dateOfManufacture;

    /**
     * The price of the product.
     */
    protected double price;

    protected int quantity;

    public Product(String name, String description, LocalDate dateOfManufacture, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.dateOfManufacture = dateOfManufacture;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the ID of the product.
     *
     * @return the ID of the product
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the product.
     *
     * @return the description of the product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the date of manufacture of the product.
     *
     * @return the date of manufacture of the product
     */
    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    /**
     * Returns the price of the product.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the quantity of the product.
     *
     * @return the quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns a string representation of the SalableProduct object.
     * The format includes the product's ID, name, description, date of manufacture,
     * and price. The name and description are truncated to 15 and 35 characters,
     * respectively, with a trailing "..." if the original string was longer.
     * The date of manufacture is formatted as MM-dd-yyyy.
     *
     * @return a string representation of the SalableProduct
     */
    @Override
    public String toString() {

        if (name.length() > 15) {
            name = name.substring(0, 12) + "...";
        }

        if (description.length() > 35) {
            description = description.substring(0, 32) + "...";
        }

        String dateOfManufacture = this.dateOfManufacture.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        return String.format("| %-3s| %-15s | %-35s | %-10s | $%-6.2f |",
                id, name, description, dateOfManufacture, price);
    }

    /**
     * Compares this SalableProduct with the specified SalableProduct for order.
     * Returns a negative integer, zero, or a positive integer as this product
     * is less than, equal to, or greater than the specified product in price.
     *
     * @param other the SalableProduct to be compared
     * @return a negative integer, zero, or a positive integer as this product
     *         is less than, equal to, or greater than the price of the
     *         specified product
     */
    @Override
    public int compareTo(Product other) {
        if (this.price > other.price) {
            return 1;
        } else if (this.price < other.price) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Returns a hash code for this SalableProduct.
     *
     * @return a hash code for this SalableProduct
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id.length();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((dateOfManufacture == null) ? 0 : dateOfManufacture.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Indicates whether some other object is "equal to" this SalableProduct.
     * To be equal, the other object must be a SalableProduct with the same
     * ID as this SalableProduct.
     *
     * @param obj the object to compare with this SalableProduct
     * @return true if the specified object is equal to this SalableProduct
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (dateOfManufacture == null) {
            if (other.dateOfManufacture != null)
                return false;
        } else if (!dateOfManufacture.equals(other.dateOfManufacture))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        return true;
    }

}
