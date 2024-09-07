import java.util.Scanner;

public class App {

    public static void topMenu() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("This is the top level menu. Please select one of the following options:");
        System.out.println("1. Inventory Actions");
        System.out.println("2. Sales Actions");
        System.out.println("3. Exit");
        int option = myObj.nextInt();
        // check for valid product
        while (option <= 0 || option >= 4) {
            System.out.println("Please select a valid option");
            option = myObj.nextInt();
        }

        switch (option) {
            case 1:
                inventoryMenu();
                break;
            case 2:
                salesMenu();
                break;
            default:
                exit();
                break;
        }
        myObj.close();
    }

    public static void inventoryMenu() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("This is the inventory actions menu. Please select one of the following options:");
        System.out.println("1. Add a product");
        System.out.println("2. View inventory");
        System.out.println("3. Return to top level menu");
        int option = myObj.nextInt();
        // check for valid product
        while (option <= 0 || option >= 4) {
            System.out.println("Please select a valid option");
            option = myObj.nextInt();
        }

        switch (option) {
            case 1:
                addProduct();
                break;
            case 2:
                viewInventory();
                break;
            default:
                topMenu();
                break;
        }
        myObj.close();
    }

    public static void salesMenu() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("This is the sales actions menu. Please select one of the following options:");
        System.out.println("1. View products");
        System.out.println("2. Purchase products");
        System.out.println("3. Return to top level menu");
        int option = myObj.nextInt();
        // check for valid product
        while (option <= 0 || option >= 4) {
            System.out.println("Please select a valid option");
            option = myObj.nextInt();
        }

        switch (option) {
            case 1:
                viewProducts();
                break;
            case 2:
                purchaseProducts();
                break;
            default:
                topMenu();
                break;
        }
        myObj.close();
    }

    public static void exit() {
        System.out.println("You have exited");
    }

    public static void addProduct() {
        System.out.println("addProduct menu");
    }

    public static void viewInventory() {
        System.out.println("viewInventory menu");
    }

    public static void viewProducts() {
        System.out.println("viewProduct menu");
    }

    public static void purchaseProducts() {
        System.out.println("purchaseProducts menu");
    }

    public static void main(String[] args) {
        topMenu();
    }
}
