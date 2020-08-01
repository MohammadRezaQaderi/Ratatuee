import java.util.ArrayList;

/**
 * This Class have information of restaurant
 * And have Array list of food
 *
 * @author mohammad reza Qaderi
 * @version 1.0
 */
public class Restaurant {
    // The Restaurant Name
    private String restaurantName;
    // The Restaurant Number
    private String restaurantNumber;
    // The Restaurant Zone
    private String restaurantZone;
    // The Array List Of Food
    ArrayList<Food> foods;


    public Restaurant() {
        foods = new ArrayList<>();
    }

    /**
     * Add food in Array list of Food
     *
     * @param food Food for restaurant
     */
    public void addFood(Food food) {

        foods.add(food);
    }

    /**
     * Get the name of restaurant
     *
     * @return restaurant name
     */
    public String getRestaurantName() {

        return restaurantName;
    }

    /**
     * Set the Name for restaurant
     *
     * @param restaurantName name restaurant
     */
    public void setRestaurantName(String restaurantName) {

        this.restaurantName = restaurantName;
    }

    /**
     * Get the number of restaurant
     *
     * @return restaurant number
     */
    public String getRestaurantNumber() {

        return restaurantNumber;
    }

    /**
     * set the Number for restaurant
     *
     * @param restaurantNumber restaurant number
     */
    public void setRestaurantNumber(String restaurantNumber) {

        this.restaurantNumber = restaurantNumber;
    }

    /**
     * Get the zone of restaurant
     *
     * @return restaurant zone
     */
    public String getRestaurantZone() {

        return restaurantZone;
    }

    /**
     * Set the Zone for restaurant
     *
     * @param restaurantZone restaurant zone
     */
    public void setRestaurantZone(String restaurantZone) {

        this.restaurantZone = restaurantZone;
    }

    /**
     * Search for all food of the restaurant and print that
     *
     * @param restaurant restaurant that want food
     */
    public void printFood(Restaurant restaurant) {
        for (Food food : foods) {
            food.print(restaurant);
        }
    }

    /**
     * Print information of the Restaurant
     */
    public void printRInfo() {
        System.out.println(this.getRestaurantName() + "  " + this.getRestaurantZone() + "  " + this.getRestaurantNumber());
    }

}
