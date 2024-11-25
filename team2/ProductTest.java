package team2;

import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Gather product information from user input
        System.out.print("Enter Product ID: ");
        int productID = scanner.nextInt();

        System.out.print("Enter Product Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();

        System.out.print("Enter Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Is it a Food Item? (true/false): ");
        boolean isFoodItem = scanner.nextBoolean();

        // Create Product instance using user input
        Product product = new Product(productID, name, manufacturer, price, quantity, isFoodItem);

        // Display initial product information
        System.out.println(product);

        // Test total value calculation
        double expectedTotalValue = price * quantity;
        if (product.getTotalValue() == expectedTotalValue) {
            System.out.println("Total value calculation is correct: " + product.getTotalValue());
        } else {
            System.out.println("Error: Total value calculation is incorrect");
        }

        
        System.out.print("Enter new Product Name: ");
        scanner.nextLine(); // Consume newline
        String newName = scanner.nextLine();
        product.setName(newName);

        System.out.print("Enter new Manufacturer: ");
        String newManufacturer = scanner.nextLine();
        product.setManufacturer(newManufacturer);

        System.out.print("Enter new Price: ");
        double newPrice = scanner.nextDouble();
        product.setPrice(newPrice);

        System.out.print("Enter new Quantity: ");
        int newQuantity = scanner.nextInt();
        product.setQuantity(newQuantity);

        System.out.print("Is it a Food Item? (true/false): ");
        boolean newIsFoodItem = scanner.nextBoolean();
        product.setFoodItem(newIsFoodItem);

        // Display updated product information
        System.out.println(product);

        // Test updated total value calculation
        expectedTotalValue = newPrice * newQuantity;
        if (product.getTotalValue() == expectedTotalValue) {
            System.out.println("Updated total value calculation is correct: " + product.getTotalValue());
        } else {
        }

        scanner.close();
    }
}
