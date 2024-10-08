package team2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductLoader {

    public static ArrayList<Product> loadProductsFromFile(String filename) {
        ArrayList<Product> products = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                try {  // Handle potential errors in individual lines
                    String line = scanner.nextLine();
                    
                    // Skip empty lines
                    if (line.trim().isEmpty()) {
                        continue; 
                    }

                    String[] parts = line.split(", ");
                    if (parts.length == 6) {
                        int productID = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        String manufacturer = parts[2];
                        double price = Double.parseDouble(parts[3]);
                        int quantity = Integer.parseInt(parts[4]);
                        boolean isFoodItem = Boolean.parseBoolean(parts[5]);
                        products.add(new Product(productID, name, manufacturer, price, quantity, isFoodItem));
                    } else {
                        System.err.println("Invalid product data format in line: " + line);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing product data: " + e.getMessage());
                } 
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error loading products from file: " + e.getMessage());
        }
        return products;
    }
}