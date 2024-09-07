import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int day;
        int month;
        int year;
        Employee[] employees = { new Employee(), new Employee(), new Employee() };
        // create employees
        for (int i = 0; i < 3; i++) {
            // set first name
            System.out.println("Please enter Employee number " + (i + 1) + "'s first name:");
            employees[i].setFirstName(myObj.nextLine());
            // set last name
            System.out.println("Please enter Employee number " + (i + 1) + "'s last name:");
            employees[i].setLastName(myObj.nextLine());
            // set date of hire
            System.out.println("Please enter " + employees[i].getName() + "'s date of hire.");
            System.out.println("Day:");
            day = Integer.parseInt(myObj.nextLine());
            System.out.println("Month:");
            month = Integer.parseInt(myObj.nextLine());
            System.out.println("Year:");
            year = Integer.parseInt(myObj.nextLine());
            employees[i].setDateOfHire(day, month, year);
            // set vacation days
            System.out.println("Please enter number of vacation days to allocate to " + employees[i].getName());
            employees[i].setVacationDays(Integer.parseInt(myObj.nextLine()));
            // give a review
            System.out.println("Enter a review for this employee.");
            employees[i].giveReview(myObj.nextLine());
            // return success
            System.out.println("Employee number " + (i + 1) + " has been entered into the system.");
        }
        System.out.println("Now that the employees have been created here are some options you can do.");
        int employeeNum;
        // schedule vacation day
        while(true){
            System.out.println("Enter an employee number to schedule a vacation day (1 - 3). enter 0 to go to the next step.");
            employeeNum = Integer.parseInt(myObj.nextLine());
            if (employeeNum < 0 || employeeNum > 3){
                System.out.println("Please enter a valid number.");
            }
            else if(employeeNum == 0){
                break;
            }
            else{
                employees[employeeNum-1].scheduleVacationDay();
            }
        }
        // cancel vacation day
        while(true){
            System.out.println("Enter an employee number to cancel a vacation day (1 - 3). enter 0 to go to the next step.");
            employeeNum = Integer.parseInt(myObj.nextLine());
            if (employeeNum < 0 || employeeNum > 3){
                System.out.println("Please enter a valid number.");
            }
            else if(employeeNum == 0){
                break;
            }
            else{
                employees[employeeNum-1].cancelVacationDay();
            }
        }

        while(true){
            System.out.println("Enter an employee number to terminate them (1 - 3). enter 0 to go to the next step.");
            employeeNum = Integer.parseInt(myObj.nextLine());
            if (employeeNum < 0 || employeeNum > 3){
                System.out.println("Please enter a valid number.");
            }
            else if(employeeNum == 0){
                break;
            }
            else{
                System.out.println("Please enter the date of termination.");
                System.out.println("Day:");
                day = Integer.parseInt(myObj.nextLine());
                System.out.println("Month:");
                month = Integer.parseInt(myObj.nextLine());
                System.out.println("Year:");
                year = Integer.parseInt(myObj.nextLine());
                employees[employeeNum-1].terminateEmployee(day, month, year);
            }
        }

        employees[0].giveInformation();
        employees[1].giveInformation();
        employees[2].giveInformation();
        myObj.close();
    }
}
