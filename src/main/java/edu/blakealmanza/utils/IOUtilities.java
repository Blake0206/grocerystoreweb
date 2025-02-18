package edu.blakealmanza.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import edu.blakealmanza.services.ProductWithQuantity;
import edu.blakealmanza.services.StoreFront;

/**
 * Utility class for handling user input.
 */
public class IOUtilities {
    private Scanner scnr = new Scanner(System.in);

    /**
     * Prompts the user with a given message and then reads an integer
     * from the user. If the user enters something that is not an integer,
     * it will repeatedly prompt the user until they enter a valid integer.
     * @param prompt the message to display to the user
     * @return the integer entered by the user
     */
    public int readInt(String prompt) {
        int result = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(prompt);
                result = Integer.parseInt(scnr.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads an integer
     * from the user. If the user enters something that is not an integer,
     * it will repeatedly prompt the user until they enter a valid integer.
     * If the user enters nothing, it will default to the current integer.
     * @param prompt the message to display to the user
     * @param currentInt the current integer value
     * @return the integer entered by the user
     */
    public int readInt(String prompt, int currentInt) {
        int result = 0;
        boolean isValid = false;
        String input = "";
        while (!isValid) {
            try {
                System.out.print(prompt);
                input = scnr.nextLine().trim();
                if (input.isEmpty()) {
                    return currentInt;
                }
                result = Integer.parseInt(input);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads an integer
     * from the user within a given range. If the user enters something
     * that is not an integer, or if the integer is outside the given
     * range, it will repeatedly prompt the user until they enter a
     * valid integer.
     * @param prompt the message to display to the user
     * @param min the minimum value that the user can enter
     * @param max the maximum value that the user can enter
     * @return the integer entered by the user
     */
    public int readInt(String prompt, int min, int max) {
        int result = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(prompt);
                result = Integer.parseInt(scnr.nextLine());
                if (result >= min && result <= max) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads an integer
     * from the user within a given range. If the user enters something
     * that is not an integer, or if the integer is outside the given
     * range, it will repeatedly prompt the user until they enter a
     * valid integer.
     * @param prompt the message to display to the user
     * @param min the minimum value that the user can enter
     * @param max the maximum value that the user can enter
     * @param tableSpacing the spacing of the table that the input is being entered for
     * @return the integer entered by the user
     */
    public int readInt(String prompt, int min, int max, int tableSpacing) {
        int result = 0;
        boolean isValid = false;
        String stringInput = "";
        int counter = 0;
        while (!isValid) {
            try {
                System.out.print("\033[K"); // Clear line
                System.out.print(prompt);
                stringInput = scnr.nextLine().trim();
                result = Integer.parseInt(stringInput);
                if (result >= min && result <= max) {
                    if (counter > 0) {
                        System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                    } else {
                        System.out.print("\033[F\033[K"); // Move up and clear line
                    }
                    System.out.println("\033[32m" + prompt + stringInput); // re-print line in green
                    isValid = true;
                } else {
                    if (counter > 0) {
                        System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                    } else {
                        System.out.print("\033[F\033[K"); // Move up and clear line
                    }
                    System.out.println("\033[31m" + prompt + stringInput + String.format(" (not in range %d-%d)", min, max)); // re-print line in red with error
                }
            } catch (NumberFormatException e) {
                if (counter > 0) {
                    System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                } else {
                    System.out.print("\033[F\033[K"); // Move up and clear line
                }
                System.out.println("\033[31m" + prompt + stringInput + " (invalid int)"); // re-print line in red with error
            }
            System.out.print("\033[F"); // Move cursor up
            System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
            System.out.println("|\033[0m");
            counter ++;
        }
        
        return result;
    }


    /**
     * Prompts the user with a given message and then reads an integer
     * from the user within a given range. If the user enters something
     * that is not an integer, or if the integer is outside the given
     * range, it will repeatedly prompt the user until they enter a
     * valid integer. If the user enters nothing, it will default to the
     * current integer.
     * @param prompt the message to display to the user
     * @param min the minimum value that the user can enter
     * @param max the maximum value that the user can enter
     * @param currentInt the current integer value
     * @param tableSpacing the spacing of the table that the input is being entered for
     * @return the integer entered by the user
     */
    public int readInt(String prompt, int min, int max, int currentInt, int tableSpacing) {
        int result = 0;
        boolean isValid = false;
        String stringInput = "";
        while (!isValid) {
            try {
                System.out.print("\033[K"); // Clear line
                System.out.print(prompt);
                stringInput = scnr.nextLine().trim();
                if (stringInput.isEmpty()) {
                    System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                    System.out.println("\033[0m" + prompt + currentInt); // re-print line in white
                    System.out.print("\033[F"); // Move cursor up
                    System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
                    System.out.println("|\033[0m");
                    return currentInt;
                }
                result = Integer.parseInt(stringInput);
                if (result >= min && result <= max) {
                    System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                    System.out.println("\033[32m" + prompt + stringInput); // re-print line in green
                    isValid = true;
                } else {
                    System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                    System.out.println("\033[31m" + prompt + stringInput + String.format(" (not in range %d-%d)", min, max)); // re-print line in red with error
                }
            } catch (NumberFormatException e) {
                System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                System.out.println("\033[31m" + prompt + stringInput + " (invalid int)"); // re-print line in red with error
            }
            System.out.print("\033[F"); // Move cursor up
            System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
            System.out.println("|\033[0m");
            
        }
        
        return result;
    }



    /**
     * Prompts the user with a given message and then reads a boolean
     * value from the user. If the user enters something that is not
     * a boolean value, it will repeatedly prompt the user until they
     * enter a valid boolean value.
     * @param prompt the message to display to the user
     * @return the boolean value entered by the user
     */
    public boolean readBoolean(String prompt) {
        boolean result = false;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            String input = scnr.nextLine().trim().toLowerCase();
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                result = Boolean.parseBoolean(input);
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter either 'true' or 'false'.");
            }
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a boolean
     * value from the user. If the user enters something that is not
     * a boolean value, it will repeatedly prompt the user until they
     * enter a valid boolean value. The prompt is displayed in a table
     * with the given spacing.
     * @param prompt the message to display to the user
     * @param tableSpacing the spacing of the table
     * @return the boolean value entered by the user
     */
    public boolean readBoolean(String prompt, int tableSpacing) {
        boolean result = false;
        boolean isValid = false;
        String stringInput = "";
        while (!isValid) {
            System.out.print(prompt);
            stringInput = scnr.nextLine().trim().toLowerCase();
            if (stringInput.equalsIgnoreCase("true") || stringInput.equalsIgnoreCase("false")) {
                result = Boolean.parseBoolean(stringInput);
                isValid = true;
            } else {
                System.out.print("\033[F\033[K"); // Move up and clear line
                System.out.println("\033[31m" + prompt + stringInput + " (invalid boolean)"); // re-print line in red with error
            }
            System.out.print("\033[F"); // Move cursor up
            System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
            System.out.println("|\033[0m");
        }
    
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a boolean
     * value from the user. If the user enters something that is not
     * a boolean value, it will repeatedly prompt the user until they
     * enter a valid boolean value. The prompt is displayed in a table
     * with the given spacing. If the user enters nothing, their current
     * boolean value is returned.
     * @param prompt the message to display to the user
     * @param currentBoolean the user's current boolean value
     * @param tableSpacing the spacing of the table
     * @return the boolean value entered by the user
     */
    public boolean readBoolean(String prompt, boolean currentBoolean, int tableSpacing) {
        boolean result = false;
        boolean isValid = false;
        String stringInput = "";
        while (!isValid) {
            System.out.print("\033[K"); // Clear line
            System.out.print(prompt);
            stringInput = scnr.nextLine().trim().toLowerCase();
            if (stringInput.isEmpty()) {
                System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                System.out.println("\033[0m" + prompt + currentBoolean); // re-print line in white
                System.out.print("\033[F"); // Move cursor up
                System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
                System.out.println("|\033[0m");
                return currentBoolean;
            }
            if (stringInput.equalsIgnoreCase("true") || stringInput.equalsIgnoreCase("false")) {
                result = Boolean.parseBoolean(stringInput);
                System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                System.out.println("\033[32m" + prompt + stringInput); // re-print line in green
                isValid = true;
            } else {
                System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                System.out.println("\033[31m" + prompt + stringInput + " (invalid boolean)"); // re-print line in red with error
            }
            System.out.print("\033[F"); // Move cursor up
            System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
            System.out.println("|\033[0m");
        }
    
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a boolean
     * value from the user. If the user enters something that is not
     * a boolean value, it will repeatedly prompt the user until they
     * enter a valid boolean value. If the user enters nothing, their
     * current boolean value is returned.
     * @param prompt the message to display to the user
     * @param currentBoolean the user's current boolean value
     * @return the boolean value entered by the user or the current boolean if no input is provided
     */
    public boolean readBoolean(String prompt, boolean currentBoolean) {
        boolean result = false;
        String input = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            input = scnr.nextLine().trim().toLowerCase();
            if (input.isEmpty()) {
                return currentBoolean;
            }
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                result = Boolean.parseBoolean(input);
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter either 'true' or 'false'.");
            }
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a date
     * from the user. If the user enters something that is not a
     * valid date in the given pattern, it will repeatedly prompt the
     * user until they enter a valid date.
     * @param prompt the message to display to the user
     * @param pattern the pattern that the user's input should match
     * @return the date entered by the user
     */
    public LocalDate readDate(String prompt, String pattern) {
        LocalDate result = null;
        boolean isValid = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        while (!isValid) {
            try {
                System.out.print(prompt.split(":")[0] + " (format: " + pattern + "): ");
                result = LocalDate.parse(scnr.nextLine(), formatter);
                isValid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid input. Please enter a valid date in the format " + pattern + ".");
            }
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a date
     * from the user. If the user enters something that is not a
     * valid date in the given pattern, it will repeatedly prompt the
     * user until they enter a valid date.
     * @param prompt the message to display to the user
     * @param pattern the pattern that the user's input should match
     * @param tableSpacing the spacing of the table
     * @return the date entered by the user
     */
    public LocalDate readDate(String prompt, String pattern, int tableSpacing) {
        LocalDate result = null;
        boolean isValid = false;
        String stringInput = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        while (!isValid) {
            try {
                System.out.print(prompt);
                stringInput = scnr.nextLine().trim();
                result = LocalDate.parse(stringInput, formatter);
                isValid = true;
            } catch (DateTimeParseException e) {
                System.out.print("\033[F\033[K"); // Move up and clear line
                System.out.println("\033[31m" + prompt + stringInput + " (invalid date, " + pattern + ")"); // re-print line in red with error
            }
            System.out.print("\033[F"); // Move cursor up
            System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
            System.out.println("|\033[0m");
        }
        
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a date
     * from the user. If the user enters something that is not a
     * valid date in the given pattern, it will repeatedly prompt the
     * user until they enter a valid date.
     * @param prompt the message to display to the user
     * @param pattern the pattern that the user's input should match
     * @param currentDate the user's current date
     * @param tableSpacing the spacing of the table
     * @return the date entered by the user
     */
    public LocalDate readDate(String prompt, String pattern, LocalDate currentDate, int tableSpacing) {
        LocalDate result = null;
        boolean isValid = false;
        String stringInput = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        while (!isValid) {
            try {
                System.out.print("\033[K"); // Clear line
                System.out.print(prompt);
                stringInput = scnr.nextLine().trim();
                if (stringInput.isEmpty()) {
                    System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                    System.out.println("\033[0m" + prompt + currentDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"))); // re-print line in white
                    System.out.print("\033[F"); // Move cursor up
                    System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
                    System.out.println("|\033[0m");
                    return currentDate;
                }
                result = LocalDate.parse(stringInput, formatter);
                System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                System.out.println("\033[32m" + prompt + stringInput); // re-print line in green
                isValid = true;
            } catch (DateTimeParseException e) {
                System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                System.out.println("\033[31m" + prompt + stringInput + " (invalid date, " + pattern + ")"); // re-print line in red with error
            }
            System.out.print("\033[F"); // Move cursor up
            System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
            System.out.println("|\033[0m");
        }
        
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a date
     * from the user. If the user enters something that is not a
     * valid date in the given pattern, it will repeatedly prompt the
     * user until they enter a valid date.
     * @param prompt the message to display to the user
     * @param pattern the pattern that the user's input should match
     * @param currentDate the user's current date
     * @return the date entered by the user
     */
    public LocalDate readDate(String prompt, String pattern, LocalDate currentDate) {
        LocalDate result = null;
        boolean isValid = false;
        String input = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        while (!isValid) {
            try {
                System.out.print(prompt);
                input = scnr.nextLine().trim();
                if (input.isEmpty()) {
                    return currentDate;
                }
                result = LocalDate.parse(input, formatter);
                isValid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid input. Please enter a valid date in the format " + pattern + ".");
            }
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a boolean
     * value from the user indicating whether to save the inventory before
     * exiting. If the user enters something that is not a boolean value,
     * it will repeatedly prompt the user until they enter a valid boolean
     * value.
     * @param prompt the message to display to the user
     * @return true if the user wants to save the inventory, false otherwise
     */
    public boolean readDecision(String prompt) {
        boolean result = false;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            String input = scnr.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                result = true;
                isValid = true;
            } else if (input.equals("n") || input.equals("no")) {
                result = false;
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter either 'yes' or 'no'.");
            }
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a string
     * value from the user. The string value is trimmed before being
     * returned.
     * @param prompt the message to display to the user
     * @return the string value entered by the user
     */
    public String readString(String prompt) {
        System.out.print(prompt);
        return scnr.nextLine().trim();
    }

/**
 * Prompts the user with a given message and then reads a string
 * value from the user. After reading the input, moves the cursor
 * up and forward by the specified table spacing.
 * @param prompt the message to display to the user
 * @param tableSpacing the number of spaces to move the cursor forward
 * @return the string value entered by the user
 */

    public String readString(String prompt, int tableSpacing) {
        System.out.print(prompt);
        String input = scnr.nextLine().trim();
        System.out.print("\033[F"); // Move cursor up
        System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
        System.out.println("|");
        return input;
    }

    /**
     * Prompts the user with a given message and then reads a string
     * value from the user. If the user enters nothing, it will
     * re-print the current string value in white and return it.
     * If the user enters a string that is different from the current
     * string, it will re-print the line in green and return the new
     * string. After reading the input, moves the cursor up and forward
     * by the specified table spacing.
     * @param prompt the message to display to the user
     * @param currentString the current string value
     * @param tableSpacing the number of spaces to move the cursor forward
     * @return the string value entered by the user
     */
    public String readString(String prompt, String currentString, int tableSpacing) {
        System.out.print(prompt);
        String input = scnr.nextLine().trim();
        if (input.isEmpty()) {
            System.out.print("\033[F\033[F\033[K"); // Move up and clear line
            System.out.println("\033[0m" + prompt + currentString); // re-print line in white
            System.out.print("\033[F"); // Move cursor up
            System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
            System.out.println("|\033[0m");
            return currentString;
        }
        if (!input.equals(currentString)) {
            System.out.print("\033[F\033[F\033[K"); // Move up and clear line
            System.out.println("\033[32m" + prompt + input); // re-print line in green
        }
        System.out.print("\033[F"); // Move cursor up
        System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
        System.out.println("|\033[0m");
        return input;
    }

    /**
     * Prompts the user with a given message and then reads a string
     * value from the user. If the user enters nothing, it will
     * return the current string value.
     * @param prompt the message to display to the user
     * @param currentString the current string value
     * @return the string value entered by the user
     */
    public String readString(String prompt, String currentString) {
        System.out.print(prompt);
        String result = scnr.nextLine().trim();
        if (result.isEmpty()) {
            return currentString;
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a string
     * value from the user. The user must enter one of the options
     * provided in the list of options. If the user enters something
     * that is not an option, it will repeatedly prompt the user until
     * they enter a valid option.
     * @param prompt the message to display to the user
     * @param options the list of options that the user can enter
     * @return the string value entered by the user
     */
    public String readString(String prompt, List<String> options) {
        String result = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt.split(":")[0] + " (" + String.join(", ", options) + "): ");
            String input = scnr.nextLine().trim().toLowerCase();
            for (String option : options) {
                if (input.equals(option)) {
                    result = option;
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                System.out.println("Invalid input. Please enter one of the following options: " + String.join(", ", options));
            }
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a string
     * value from the user. The user must enter one of the options
     * provided in the list of options. If the user enters something
     * that is not an option, it will repeatedly prompt the user until
     * they enter a valid option. After reading the input, moves the
     * cursor up and forward by the specified table spacing.
     * @param prompt the message to display to the user
     * @param options the list of options that the user can enter
     * @param tableSpacing the number of spaces to move the cursor forward
     * @return the string value entered by the user
     */
    public String readString(String prompt, List<String> options, int tableSpacing) {
        String result = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            String input = scnr.nextLine().trim().toLowerCase();
            for (String option : options) {
                if (input.equals(option)) {
                    result = option;
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                System.out.print("\033[F\033[K"); // Move up and clear line
                System.out.println("\033[31m" + prompt + input + " ('" + String.join("', ", options) + "')"); // re-print line in red with error
            }
            System.out.print("\033[F"); // Move cursor up
            System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
            System.out.println("|\033[0m");
        }
        
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a double
     * value from the user. If the user enters something that is not
     * a double value, it will repeatedly prompt the user until they
     * enter a valid double value.
     * @param prompt the message to display to the user
     * @return the double value entered by the user
     */
    public double readDouble(String prompt) {
        double result = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(prompt);
                result = Double.parseDouble(scnr.nextLine().trim());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid double.");
            }
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a double
     * value from the user. If the user enters something that is not
     * a double value, it will repeatedly prompt the user until they
     * enter a valid double value. After reading the input, moves the
     * cursor up and forward by the specified table spacing.
     * @param prompt the message to display to the user
     * @param tableSpacing the number of spaces to move the cursor forward
     * @return the double value entered by the user
     */
    public double readDouble(String prompt, int tableSpacing) {
        double result = 0;
        boolean isValid = false;
        String stringInput = "";
        while (!isValid) {
            try {
                System.out.print(prompt);
                stringInput = scnr.nextLine().trim();
                result = Double.parseDouble(stringInput);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.print("\033[F\033[K"); // Move up and clear line
                System.out.println("\033[31m" + prompt + stringInput + " (invalid double)"); // re-print line in red with error
            }
            System.out.print("\033[F"); // Move cursor up
            System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
            System.out.println("|\033[0m");
        }
        
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a double
     * value from the user. If the user enters something that is not
     * a double value, it will repeatedly prompt the user until they
     * enter a valid double value. After reading the input, moves the
     * cursor up and forward by the specified table spacing. If the
     * user enters nothing, the current double is returned.
     * @param prompt the message to display to the user
     * @param currentDouble the value to return if the user enters nothing
     * @param tableSpacing the number of spaces to move the cursor forward
     * @return the double value entered by the user
     */
    public double readDouble(String prompt, double currentDouble, int tableSpacing) {
        double result = 0;
        boolean isValid = false;
        String stringInput = "";
        while (!isValid) {
            try {
                System.out.print("\033[K"); // Clear line
                System.out.print(prompt);
                stringInput = scnr.nextLine().trim();
                if (stringInput.isEmpty()) {
                    System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                    System.out.println("\033[0m" + prompt + currentDouble); // re-print line in white
                    System.out.print("\033[F"); // Move cursor up
                    System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
                    System.out.println("|\033[0m");
                    return currentDouble;
                }
                result = Double.parseDouble(stringInput);
                System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                System.out.println("\033[32m" + prompt + stringInput); // re-print line in green
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.print("\033[F\033[F\033[K"); // Move up and clear line
                System.out.println("\033[31m" + prompt + stringInput + " (invalid double)"); // re-print line in red with error
            }
            System.out.print("\033[F"); // Move cursor up
            System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
            System.out.println("|\033[0m");
        }
        
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a double
     * value from the user. If the user enters nothing, the current
     * double is returned. If the user enters something that is not
     * a valid double, it will repeatedly prompt the user until a
     * valid double is entered.
     * @param prompt the message to display to the user
     * @param currentDouble the value to return if the user enters nothing
     * @return the double value entered by the user or the current double if input is empty
     */
    public double readDouble(String prompt, double currentDouble) {
        double result = 0;
        String input = "";
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(prompt);
                input = scnr.nextLine().trim();
                if (input.isEmpty()) {
                    return currentDouble;
                }
                result = Double.parseDouble(input);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid double.");
            }
        }
        return result;
    }

    /**
     * Prompts the user with a given message and continuously reads strings
     * from the user until an empty line is entered. Each non-empty entered
     * string is added to a list which is then returned. The user is prompted
     * with the given message before each input.
     * @param prompt the message to display to the user before each input
     * @return a list of strings entered by the user
     */
    public List<String> readStringList(String prompt) {
        List<String> result = new ArrayList<>();
        while (scnr.nextLine() != "") {
            System.out.print(prompt);
            String input = scnr.nextLine().trim();
            result.add(input);
        }
        return result;
    }

    /**
     * Prompts the user with a given message and then reads a string of comma
     * separated values from the user. Each value is then added to a list which
     * is then returned. After reading the input, moves the cursor up and forward
     * by the specified table spacing.
     * @param prompt the message to display to the user
     * @param tableSpacing the number of spaces to move the cursor forward
     * @return a list of strings entered by the user
     */
    public List<String> readStringList(String prompt, int tableSpacing) {
        System.out.print(prompt);
        String input = scnr.nextLine().trim();

        System.out.print("\033[F"); // Move cursor up
        System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
        System.out.println("|");

        return Arrays.asList(input.split(", "));
    }

    /**
     * Prompts the user with a given message and then reads a string of comma
     * separated values from the user. If the user enters nothing, the current
     * list is returned. If the user enters something different than the current
     * list, the entered list is returned. After reading the input, moves the
     * cursor up and forward by the specified table spacing.
     * @param prompt the message to display to the user
     * @param currentList the list of strings to return if the user enters nothing
     * @param tableSpacing the number of spaces to move the cursor forward
     * @return a list of strings entered by the user
     */
    public List<String> readStringList(String prompt, List<String> currentList, int tableSpacing) {
        System.out.print(prompt);
        String input = scnr.nextLine().trim();
        if (input.isEmpty()) {
            System.out.print("\033[F\033[F\033[K"); // Move up and clear line
            System.out.println("\033[0m" + prompt + String.join(", ", currentList)); // re-print line in white
            System.out.print("\033[F"); // Move cursor up
            System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
            System.out.println("|\033[0m");
            return currentList;
        }
        if (!input.equals(String.join(", ", currentList))) {
            System.out.print("\033[F\033[F\033[K"); // Move up and clear line
            System.out.println("\033[32m" + prompt + input); // re-print line in green
        }
        System.out.print("\033[F"); // Move cursor up
        System.out.print("\033[" + (tableSpacing) + "C"); // Move cursor forward
        System.out.println("|\033[0m");

        return Arrays.asList(input.split(", "));
    }

    /**
     * Prompts the user with a given message and then reads a string of comma
     * separated values from the user. If the user enters nothing, the current
     * list is returned. If the user enters something different than the current
     * list, the entered list is returned.
     * @param prompt the message to display to the user
     * @param currentList the list of strings to return if the user enters nothing
     * @return a list of strings entered by the user
     */
    public List<String> readStringList(String prompt, List<String> currentList) {
        System.out.print(prompt);
        String input = scnr.nextLine().trim();
        if (input.isEmpty()) {
            return currentList;
        }
        return Arrays.asList(input.split(", "));
    }

    /**
     * Prints a table of all products in the store's inventory. The products
     * are sorted by ID before being printed. The table is printed to the
     * console and includes the product ID, name, description, date of
     * manufacture, price, and quantity.
     * @param products the list of ProductWithQuantity objects to print
     */
    public void printProductTable(List<ProductWithQuantity> products) {
        products.sort(Comparator.comparing(ProductWithQuantity::getId));
        System.out.println("===========================================================================================");
        System.out.printf("| %-3s| %-15s | %-35s | %-10s | %-7s | %-3s |%n", "ID", "Name", "Description", "Date", "Price", "Qty");
        System.out.println("===========================================================================================");
        for (ProductWithQuantity product : products) {
            System.out.printf(product.toString() + "\n");
        }
        System.out.println("===========================================================================================");
    }

    /**
     * Generates a unique ID for the given store by finding the first gap in
     * the IDs of the products in the store's inventory. If no gap is found,
     * it returns the next available ID.
     * @param store the StoreFront object containing the store's inventory and other relevant data.
     * @return a unique ID for the given store.
     */
    public int generateId(StoreFront store) {
        int id = -1;
        for (int i = 0; i < store.getInventoryManager().getAllProducts().size(); i++) {
            if (i + 1 != store.getInventoryManager().getAllProducts().get(i).getProduct().getId()) {
                id = i + 1;
                break;
            }
        }
        if (id == -1) {
            id = store.getInventoryManager().getAllProducts().size() + 1;
        }
        return id;
    }

    /**
     * Closes the scanner.
     */
    public void closeScanner() {
        scnr.close();
    }
}
