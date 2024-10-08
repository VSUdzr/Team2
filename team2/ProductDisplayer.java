package team2;
//Priority 2
//Display Product Report

// Includes:
// product ID,
// name,
// manufacturer,
// price,
// quantity,
// total value (price*quantity),
// and whether it is a food product or not, 
// ordered by name.
// This should also show the total number of unique products and their total value. 
// This list can also be sorted on product ID, manufacturer or whether it is a food item. 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductDisplayer {

    public static void displayProducts(ArrayList<Product> products) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.print("\033[H\033[2J"); // ANSI escape code to clear the console
        System.out.flush();


        do {
            // Display menu options
            System.out.println("\nSort Products by:");
            System.out.println("1. Product ID");
            System.out.println("2. Name");
            System.out.println("3. Manufacturer");
            System.out.println("4. Food Item Status"); 
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // newline

            ArrayList<Product> sortedProducts = new ArrayList<>(products);

            switch (choice) {
                case 1:
                    // Sort by product ID
                    Collections.sort(sortedProducts, Comparator.comparingInt(Product::getProductID));
                    break;
                case 2:
                    // Sort by name
                    Collections.sort(sortedProducts, Comparator.comparing(Product::getName));
                    break;
                case 3:
                    // Sort by manufacturer
                    Collections.sort(sortedProducts, Comparator.comparing(Product::getManufacturer));
                    break;
                case 4:
                    // Sort by food item status (food first)
                    Collections.sort(sortedProducts, Comparator.comparing(Product::isFoodItem).reversed()); 
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            // Display sorted products with formatted output, it was giving really long decimals for quantity via bad math. 
            if (choice >= 1 && choice <= 4) {
            	
            	int totalUniqueItems = sortedProducts.size();
                int totalInventory = 0;
                double totalInventoryCost = 0; 
                
                for (Product p : sortedProducts) {
                    System.out.printf("Product ID: %d\nName: %s\nManufacturer: %s\nPrice: $%.2f\nQuantity: %d\nFood Item: %b\nTotal Value: $%.2f\n\n",
                            p.getProductID(), p.getName(), p.getManufacturer(), p.getPrice(),
                            p.getQuantity(), p.isFoodItem(), p.getTotalValue());
                    		totalInventory += p.getQuantity();
                    		totalInventoryCost += p.getTotalValue();
                }
                System.out.println("Total Unique Items: " + totalUniqueItems);
                System.out.println("Total Inventory: " + totalInventory);
                System.out.printf("Total Inventory Cost: $%.2f\n", totalInventoryCost); // Display total cost
            }
       
        } while (choice != 5);

      //  scanner.close(); go back instead of exiting. 
    }
}