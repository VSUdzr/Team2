package team2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager(String  filename) {
        products = ProductLoader.loadProductsFromFile(filename);
    }

    public void addProduct(Product product) {
        products.add(product);

        // Write the new product to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter("TestProductList.txt", true))) {
            writer.println(product.getProductID() + ", " + product.getName() + ", " + 
                           product.getManufacturer() + ", " + product.getPrice() + ", " + 
                           product.getQuantity() + ", " + product.isFoodItem());
        } catch (IOException e) {
            System.err.println("Error writing product to file: " + e.getMessage());
        }
    }

    public void displayProducts() {
        ProductDisplayer.displayProducts(products);
    }

    public void addNewProduct() {
        Scanner scanner = new Scanner(System.in);
        int productID;

        // Get a unique product ID
        do {
            System.out.print("Product ID: ");
            productID = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (isProductIDUnique(productID)) {
                break; // Exit the loop if the ID is unique
            } else {
                System.out.println("Product ID already exists. Please enter a unique ID.");
            }
        } while (true);

        // Gather the rest of the product information 
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Price:  ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline   
  

        System.out.print("Is it a food item (true/false)? ");
        boolean isFoodItem = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        Product newProduct = new Product(productID, name, manufacturer, price, quantity, isFoodItem);
        addProduct(newProduct);

        System.out.println("Product added successfully!");
    }

    private boolean isProductIDUnique(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return false;  
 // ID already exists
            }
        }
        return true; // ID is unique
    }

    public void displayProductReport() {
        if (products.isEmpty()) {
            System.out.println("No products in the inventory.");
            return;
        }

        // Call the ProductDisplayer to handle the report display and sorting
        ProductDisplayer.displayProducts(products); 
    }


    public static void main(String[] args) {
        ProductManager manager = new ProductManager("TestProductList.txt");

        // Example usage of the new methods
        manager.addNewProduct(); 
        manager.displayProductReport(); 
        manager.displayProducts(); // This will show the sorting menu
    }
}