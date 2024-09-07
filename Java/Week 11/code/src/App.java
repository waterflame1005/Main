import java.util.Scanner;

public class App {
    // top menu
    public static void topMenu() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("This is the top level menu. Please select one of the following options:");
        System.out.println("1. Administration Actions");
        System.out.println("2. Reporting Actions");
        System.out.println("3. Exit");
        int option = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option <= 0 || option >= 4) {
            System.out.println("Please select a valid option");
            option = Integer.parseInt(myObj.nextLine());
        }

        switch (option) {
            case 1:
                Administration();
                break;
            case 2:
                Reporting();
                break;
            default:
                exit();
                break;
        }
        myObj.close();
    }

    // administration menu
    public static void Administration() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("This is the administration menu. Please select one of the following options:");

        System.out.println("1. Add manager");
        System.out.println("2. Add employee");
        System.out.println("3. Remove employee");
        System.out.println("4. Change Branch Information");
        System.out.println("5. Return to top menu");
        int option = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option <= 0 || option >= 6) {
            System.out.println("Please select a valid option");
            option = Integer.parseInt(myObj.nextLine());
        }
        if (option == 5) {
            topMenu();
        } else {
            System.out.println("Please select the branch you wish to modify:");
            int branchNum = Integer.parseInt(myObj.nextLine());
            // check for valid selection
            while (branchNum <= 0 || branchNum >= 5) {
                System.out.println("Please select a valid branch (1-5)");
                branchNum = Integer.parseInt(myObj.nextLine());
            }
            switch (option) {
                case 1:
                    addManager(branchNum - 1);
                    break;
                case 2:
                    addEmployee(branchNum - 1);
                    break;
                case 3:
                    removeEmployee(branchNum - 1);
                    break;

                default:
                    changeBranchInfo(branchNum - 1);
                    break;
            }
        }
        myObj.close();
    }

    // reporting menu
    public static void Reporting() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("This is the reporting menu. Please select one of the following options:");
        System.out.println("1. View report of employees at a branch");
        System.out.println("2. View report of all employees sorted by branch location");
        System.out.println("3. Return to top menu");
        int option = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option <= 0 || option >= 4) {
            System.out.println("Please select a valid option");
            option = Integer.parseInt(myObj.nextLine());
        }

        switch (option) {
            case 1:
                viewSpecificReport();
                break;
            case 2:
                viewTotalReport();
                break;
            default:
                topMenu();
                break;
        }
        myObj.close();
    }

    // exit function
    public static void exit() {
        System.out.println("You have exited");
    }

    // add manager
    public static void addManager(int branchNum) {
        Scanner myObj = new Scanner(System.in);
        // create temporary branch to modify
        Branch tempBranch = new Branch();
        tempBranch = Branch.getBranch(branchNum);
        // create temporary manager to modify
        Manager newManager = new Manager();
        // set first name
        System.out.println("Please enter first name:");
        newManager.setFirstName(myObj.nextLine());
        // set last name
        System.out.println("Please enter last name:");
        newManager.setLastName(myObj.nextLine());
        // copy the branch id to the manager in charge of said branch
        newManager.setBranchID(tempBranch.getBranchID());
        // set temp manager to be in charge of temp branch
        tempBranch.setManager(newManager);
        // set temp branch to branch
        Branch.changeBranch(branchNum, tempBranch);
        System.out.println("You have successfully set the manager");
        Administration();
    }

    public static void addEmployee(int branchNum) {
        // create temporary branch to modify
        Branch tempBranch = new Branch();
        tempBranch = Branch.getBranch(branchNum);
        // create temporary manager to modify
        Employee newEmployee = new Employee();
        // create new employee
        newEmployee = Employee.createEmployee();
        // set first name
        tempBranch.addToTeam(newEmployee);
        // set temp branch to branch
        Branch.changeBranch(branchNum, tempBranch);
        Administration();
    }

    public static void removeEmployee(int branchNum) {
        Scanner myObj = new Scanner(System.in);
        // create temporary branch to modify
        Branch tempBranch = new Branch();
        tempBranch = Branch.getBranch(branchNum);
        System.out.println("Specify the ID you wish to remove from branch " + branchNum + ".");
        // get user input for which id to remove
        int ID = Integer.parseInt(myObj.nextLine());
        // remove team member if in list
        tempBranch.removeFromTeam(ID);
        // set temp branch to branch
        Branch.changeBranch(branchNum, tempBranch);
        Administration();
    }

    public static void changeBranchInfo(int branchNum) {
        Scanner myObj = new Scanner(System.in);
        // create temporary branch to modify
        Branch tempBranch = new Branch();
        tempBranch = Branch.getBranch(branchNum);
        // set properties of branch
        System.out.println("Enter location ID");
        tempBranch.setLocationID(Integer.parseInt(myObj.nextLine()));
        System.out.println("Enter branch ID");
        tempBranch.setBranchID(Integer.parseInt(myObj.nextLine()));
        System.out.println("Enter address");
        tempBranch.setAddress(myObj.nextLine());
        System.out.println("Enter name");
        tempBranch.setName(myObj.nextLine());
        // set temp branch to branch
        Branch.changeBranch(branchNum, tempBranch);
        System.out.println("Branch information has been change");
        Administration();
    }

    public static void viewSpecificReport() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please select the branch you wish to report:");
        // select branch number
        int branchNum = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (branchNum <= 0 || branchNum >= 5) {
            System.out.println("Please select a valid branch (1-4)");
            branchNum = Integer.parseInt(myObj.nextLine());
        }
        Branch.getBranch(branchNum - 1).displayBranchInformation();
        System.out.println("Information about all employees are printed:");
        for (int i = 0; i < Branch.getBranch(branchNum - 1).selectEmployee().length; i++) {
            Branch.getBranch(branchNum - 1).selectEmployee()[i].giveInformation();
        }
        Reporting();
    }

    public static void viewTotalReport() {
        // report over all branches
        for (int i = 0; i < 4; i++) {
            // General report of a branch
            System.out.println("Branch location " + (i + 1) + ".");
            Branch.getBranch(i).displayBranchInformation();
            System.out.println("Information about all employees are printed:");
            // report for each employee
            for (int j = 0; j < Branch.getBranch(i).selectEmployee().length; j++) {
                Branch.getBranch(i).selectEmployee()[j].giveInformation();
            }
        }
        // report total employee count
        System.out.println("total number of employees is " + Employee.getEmployeeCount() + ".");
        Reporting();
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        Branch tempBranch = new Branch();
        // initialize first branch
        tempBranch.setBranchID(4000);
        tempBranch.setLocationID(1832);
        tempBranch.setName("Chicago");
        tempBranch.setAddress("1 First Street");
        tempBranch.setManager(new Manager("Joe", "Biden", 4000));
        tempBranch.addToTeam(new Employee("John", "Cena", 1, 1, 2000, 5, 5, "good employee", 100000));
        tempBranch.addToTeam(new Employee("George", "Washington", 2, 2, 2005, 10, 0, "very good employee", 100500));
        Branch.changeBranch(0, tempBranch);
        topMenu();

        myObj.close();
    }
}
