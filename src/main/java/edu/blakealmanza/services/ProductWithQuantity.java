package edu.blakealmanza.services;

import edu.blakealmanza.models.SalableProduct;

/**
 * The ProductWithQuantity class represents a product with its quantity.
 * It contains information about the product and its quantity.
 */
public class ProductWithQuantity {

    private SalableProduct product;
    private int quantity;

    /**
     * Constructs a new ProductWithQuantity object with the given product and quantity.
     * @param product the product
     * @param quantity the quantity
     */
    public ProductWithQuantity(SalableProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Returns the ID of the product.
     * 
     * @return the ID of the product
     */
    public int getId() {
        return product.getId();
    }

    /**
     * Returns the product associated with this ProductWithQuantity.
     *
     * @return the product
     */
    public SalableProduct getProduct() {
        return product;
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
     * Returns a string representation of the ProductWithQuantity object.
     * The format includes the product, a space, the quantity (left-aligned in a 3-character space), and a space.
     * 
     * @return a string representation of the ProductWithQuantity
     */
    @Override
    public String toString() {
        return String.format("%s %-3d |", product, quantity);
    }

}
