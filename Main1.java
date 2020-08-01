import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

class Sortbrroll implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Restaurant) {
            Restaurant o3 = (Restaurant) o1;
            Restaurant o4 = (Restaurant) o2;
            return Integer.parseInt(o3.getRestaurantNumber()) - Integer.parseInt(o4.getRestaurantNumber());
        } else {
            Food o5 = (Food) o1;
            Food o6 = (Food) o2;
            return Integer.parseInt(o5.getFoodCode()) - Integer.parseInt(o6.getFoodCode());
        }
    }
}

public class Main1 {

    public static void main(String[] args) throws IOException {
        Ratatuee ratatuee = new Ratatuee();
        FileReader fr1 = new FileReader("C:\\Users\\mohammad reza\\Desktop\\تعریف پروژه_ها\\Ratatuee\\Ratatuee\\Ratatuee\\Files\\restaurants.txt");
        BufferedReader br1 = new BufferedReader(fr1);
        String line;
        int paragraphCount = 1;
        while ((line = br1.readLine()) != null) {
            if (line.equals("")) {
                paragraphCount++;
            } else
                continue;
        }
        br1.close();

        FileReader fr = new FileReader("C:\\Users\\mohammad reza\\Desktop\\تعریف پروژه_ها\\Ratatuee\\Ratatuee\\Ratatuee\\Files\\restaurants.txt");
        BufferedReader br = new BufferedReader(fr);

        for (int i = 0; i < paragraphCount; i++) {
            Restaurant restaurant1 = new Restaurant();
            String[] strings;
            strings = br.readLine().split(",", 3);
            restaurant1.setRestaurantName(strings[0]);
            restaurant1.setRestaurantNumber(strings[1]);
            restaurant1.setRestaurantZone(strings[2]);
            ratatuee.addRestaurant(restaurant1);
            int counter = 0;
            for (int j = 0; counter == 0; j++) {
                String Line ;
                Line = br.readLine();
                if (Line == null)
                    break;
                String[] foodInfo;
                foodInfo = Line.split(",", 4);
                if (!foodInfo[0].equals("")) {
                    Food food = new Food();
                    food.setFoodCode(foodInfo[0]);
                    food.setFoodName(foodInfo[1]);
                    food.setFoodType(foodInfo[2]);
                    food.setFoodPrice(foodInfo[3]);
                    restaurant1.addFood(food);
                } else
                    counter++;
            }
        }
        FileReader fr3 = new FileReader("C:\\Users\\mohammad reza\\Desktop\\تعریف پروژه_ها\\Ratatuee\\Ratatuee\\Ratatuee\\Files\\customers.txt");
        BufferedReader br3 = new BufferedReader(fr3);
        String lineC;
        while ((lineC = br3.readLine()) != null) {
            if (!(lineC.equals(""))) {
                // [!?.:]+ is the sentence delimiter in java
                String[] sentenceList = lineC.split("[!?.:]+");
                Client client = new Client();
                String[] string;
                string = sentenceList[0].split(",", 3);
                client.setClientName(string[0]);
                client.setClientNumber(string[1]);
                client.setClientZone(string[2]);
                ratatuee.addClient(client);
            } else
                continue;
        }
        br3.close();

        ratatuee.restaurants.sort(new Sortbrroll());
        for (Restaurant restaurant : ratatuee.restaurants) {
            restaurant.foods.sort(new Sortbrroll());
        }
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String[] Count = scanner.nextLine().split(" ");
            if (Count.length != 0) {
                switch (Count[0]) {
                    case "menu":
                        if (Count.length == 2)
                            ratatuee.findRestaurant(Count[1]);
                        else
                            System.out.println("Wrong Write for Menu!!" + " You should Write menu + Restaurant number ");
                        break;
                    case "list":
                        if (Count[1].equals("near")) {
                            if (Count.length == 3)
                                ratatuee.findClientFF(Count[2]);
                            else
                                System.out.println("Wrong Write For list near!!" + " You should Write list + near + Your number ");
                        } else if (Count[1].equals("type")) {
                            if (Count.length == 3)
                                ratatuee.findFood(Count[2]);
                            else
                                System.out.println("Wrong Write For list type!!");
                        } else
                            continue;

                        break;
                    case "restaurants":
                        if (Count.length == 1) {
                            ratatuee.printRestaurant();
                        } else if (Count.length == 3) {
                            if (Count[1].equals("near")) {
                                ratatuee.findClientFR(Count[2]);
                            }
                        } else
                            System.out.println("Wrong Write For Restaurant!!");
                        break;

                    case "order":
                        String s = new String();
                        String[] strings = new String[3];
                        int Num = 0;
                        for (Client client : ratatuee.clients) {
                            if (client.getClientNumber().equals(Count[1])) {
                                Num++;
                            }
                        }
                        if (Num == 0) {
                            System.out.println("Wrong Number !!");
                            break;
                        } else {
                            while (!s.equals("$")) {
                                Scanner scanner1 = new Scanner(System.in);
                                s = scanner1.nextLine();
                                if (!s.equals("$")) {
                                    strings = ratatuee.makeOrder(Count[1], s);

                                } else {
                                    for (Client client : ratatuee.clients) {
                                        if (client.getClientNumber().equals(Count[1])) {
                                            client.setCost("0");
                                            Order order1 = new Order();
                                            order1.setOrde("#");
                                            client.orders.add(order1);
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        if (strings[2] != null) {
                            int Cost = Integer.parseInt(strings[2]);
                            if (Cost < 100000) {
                                Cost += 5000;
                            }
                            System.out.println(strings[0] + " " + strings[1] + " " + Cost);
                        } else
                            System.out.println("You Don`t have Order !!");
                        break;
                    case "bill":
                        if (Count.length == 3) {
                            if (Count[1].equals("all")) {
                                ratatuee.printClientOrder(Count[2]);
                            }
                        } else if (Count.length == 2) {
                            ratatuee.printLastBill(Count[1]);
                        }
                        break;
                }
            }
        }
    }
}

