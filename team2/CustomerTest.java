package team2;


public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer(1234, "John", "Doe");
        
        // Test getters
        if (customer.getCustomerID() != 1234) {
            System.out.println("Error: customerID should be 1234");
        }
        if (!customer.getFirstName().equals("John")) {
            System.out.println("Error: First name should be 'John'");
        }
        if (!customer.getLastName().equals("Doe")) {
            System.out.println("Error: Last name should be 'Doe'");
        }
        
        // Test setters
        customer.setFirstName("Jane");
        customer.setLastName("Smith");
        if (!customer.getFirstName().equals("Jane")) {
            System.out.println("Error: First name should be 'Jane'");
        }
        if (!customer.getLastName().equals("Smith")) {
            System.out.println("Error: Last name should be 'Smith'");
        }
        
        // Test toString method
        String expectedToString = "Customer ID: 1234\nFirst Name: Jane\nLast Name: Smith";
        if (!customer.toString().equals(expectedToString)) {
            System.out.println("Expected: " + expectedToString);
            System.out.println("Actual: " + customer.toString());
        }
        
        // Final message if all tests pass
        if (customer.getCustomerID() == 1234 &&
            customer.getFirstName().equals("Jane") &&
            customer.getLastName().equals("Smith") &&
            customer.toString().equals(expectedToString)) {
            System.out.println("All tests passed.");
        }
    }
}