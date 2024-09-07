public class Employee {
    private String firstName;
    private String lastName;
    private Date dateOfHire = new Date(0, 0, 0);
    private Date dateOfTermination = new Date(0, 0, 0);
    private int unscheduledVacationDays;
    private int scheduledVacationDays;
    private String review;

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
            System.out.println(this.firstName + " " + this.lastName + " still has " + this.unscheduledVacationDays + " vacation days available.");
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
           System.out.println(this.firstName + " " + this.lastName + " now has " + this.unscheduledVacationDays + " vacation days available."); 
        } else {
            System.out
                    .println("There are no vacation days to cancel for " + this.firstName + " " + this.lastName + ".");
        }
    }

    // outputs information about an employee
    public void giveInformation() {
        System.out.println("Employee Information for " + this.firstName + " " + this.lastName + ":");
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
