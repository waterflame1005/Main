import java.util.Scanner;

public class App {
    public static String enterLocation() {
        Scanner myObj = new Scanner(System.in);
        StringBuilder location = new StringBuilder();
        // check for valid location
        location = new StringBuilder(myObj.nextLine());
        while (location.length() >= 16 || location.length() == 0) {
            if (location.length() == 0) {
                System.out.println("Please enter a location.");
            } else {
                System.out.println("Location length cannot be longer than 15 characters. Please enter a new location.");
            }
            location = new StringBuilder(myObj.nextLine());
        }
        // return string
        return location.toString();
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String location;
        int distance;
        Object[][] database = new Object[4][2];
        System.out.println(
                "This program is meant to determine locations to create four future U.S. office locations and to determine their viability.");
        for (int i = 0; i < 4; i++) {
            System.out.println("Please enter location " + (i + 1) + ".");
            // ask for user location
            location = enterLocation();
            // store location
            database[i][0] = location;
            // ask for distance
            System.out.println("Please enter how many miles " + location + " is away from the main company.");
            distance = Integer.parseInt(myObj.nextLine());
            // check for valid distance
            while (distance < 100 || distance > 800) {
                System.out.println(
                        "Location cannot be greater than 800 miles or within 100 miles of the main company. Please enter a new distance.");
                distance = Integer.parseInt(myObj.nextLine());
            }
            // store distance
            database[i][1] = distance;
        }
        System.out.println("Here is a list of all valid locations you have entered:");
        for(int i = 0; i < 4; i++){
            System.out.println("Location: " + database[i][0] + ", Distance: " + database[i][1] + ".");
        }
        myObj.close();
    }
}
