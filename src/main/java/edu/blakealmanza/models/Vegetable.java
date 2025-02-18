package edu.blakealmanza.models;

import java.time.LocalDate;

/**
 * The Vegetable class represents a vegetable in a store.
 * It extends the SalableProduct class and contains additional information
 * specific to vegetables.
 */
public class Vegetable extends SalableProduct {
  private String type;
  private int calories;

  /**
   * Constructs a new Vegetable object with the given information.
   *
   * @param id                the ID of the vegetable
   * @param name              the name of the vegetable
   * @param description       the description of the vegetable
   * @param dateOfManufacture the date of manufacture of the vegetable
   * @param price             the price of the vegetable
   * @param type              the type of the vegetable
   * @param calories          the number of calories in the vegetable
   */
  public Vegetable(String name, String description, LocalDate dateOfManufacture, double price, String type,
      int calories) {
    super(name, description, dateOfManufacture, price);
    this.type = type;
    this.calories = calories;
  }

  /**
   * Returns the type of the vegetable.
   *
   * @return a String representing the type of the vegetable
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the number of calories in the vegetable.
   *
   * @return an int representing the number of calories in the vegetable
   */
  public int getCalories() {
    return calories;
  }
}
