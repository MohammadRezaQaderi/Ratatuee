import java.util.ArrayList;
import java.util.Comparator;

/**
 * This Class Have to Control The Order and all thing that Client want
 *
 * @author mohammad reza Qaderi
 * @version 1.0
 */
public class Ratatuee {
    // The Array List of Restaurant
    ArrayList<Restaurant> restaurants;
    // The Array List of Client
    ArrayList<Client> clients;

    public Ratatuee() {
        restaurants = new ArrayList<>();
        clients = new ArrayList<>();
    }

    /**
     * Add restaurant to Array list of Ratatuee
     *
     * @param restaurant the new restaurant
     */
    public void addRestaurant(Restaurant restaurant) {

        restaurants.add(restaurant);
    }

    /**
     * Add Client to Array list of Ratatuee
     *
     * @param client the new Client
     */
    public void addClient(Client client) {

        clients.add(client);
    }

    /**
     * Print all restaurant Information that was in Ratatuee
     */
    public void printRestaurant() {
        for (Restaurant restaurant : restaurants) {
            restaurant.printRInfo();
        }
    }

    /**
     * Print all Client Information that was in Ratatuee
     */
    public void printClient() {
        for (Client client : clients) {
            client.print();
        }
    }

    /**
     * Search All Restaurant that was in Ratatuee and the zone was be equal
     *
     * @param Zone area of Restaurant want
     */
    public void nearRestaurant(String Zone) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getRestaurantZone().equals(Zone)) {
                restaurant.printFood(restaurant);
            }
        }
    }

    /**
     * Find Restaurant that was in Ratatuee and the number was be equal and Print food
     *
     * @param number number of Restaurant was
     */
    public void findRestaurant(String number) {
        int Count = 0;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getRestaurantNumber().equals(number)) {
                restaurant.printFood(restaurant);
                Count++;
            }
        }
        if (Count == 0) {
            System.out.println("Wrong Number for Restaurant!!");
        }
    }

    /**
     * Find Client that was in Ratatuee and the number was be equal
     *
     * @param number of client
     */
    public void findClientFR(String number) {
        int Count = 0;
        for (Client client : clients) {
            if (client.getClientNumber().equals(number)) {
                for (Restaurant restaurant : restaurants) {
                    if (restaurant.getRestaurantZone().equals(client.getClientZone())) {
                        restaurant.printRInfo();
                        Count++;
                    }
                }
            }
        }
        if (Count == 0)
            System.out.println("There is no Restaurant Near You!!");
    }

    /**
     * Find Client that was in Ratatuee and the number was be equal and Print food
     *
     * @param number of client
     */
    public void findClientFF(String number) {
        int Count = 0;
        for (Client client : clients) {
            if (client.getClientNumber().equals(number)) {
                nearRestaurant(client.getClientZone());
                Count++;
            }
        }
        if (Count == 0)
            System.out.println("Don`t have any near Restaurant!!");
    }

    /**
     * Print all food that was in Ratatuee And they Type was equal
     *
     * @param type of food
     */
    public void findFood(String type) {
        int Count = 0;
        for (Restaurant restaurant : restaurants) {
            for (Food food : restaurant.foods) {
                if (food.getFoodType().equals(type)) {
                    System.out.println((restaurant.getRestaurantNumber() + food.getFoodCode()) + " " + food.getFoodName() + " " + food.getFoodType() + " " + food.getFoodPrice() + "" + restaurant.getRestaurantName() + " " + restaurant.getRestaurantZone());
                    Count++;
                }
            }
        }
        if (Count == 0)
            System.out.println("There is no Food that Type was " + type + "!!");
    }

    /**
     * Make order for client
     *
     * @param number of client that have order
     * @param order  the all food code and number of food
     * @return a array list of order that have name and number and money of foods
     */
    public String[] makeOrder(String number, String order) {
        String[] strings = new String[3];
        int Cost = 0;
        int Food = 0;
        for (Client client : clients) {
            if (client.getClientNumber().equals(number)) {
                if (!order.equals("$")) {
                    strings[0] = client.getClientName();
                    strings[1] = client.getClientNumber();
                    Cost = 0;
                    Order order1 = new Order();
                    order1.setOrde(order);
                    client.orders.add(order1);
                    String[] strings1;
                    strings1 = order.split(" ", 3);
                    for (Restaurant restaurant : restaurants) {
                        if (strings1[0].substring(0, 8).equals(restaurant.getRestaurantNumber())) {
                            for (Food food : restaurant.foods) {
                                if (strings1[0].substring(8, 11).equals(food.getFoodCode())) {
                                    Cost = Integer.parseInt(client.getCost()) + (Integer.parseInt(food.getFoodPrice()) * Integer.parseInt(strings1[1]));
                                    client.setCost(String.valueOf(Cost));
                                    Food++;
                                }
                                strings[2] = String.valueOf(Cost);
                            }
                        }
                    }
                } else
                    client.setCost("0");
                if (Food == 0) {
                    System.out.println("Wrong code For food!!");
                    break;
                }
            }
        }
        return strings;
    }

    /**
     * Print all Client orders
     *
     * @param number the number of client
     */
    public void printClientOrder(String number) {
        int Cost = 0;
        int Total = 0;
        for (Client client : clients) {
            if (client.getClientNumber().equals(number))
                if (client.orders.size() != 0) {
                    for (Order order : client.orders) {
                        if (!order.getOrde().equals("#")) {
                            String[] strings = order.getOrde().split(" ", 3);
                            for (Restaurant restaurant : restaurants) {
                                if (strings[0].substring(0, 8).equals(restaurant.getRestaurantNumber()))
                                    for (Food food : restaurant.foods) {
                                        if (strings[0].substring(8, 11).equals(food.getFoodCode())) {
                                            System.out.println(strings[0] + " " + food.getFoodName() + " " + food.getFoodType() + " " + food.getFoodName() + " " + food.getFoodPrice() + " " + strings[1] + " " + (Cost = (Integer.parseInt(food.getFoodPrice()) * Integer.parseInt(strings[1]))));
                                            Total += Cost;
                                        }
                                    }
                            }
                        } else {
                            if (Cost > 100000) {
                                System.out.println("delivery cost 0");
                                System.out.println("total cost " + Cost);
                            } else {
                                System.out.println("delivery cost " + 5000);
                                System.out.println("total cost " + (Cost + 5000));
                                Total += 5000;
                            }
                            System.out.println("#");
                        }
                    }
                } else
                    System.out.println("You Don`t have any Order until Now");
        }
        System.out.println("total purchase " + Total);
    }

    /**
     * List all Order that client have order
     *
     * @param number the number of Client
     */
    public void printLastBill(String number) {
        int Cost1 = 0;
        int Total = 0;
        int C = 0;
        Order order = new Order();
        for (Client client : clients) {
            if (client.getClientNumber().equals(number))
                if (client.orders.size() != 0) {
                    C = client.orders.size();
                    order = client.orders.get(C - 2);
                    if (!order.getOrde().equals("#")) {
                        String[] strings1 = order.getOrde().split(" ", 3);
                        for (Restaurant restaurant : restaurants) {
                            if (strings1[0].substring(0, 8).equals(restaurant.getRestaurantNumber()))
                                for (Food food : restaurant.foods) {
                                    if (strings1[0].substring(8, 11).equals(food.getFoodCode())) {
                                        System.out.println(strings1[0] + " " + food.getFoodName() + " " + food.getFoodType() + " " + food.getFoodName() + " " + food.getFoodPrice() + " " + strings1[1] + " " + (Cost1 = (Integer.parseInt(food.getFoodPrice()) * Integer.parseInt(strings1[1]))));
                                        Total += Cost1;
                                    }
                                }
                        }
                    }
                    if (Cost1 > 100000) {
                        System.out.println("delivery cost 0");
                        System.out.println("total cost " + Cost1);
                    } else {
                        System.out.println("delivery cost " + 5000);
                        System.out.println("total cost " + (Cost1 + 5000));
                    }

                }
        }
    }

}
