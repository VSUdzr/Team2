package team2;
//Priority 1
//Add New Product
//
// A product has:
// a 4-digit unique ID,
// as well as a name,
// manufacturer,
// price,
// and quantity.
// Products can be food items or non-food items.
public class Product {
    private int productID;
    private String name;
    private String manufacturer;
    private double price;
    private int quantity;
    private boolean isFoodItem; 

    // Constructor
    public Product(int productID, String name, String manufacturer, double price, int quantity, boolean isFoodItem) {
        this.productID = productID;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.isFoodItem = isFoodItem;
    }

    // Getters
    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public  
 double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public 
 boolean isFoodItem() {
        return isFoodItem;
    }

    // Setters (You might need these depending on your application logic)
    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void  
 setFoodItem(boolean foodItem) {
        isFoodItem = foodItem;
    }

    // Calculate total value
    public double getTotalValue() {
        return price * quantity;
    }

    @Override // toString 
    public String toString() {
        return "Product ID: " + productID + "\n" +
               "Name: " + name + "\n" +
               "Manufacturer: " + manufacturer + "\n" +
               "Price: $" + price + "\n" +
               "Quantity: " + quantity + "\n" +
               "Food Item: " + isFoodItem + "\n" +
               "Total Value: $" + getTotalValue() + "\n";
    }
}