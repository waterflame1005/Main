import java.util.Scanner;

public class Manager {
    private String firstName;
    private String lastName;
    private int branchID;

    // parameterized
    Manager(String firstName, String lastName, int branchID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.branchID = branchID;
    }
    // default values
    Manager() {
        this.firstName = this.lastName = "";
        this.branchID = 9999;
    }

    // set first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // set last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // set branch ID
    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    // get name
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    // get branch ID
    public int getBranchID() {
        return this.branchID;
    }
}
