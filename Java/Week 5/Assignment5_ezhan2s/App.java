import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("\r\n" + //
                "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\r\n"
                + //
                "\u2500\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2500\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2500\r\n"
                + //
                "\u2500\u2588\u2588\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2588\u2588\u2500\u2588\u2588\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2588\u2588\u2500\r\n"
                + //
                "\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2500\r\n"
                + //
                "\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\r\n"
                + //
                "\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\r\n"
                + //
                "\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2500\u2588\u2588\u2588\u2588\u2588\u2588\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2500\u2588\u2588\u2588\u2588\u2588\u2588\u2500\r\n"
                + //
                "\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\r\n"
                + //
                "\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2500\r\n"
                + //
                "\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2588\u2588\u2588\u2588\u2591\u2591\u2588\u2588\u2500\u2588\u2588\u2591\u2591\u2588\u2588\u2588\u2588\u2588\u2588\u2591\u2591\u2588\u2588\u2500\r\n"
                + //
                "\u2500\u2588\u2588\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2588\u2588\u2500\u2588\u2588\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2591\u2588\u2588\u2500\r\n"
                + //
                "\u2500\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2500\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2500\r\n"
                + //
                "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
        System.out.println(
                "Hello. We are a company named greenest grass that sells the finest patches of grass to gamers, shut-ins, and computer science majors to place on their desks to simulate the effect of going outside and touching grass without having to!");
        System.out.println(
                "Here is our menu:\r\n1. Basic plot of grass - $5:00\r\n2. Portable grass - $7:00\r\n3. Flower Pot - $3:00\r\n4. Extra odorous grass - $12:00\r\n");
        Scanner myObj = new Scanner(System.in);
        // Selection of first product
        System.out.println(
                "Please make your first selection from the options provided in the product/service menu (Enter the number associated with the option):");
        int firstOption = myObj.nextInt();
        // Test for valid selection
        if (firstOption <= 0 || firstOption >= 5) {
            System.out.println("It seems like you've made an invalid option. Terminating purchase.");
            System.exit(0);
        }
        // Selection for number of first product
        System.out.println(
                "You have chosen option " + firstOption + ". Please enter how many of that product you wish to buy:");
        int firstAmount = myObj.nextInt();
        // Test for valid selection
        if (firstAmount <= 0) {
            System.out.println("Please enter a positive number of products next time.");
            System.exit(0);
        }
        // Selection for second product if desired
        System.out.println("You have chosen to buy " + firstAmount + " units of product " + firstOption
                + ". If you wish to buy another product along with it, please enter the corresponding product number. If not, enter 0.");
        int secondOption = myObj.nextInt();
        if (secondOption < 0 || secondOption >= 5) {
            System.out.println("It seems like you've made an invalid option. Terminating purchase.");
            System.exit(0);
        }

        boolean twoItem = false;
        int secondAmount = 0;
        // Case if buying second product
        if (secondOption != 0 && secondOption != firstOption) {
            twoItem = true;
            // Selection of number of second product
            System.out.println("You have chosen option " + secondOption
                    + ". Please enter how many of that product you wish to buy:");
            secondAmount = myObj.nextInt();
            if (secondAmount <= 0) {
                System.out.println("Please enter a positive number of products next time.");
                System.exit(0);
            }
        } else {
            // If only buying one product
            twoItem = false;
            System.out.println("You are only buying one product.");
        }
        // Determining cost of first item
        double firstCost = 0;
        switch (firstOption) {
            case 1:
                firstCost = 5;
                break;
            case 2:
                firstCost = 7;
                break;
            case 3:
                firstCost = 3;
                break;
            case 4:
                firstCost = 12;
                break;
        }
        // Inform customer of first purchase
        System.out
                .println("You are buying " + firstAmount + " of product " + firstOption + ", which costs $" + firstCost
                        + " each. This results in the price of this purchase being $" + firstAmount * firstCost + ".");
        // Determine price for second item (if there is one)
        if (twoItem) {
            double secondCost = 0;
            switch (secondOption) {
                case 1:
                    secondCost = 5;
                    break;
                case 2:
                    secondCost = 7;
                    break;
                case 3:
                    secondCost = 3;
                    break;
                case 4:
                    secondCost = 12;
                    break;
            }
            // Inform customer of second purchase
            System.out.println("You are also buying " + secondAmount + " of product " + secondOption + ", which costs $"
                    + secondCost + " each. This results in the price of this purchase being $"
                    + secondAmount * secondCost + ".");
            // Apply 10% discount if first and second options are selected
            double totalCost = firstAmount * firstCost + secondAmount * secondCost;
            if (firstOption * secondOption == 2) {
                System.out.println("Since you are buying the first and second items, there will be a 10% discount.");
                totalCost = totalCost * 9 / 10;
            }

            // Test to see if there is 5% discount
            if (firstAmount > 10 && secondAmount > 10) {
                System.out.println(
                        "Additionally, since you are buying more than 10 of each item, there will be an additional 5% discount.");
                totalCost = totalCost * 95 / 100;
            }
            // Description of whole purchase of two items
            System.out.println("This means your total cost is $" + totalCost + " for the purchase of " + firstAmount
                    + " units of product " + firstOption + " costing $" + firstCost + " each and " + secondAmount
                    + " units of product " + secondOption + " costing $" + secondCost
                    + " each with all valid discounts applied.");

        } else {
            // Description of whole purchase of one item
            System.out.println("This means your total cost is $" + firstAmount * firstCost + " for the purchase of "
                    + firstAmount + " units of product " + firstOption + " costing $" + firstCost + " each.");
        }
        // Determining if customer wishes to proceed
        System.out.println("Please type 1 if you wish to proceed with this purchase, or 2 if you wish to exit:");
        int decision = myObj.nextInt();
        // Output of customer's final choice.
        switch (decision) {
            case 1:
                System.out.println("Congratulations! Your purchase has been processed.");
                break;
            case 2:
                System.out.println(
                        "I am sorry we could not provide you with any products today. Please check back when you are ready to purchase.");
                break;
            default:
                System.out.println("It seems like you've made an invalid option. Terminating purchase.");
                break;
        }

        myObj.close();
    }
}
