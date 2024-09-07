import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        double price = 7;
        int productQuantity = 10;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter what you wish to buy:");
        String name = myObj.nextLine();
        if (name.equals("dandelion pots")) {
            System.out.println("Please enter how many pots of dandelions ($" + price + " dollars each) you wish to buy:");

            int amountDesired = myObj.nextInt();
            if (amountDesired < productQuantity) {
                System.out.println("You have requested " + amountDesired
                        + " units of dandelion pots. Your total cost is $" + price * amountDesired + ". There are "
                        + (productQuantity - amountDesired) + " units remaining in stock.");
            } else if (amountDesired == productQuantity) {
                System.out.println("We have " + amountDesired
                        + " units of dandelion available in stock. Your total cost is $" + price * amountDesired + ".");
            } else {
                System.out.println("The number of units requested, " + amountDesired
                        + ", is not currently in stock. Please try ordering your dandelion pots when supplies are in stock.");
            }
        } else {
            System.out.println("Sorry, we do not have " + name + ". Please try another product.");
        }

        myObj.close();

    }
}
