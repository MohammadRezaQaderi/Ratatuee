/**
 * This Class have the information of food
 *
 * @author mohammad reza Qaderi
 * @version 1.0
 */
public class Food {
    //The Food Code
    private String foodCode;
    //The Food Name
    private String foodName;
    //The Food Type
    private String foodType;
    //The Food Price
    private String foodPrice;

    /**
     * Get the food code
     *
     * @return code of food
     */
    public String getFoodCode() {
        return foodCode;
    }

    /**
     * Set the code for food
     *
     * @param foodCode code of food
     */
    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    /**
     * Get the food name
     *
     * @return name of food
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Set the name for food
     *
     * @param foodName name for food
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * Get food type
     *
     * @return type of food
     */
    public String getFoodType() {
        return foodType;
    }

    /**
     * Set the type for food
     *
     * @param foodType type for food
     */
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    /**
     * Get the price of food
     *
     * @return price of food
     */
    public String getFoodPrice() {
        return foodPrice;
    }

    /**
     * Set the price for food
     *
     * @param foodPrice Price fo food
     */
    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    /**
     * Print information of the food
     *
     * @param restaurant restaurant food
     */
    public void print(Restaurant restaurant) {
        System.out.println((restaurant.getRestaurantNumber() + this.getFoodCode()) + " " + this.getFoodName() + " " + this.getFoodType() + " " + this.getFoodPrice());
    }

}
