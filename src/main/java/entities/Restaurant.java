package entities;

public class Restaurant {
    private int restaurantID;
    private String restaurantName;
    private int zipCode;
    private String city;

    // Constructors, getters, and setters
    public Restaurant() {}

    public Restaurant(int restaurantID, String restaurantName, int zipCode, String city) {
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.zipCode = zipCode;
        this.city = city;
    }

    public int getRestaurantID() { return restaurantID; }
    public void setRestaurantID(int restaurantID) { this.restaurantID = restaurantID; }
    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }
    public int getZipCode() { return zipCode; }
    public void setZipCode(int zipCode) { this.zipCode = zipCode; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
