package team2;
//Priotiy 4
//Display List of Customers

// Ordered by last name, then first name, then customer ID. 
// In other words, if two customers have the same last name, then the one “smaller” first name would be listed first. 
// And, if two customers have the same last and first name, the one with the smaller customer ID should be displayed first. 
// This list should also show the total number of customers.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomerDisplayer {

    // Method to display customers, always sorted according to the requirements
    public static void displayCustomers(ArrayList<Customer> customers) {
        // Create a copy of the customers list to avoid modifying the original
        ArrayList<Customer> sortedCustomers = new ArrayList<>(customers);

        // Sort the customers using a custom comparator 
        Collections.sort(sortedCustomers, new Comparator<Customer>() {
            //  @Override indicates we are overriding "compare" method to define how "Collections.sort" should compare two Customer objects.
            @Override
            public int compare(Customer c1, Customer c2) {
                // Sort by last name
                int lastNameCompare = c1.getLastName().compareToIgnoreCase(c2.getLastName());
                if (lastNameCompare != 0) {
                    return lastNameCompare;
                } else {
                    // sort by first name if last names are the same, 
                    int firstNameCompare = c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
                    if (firstNameCompare != 0) {
                        return firstNameCompare;
                    } else {
                        // sort by customer ID if both first and last names are the same, 
                        return Integer.compare(c1.getCustomerID(), c2.getCustomerID());
                    }
                }
            }
        });

        // Print the sorted customer list
        for (Customer c : sortedCustomers) {
            System.out.println(c); // This implicitly calls the c.toString() method overridden in Customer Class
        }
        System.out.println("Total Customers: " + sortedCustomers.size());
    }
}