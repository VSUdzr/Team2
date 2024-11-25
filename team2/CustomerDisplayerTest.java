package team2;
import java.util.ArrayList;
public class CustomerDisplayerTest {
    public static void main(String[] args) {
        // Creating test customers
        Customer customer1 = new Customer(1023, "Alice", "Smith");
        Customer customer2 = new Customer(1056, "Bob", "Smith");
        Customer customer3 = new Customer(1012, "Alice", "Johnson");
        Customer customer4 = new Customer(1044, "Charlie", "Smith");
        Customer customer5 = new Customer(1008, "Alice", "Smith");

        // Adding customers to the list
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);


        // Test displayCustomers method
        System.out.println("Displaying sorted customers:");
        CustomerDisplayer.displayCustomers(customers);

        ArrayList<Customer> sortedCustomers = new ArrayList<>(customers);
        sortedCustomers.sort((c1, c2) -> {
            int lastNameCompare = c1.getLastName().compareToIgnoreCase(c2.getLastName());
            if (lastNameCompare != 0) return lastNameCompare;
            int firstNameCompare = c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
            if (firstNameCompare != 0) return firstNameCompare;
            return Integer.compare(c1.getCustomerID(), c2.getCustomerID());
        });

        assert customers.size() == sortedCustomers.size() : "Error: Customer count mismatch";

        for (int i = 0; i < sortedCustomers.size(); i++) {
            assert customers.get(i).toString().equals(sortedCustomers.get(i).toString())
                : "Error: Customer ordering mismatch at position " + i;
        }
    }
}