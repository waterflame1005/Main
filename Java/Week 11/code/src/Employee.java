import java.util.Scanner;

public class Employee {
    private String firstName;
    private String lastName;
    private Date dateOfHire = new Date(0, 0, 0);
    private Date dateOfTermination = new Date(0, 0, 0);
    private int unscheduledVacationDays;
    private int scheduledVacationDays;
    private String review;
    private int ID;
    private static int employeeCount = 0;
    // parameterized
    Employee(String firstName, String lastName, int day, int month, int year, int unscheduledVacationDays,
            int scheduledVacationDays, String review, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfHire = new Date(day, month, year);
        this.unscheduledVacationDays = unscheduledVacationDays;
        this.scheduledVacationDays = scheduledVacationDays;
        this.review = review;
        this.ID = ID;
    }
    // default
    Employee() {
        this.firstName = this.lastName = this.review = "";
        this.dateOfHire = this.dateOfTermination = new Date();
        this.unscheduledVacationDays = this.scheduledVacationDays = this.ID = 0;
    }
    // create employee object
    public static Employee createEmployee() {
        Scanner myObj = new Scanner(System.in);
        Employee employee = new Employee();
        // set first name
        System.out.println("Please enter first name:");
        employee.setFirstName(myObj.nextLine());
        // set last name
        System.out.println("Please enter last name:");
        employee.setLastName(myObj.nextLine());
        // set date of hire
        System.out.println("Please enter " + employee.getName() + "'s date of hire.");
        System.out.println("Day:");
        int day = Integer.parseInt(myObj.nextLine());
        System.out.println("Month:");
        int month = Integer.parseInt(myObj.nextLine());
        System.out.println("Year:");
        int year = Integer.parseInt(myObj.nextLine());
        employee.setDateOfHire(day, month, year);
        // set vacation days
        System.out.println("Please enter number of vacation days to allocate to " + employee.getName());
        employee.setVacationDays(Integer.parseInt(myObj.nextLine()));
        // give a review
        System.out.println("Enter a review for this employee.");
        employee.giveReview(myObj.nextLine());
        // return success
        System.out.println("Employee has been created and entered into the system.");
        return employee;
    }

    // get ID
    public int getID() {
        return this.ID;
    }

    // set ID
    public void setID(int ID) {
        this.ID = ID;
    }

    // get employer count (static)
    public static int getEmployeeCount() {
        return employeeCount;
    }
    // change total number of employees
    public static void changeEmployeeCount(int value) {
        employeeCount += value;
    }

    // get name
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    // set first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // set last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // set date of hire
    public void setDateOfHire(int day, int month, int year) {
        this.dateOfHire.setDate(day, month, year);
    }

    // terminate employee
    public void terminateEmployee(int day, int month, int year) {
        this.dateOfTermination.setDate(day, month, year);
        employeeCount--;
    }

    // set initial number of vacation days
    public void setVacationDays(int days) {
        this.unscheduledVacationDays = days;
    }

    // set a review
    public void giveReview(String review) {
        this.review = review;
    }

    // schedule vacation days
    public void scheduleVacationDay() {
        if (this.unscheduledVacationDays > 0) {
            this.unscheduledVacationDays--;
            this.scheduledVacationDays++;
            System.out.println("A vacation day has been scheduled for " + this.firstName + " " + this.lastName + ".");
            System.out.println(this.firstName + " " + this.lastName + " still has " + this.unscheduledVacationDays
                    + " vacation days available.");
        } else {
            System.out.println("There are no more vacation days for " + this.firstName + " " + this.lastName + ".");
        }
    }

    // cancel vacation days
    public void cancelVacationDay() {
        if (this.scheduledVacationDays > 0) {
            this.unscheduledVacationDays++;
            this.scheduledVacationDays--;
            System.out.println("A vacation day has been cancelled for " + this.firstName + " " + this.lastName + ".");
            System.out.println(this.firstName + " " + this.lastName + " now has " + this.unscheduledVacationDays
                    + " vacation days available.");
        } else {
            System.out
                    .println("There are no vacation days to cancel for " + this.firstName + " " + this.lastName + ".");
        }
    }

    // outputs information about an employee
    public void giveInformation() {
        System.out.println("Employee Information for " + this.firstName + " " + this.lastName + ":");
        System.out.println("Employee ID is " + this.ID + ".");
        System.out.println("Date of hire: " + this.dateOfHire.getDate());
        if (this.dateOfTermination.getDay() != 0) {
            System.out.println("Date of termination: " + this.dateOfTermination.getDate());
        } else {
            System.out.println("The employee is not being terminated");
        }
        System.out.println("Number of vacation days: " + this.scheduledVacationDays);
        System.out.println("Number of unscheduled vacation days: " + this.unscheduledVacationDays);
        System.out.println("Review: " + this.review);
    }
}
