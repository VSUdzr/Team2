package team2;
//Priority 3
//Register Customer
//
// A customer has
// a first and last name
// and a unique 4-digit ID, supplied by the system
public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;

    // Start Constructors
    public Customer(int customerID, String firstName, String lastName) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
    } // End Constructors

    // Start Getters 
    public int getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName()  
 { 
        return lastName;  
 
    } // End Getters 

    // Start Setters 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } // End Setters 

    //Override toString to display 
    @Override
  
    public String toString() {
        return  
 "Customer ID: " + customerID + "\n" +
               "First Name: " + firstName + "\n" +
               "Last Name: " + lastName + "\n";
    }
}