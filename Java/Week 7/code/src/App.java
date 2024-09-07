import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Scanner myObj2 = new Scanner(System.in);
        // prompt payment option selection
        System.out.println(
                "Thank you for your purchase! Please select the number coresponding to payment method:\r\n1. Credit\r\n2. Cash/Check\r\n3. Purchase Requisition");
        String cardType = "";
        while (true) {
            int option = myObj.nextInt();
            // payment by credit card
            if (option == 1) {

                // loop for restart
                while (true) {
                    // Prompt for card number
                    System.out.println("Please enter a valid credit card number:");
                    String cardNumber = myObj2.nextLine();

                    if (!cardNumber.matches("\\d+")) {
                        System.out.println("Card number can only contain numbers.");
                        continue;
                    }
                    if (cardNumber.length() == 15) {
                        if (cardNumber.chars().map(Character::getNumericValue).toArray()[0] == 3) {
                            cardType = "American Express";
                            break;
                        }
                        System.out.println("Invalid Card Number.");
                    } else if (cardNumber.length() == 16) {
                        if (cardNumber.chars().map(Character::getNumericValue).toArray()[0] == 4) {
                            cardType = "Visa";
                            break;
                        } else if (cardNumber.chars().map(Character::getNumericValue).toArray()[0] == 5) {
                            cardType = "Mastercard";
                            break;
                        } else if (cardNumber.chars().map(Character::getNumericValue).toArray()[0] == 6) {
                            cardType = "Discover";
                            break;
                        }
                        System.out.println("Invalid Card Number.");

                    }
                    System.out.println("Card number must contain 15 or 16 numbers.");

                }
                System.out.println("You have chosen to pay by card. Your card is a " + cardType
                        + ". Thank you for your purchase!");
                break;

            }
            // pay by cash/check
            else if (option == 2) {
                System.out.println("You have chosen to pay by cash or check. Thank you for your purchase!");
                break;
            }
            // payment requisition
            else if (option == 3) {
                System.out.println("You have chosen to pay by purchase requisition. Thank you for your purchase!");
                break;

            }
            System.out
                    .println("Please choose a valid option:\r\n1. Credit\r\n2. Cash/Check\r\n3. Purchase Requisition");
        }

        myObj.close();
        myObj2.close();
    }
}
