package team2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerLoader {

    public static ArrayList<Customer> loadCustomersFromFile(String filename) {
        ArrayList<Customer> customers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();  

                String[] parts = line.split(", ");
                if (parts.length  
 == 3) {
                    int customerID = Integer.parseInt(parts[0]);
                    String firstName = parts[1];
                    String lastName = parts[2];
                    customers.add(new Customer(customerID, firstName, lastName));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error loading customers from file: " + e.getMessage());
        }
        return customers;
    }
}