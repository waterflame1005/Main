import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int id;
        int type;
        String[] typeName = {"null","Salaried","Hourly"};
        //employees already in the database
        int[][] database = {{194283,1},{328493,1},{342814,1},{481723,2},{491827,2},{581723,1},{617234,1},{671263,2},{847124,1},{918294,1}};
        
        System.out.println("Welcome. Please enter the total number of employees to be entered");
        int numEmployees = myObj.nextInt();
        // check for valid input
        while (numEmployees <= 0) {
            System.out.println("Please enter a positive number of employees to add");
            numEmployees = myObj.nextInt();
        }
        //create new database with new length
        int length = database.length;
        int[][] newDatabase = new int[length + numEmployees][2];
        for (int i = 0; i < length; i++) {
            newDatabase[i] = database[i];
        }

        // enter employees
        for (int i = 0; i < numEmployees; i++) {
            // add new employee id
            System.out.println("Please enter employee number " + (i+1) + ".");
            id = myObj.nextInt();
            // check for valid input
            while (id <= 99999 || id >= 1000000) {
                System.out.println("Please enter a 6 digit number");
                id = myObj.nextInt();
            }
            newDatabase[length + i][0] = id;
            // add new employee type
            System.out.println("Please enter employee type for employee with id " + id + ".");
            System.out.println("1. Salaried");
            System.out.println("2. Hourly");
            type = myObj.nextInt();
            // check for valid input
            while (type <= 0 || type >= 3) {
                System.out.println("Please enter 1 or 2");
                type = myObj.nextInt();
            }
            newDatabase[length + i][1] = type;
        }
        //copied code for sorting based on first element in each element of the array
        Arrays.sort(newDatabase, (a, b) -> Double.compare(a[0], b[0]));
        //print list of employees
        System.out.println("Here is a list of all employees:");
        //track how many are salaried
        int lengthSalaries = 0;
        for(int i = 0; i < newDatabase.length; i++){
            System.err.println("ID: " + newDatabase[i][0] + ", Payment type: " + typeName[newDatabase[i][1]]);
            if (newDatabase[i][1] == 1){
                lengthSalaries++;
            } 
        }

        int salaryDatabase[] = new int[lengthSalaries];
        int hourlyDatabase[] = new int[newDatabase.length-lengthSalaries];
        int salaryCounter = 0;
        int hourlyCounter = 0;


        for(int i = 0; i < newDatabase.length; i++){
            if (newDatabase[i][1] == 1){
                salaryDatabase[salaryCounter] = newDatabase[i][0];
                salaryCounter++;
            } 
            else {
                hourlyDatabase[hourlyCounter] = newDatabase[i][0];
                hourlyCounter++;
            }
        }
        
        System.out.println("Here is a list of the IDs of all salaried workers:");
        for(int i = 0; i < lengthSalaries; i++){
            System.err.println("ID: " + salaryDatabase[i]);
        }
        System.out.println("Here is a list of the IDs of all hourly workers:");
        for(int i = 0; i < newDatabase.length-lengthSalaries; i++){
            System.err.println("ID: " + hourlyDatabase[i]);
        }

        myObj.close();
    }
}
