public class Branch {
    private int locationID;
    private String name;
    private int branchID;
    private String address;
    private Manager manager;
    private Employee[] employees;
    private static Branch[] branches = { new Branch(), new Branch(), new Branch(), new Branch() };
    // default values
    Branch() {
        locationID = branchID = 0;
        name = address = "";
        manager = new Manager();
        employees = new Employee[0];
    }

    // change branch
    public static void changeBranch(int branchNum, Branch branch) {
        branches[branchNum] = branch;
    }

    // getbranch
    public static Branch getBranch(int branchNum) {
        return branches[branchNum];
    }

    // get locationID
    public int getLocationID() {
        return this.locationID;
    }

    // set locationID
    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    // get branchID
    public int getBranchID() {
        return this.branchID;
    }

    // set branchID
    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    // get name
    public String getName() {
        return this.name;
    }

    // set name
    public void setName(String name) {
        this.name = name;
    }

    // get address
    public String getAddress() {
        return this.address;
    }

    // set address
    public void setAddress(String address) {
        this.address = address;
    }

    // get manager
    public Manager getManager() {
        return this.manager;
    }

    // set manager
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    // add employee
    public void addToTeam(Employee employee) {
        // create temporary employee array
        Employee[] tempEmployees = new Employee[this.employees.length + 1];
        for (int i = 0; i < this.employees.length; i++) {
            tempEmployees[i] = this.employees[i];
        }
        tempEmployees[this.employees.length] = employee;
        this.employees = tempEmployees;
        // add 1 to the employee count
        Employee.changeEmployeeCount(1);
    }

    // add employee
    public void removeFromTeam(int ID) {
        Employee[] tempEmployees = new Employee[this.employees.length - 1];
        // check if the id is in list
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getID() == ID) {
                // if in list, make new list without id
                for (int j = 0; j < i; j++) {
                    tempEmployees[j] = this.employees[j];
                }
                for (int j = i; j < employees.length - 1; j++) {
                    tempEmployees[j] = this.employees[j + 1];
                }
                this.employees = tempEmployees;
                // remove 1 from employee count
                Employee.changeEmployeeCount(-1);
                System.out.println("You have removed employee with ID " + ID + ".");
                return;
            }
        }
        // inform the id is not in the list
        System.out.println("ID provided is not in the list");
    }

    // outputs information about an employee
    public void displayBranchInformation() {
        System.out.println("Superviser for location with ID " + this.locationID + " and branch with ID " + this.branchID
                + " is " + this.manager.getName() + ".");
        System.out.println("The branch name is " + this.name + ". The branch address is " + this.address + ".");
        System.out.println("There are a total of " + employees.length + " employees.");

    }

    public Employee[] selectEmployee() {
        return employees;
    }
}
