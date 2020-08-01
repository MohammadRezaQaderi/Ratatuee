import java.util.ArrayList;

/**
 * This Class Have the information of the client
 * and a array list of orders
 *
 * @author mohammad reza Qaderi
 * @version 1.0
 */
public class Client {
    // The Client Name
    private String clientName;
    // The Client Number
    private String clientNumber;
    // The Client Zone
    private String clientZone;
    // The Client Cost
    private String cost = "0";
    // The Order Array List
    ArrayList<Order> orders;

    public Client() {
        orders = new ArrayList<>();
    }

    /**
     * Add the order to client Array list
     *
     * @param order the order of client
     */
    public void addOrde(Order order) {
        orders.add(order);
    }

    /**
     * Get the client name
     *
     * @return Client name
     */
    public String getClientName() {

        return clientName;
    }

    /**
     * Set the client name
     *
     * @param clientName name of client
     */
    public void setClientName(String clientName) {

        this.clientName = clientName;
    }

    /**
     * Get the client number
     *
     * @return Client number
     */
    public String getClientNumber() {

        return clientNumber;
    }

    /**
     * Set the Client number
     *
     * @param clientNumber Number of client
     */
    public void setClientNumber(String clientNumber) {

        this.clientNumber = clientNumber;
    }

    /**
     * Get the client zone
     *
     * @return Client zone
     */
    public String getClientZone() {

        return clientZone;
    }

    /**
     * Set the Zone of client
     *
     * @param clientZone Zone of client
     */
    public void setClientZone(String clientZone) {

        this.clientZone = clientZone;
    }

    /**
     * Get the client cost (money that buy food)
     *
     * @return Client cost (money that buy food)
     */
    public String getCost() {

        return cost;
    }

    /**
     * Set the Money of food
     *
     * @param cost Money of food
     */
    public void setCost(String cost) {

        this.cost = cost;
    }

    /**
     * print the information of the client
     */
    public void print() {
        System.out.println("{" + "clientName='" + this.getClientName() + '\'' + ", clientNumber='" + this.getClientNumber() + '\'' + ", clientZone='" + this.getClientZone() + '\'' + "}");
    }


}
