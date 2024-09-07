import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int selection = 0;
        int year = 0;
        int day = 0;
        int month = 0;
        String[] months = { "null", "January", "Feburary", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December" };
        int[] monthss = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        Scanner myObj = new Scanner(System.in);
        // intro prompt
        System.out.println("Hello! You are seeing this prompt becase you have just ordered goods from our company.");
        // menu
        System.out.println(
                "Here is our menu:\r\n1. Basic plot of grass\r\n2. Portable grass\r\n3. Flower Pot\r\n4. Extra odorous grass\r\n");
        // prompt for ordering
        System.out.println("Please enter the number corresponding to the goods which you have purchased:");
        int product = myObj.nextInt();
        // check for valid product
        while (product <= 0 || product >= 5) {
            System.out.println("Please enter a number between 1 and 4");
            product = myObj.nextInt();
        }
        // successful selection + prompt for month of delivery
        System.out.println("You have selected product " + product + ".");
        // stay in loop until selection is 1
        while (selection == 0) {
            // prompt delivery month
            System.out.println("Please enter the month you want your delivery to be:");
            month = myObj.nextInt();
            // check for valid month
            while (month <= 0 || month >= 13) {
                System.out.println("Please enter a valid month between 1 and 12");
                month = myObj.nextInt();
            }
            // prompt delivery day
            System.out.println("You have selected " + months[month]
                    + " to be your delivery month. Please enter the date you want your delivery to be:");
            day = myObj.nextInt();
            // check for valid day
            while (day <= 0 || day > monthss[month]) {
                System.out.println("Please enter a valid day of " + months[month] + " between 1 and " + monthss[month]);
                day = myObj.nextInt();
            }
            //checking for invalid dates
            if ((day == 1 && month == 1) || (day == 20 && month == 3) || (day == 22 && month == 4)
                    || (day == 1 && month == 5) || (day == 5 && month == 6) || (day == 2 && month == 8)
                    || (day == 31 && month == 12)) {
                System.out.println("Sorry, this date is not available for delivery. Please choose another date.");
            //proceeding with chosen date
            } else {
                // prompt delivery year
                System.out.println("You have selected " + months[month] + " " + day
                        + " to be your delivery date. Please enter the year you want your delivery to be:");
                year = myObj.nextInt();

                // confirmation
                System.out.println("You have selected " + months[month] + " " + day + ", " + year
                        + " as your delivery date. Enter 1 to confirm the delivery date, or 0 to choose another date:");
                selection = myObj.nextInt();
                // check for valid confirmation
                while (selection < 0 || selection > 1) {
                    System.out.println("Please enter a valid option");
                    selection = myObj.nextInt();
                }
                System.out.println("You have chosen to pick another date.");
            }
        }
        //confirmation
        System.out.println("Congratulations! Your delivery date of " + months[month] + " " + day + ", " + year
                + " of product " + product + " has been scheduled");
        myObj.close();

    }
}
