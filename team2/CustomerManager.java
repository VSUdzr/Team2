package team2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {
    private ArrayList<Customer> customers;
    private int nextCustomerID;

    public CustomerManager(String filename) {
        customers = CustomerLoader.loadCustomersFromFile(filename);
        nextCustomerID = calculateNextCustomerID();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void displayCustomers() {
        CustomerDisplayer.displayCustomers(customers);
    }

    private int calculateNextCustomerID() {
        int maxID = 0;
        for (Customer customer : customers) {
            if (customer.getCustomerID() > maxID) {
                maxID = customer.getCustomerID();
            }
        }
        return maxID + 1;
    }

    public void registerCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer details:");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        Customer newCustomer = new Customer(nextCustomerID, firstName, lastName);
        addCustomer(newCustomer);

        System.out.println("Customer registered successfully! ID: " + nextCustomerID);
        nextCustomerID++;
        // Write the new customer to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter("TestCustomerList.txt", true))) {
            writer.println(newCustomer.getCustomerID() + ", " + newCustomer.getFirstName() + ", " + newCustomer.getLastName());
        } catch (IOException e) {
            System.err.println("Error writing customer to file: " + e.getMessage());
        }
    }

    public void displayCustomerList() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }

        System.out.println("\nCustomer List:");
        displayCustomers();
    }

    public void displayCustomerReport() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }

        System.out.println("\nCustomer Report:");
        System.out.println("Total Customers: " + customers.size());
        // Add more report details here if needed
        displayCustomers();
    }

    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager("TestCustomerList.txt");

        // Example usage
        manager.registerCustomer();
        manager.displayCustomerList();
        manager.displayCustomerReport();
    }
}