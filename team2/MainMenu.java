package team2;

import java.util.Scanner;

public class MainMenu {
    private ProductManager productManager;
    private CustomerManager customerManager;
    private Scanner scanner;

    public MainMenu(ProductManager productManager, CustomerManager customerManager) {
        this.productManager = productManager;
        this.customerManager = customerManager;  

        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;

        // Ask the user if they are a manager or a customer
        System.out.print("Are you a manager or a customer (m/c)? ");
        String userType = scanner.nextLine().trim().toLowerCase();

        do {
            if (userType.equals("m")) {
                // Manager menu
                System.out.println("\nMain Menu (Manager):");
                System.out.println("1. Add New Product");
                System.out.println("2. Display Product Report");
                System.out.println("3. Display Customer List");
                System.out.println("4. Exit");
            } else {
                // Customer menu
                System.out.println("\nMain Menu (Customer):");
                System.out.println("1. Register");
                System.out.println("2. Exit");
            }

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); //  newline

            switch (choice) {
                case 1:
                    if (userType.equals("m")) {
                        productManager.addNewProduct();
                    } else {
                        customerManager.registerCustomer();
                    }
                    break;
                case 2:
                    if (userType.equals("m")) {
                        productManager.displayProductReport();
                    } else {
                        System.out.println("Exiting...");
                    }
                    break;
                case 3:
                    if (userType.equals("m")) {
                        customerManager.displayCustomerList();
                    } else {
                        System.out.println("Invalid choice!"); // For customer menu
                    }
                    break;
                case 4:
                    if (userType.equals("m")) {
                        System.out.println("Exiting...");
                    } else {
                        System.out.println("Invalid choice!"); // For customer menu
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (userType.equals("c") ? choice != 2 : choice != 4);
        // Different exit conditions for manager and customer

   //     scanner.close();
    }

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager("TestProductList.txt");
        CustomerManager customerManager = new CustomerManager("TestCustomerList.txt");
        MainMenu menu = new MainMenu(productManager, customerManager);
        menu.displayMenu();
    }
}