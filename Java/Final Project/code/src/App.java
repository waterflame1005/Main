import java.util.Scanner;

public class App {
    private static Item[] items = new Item[0];

    // top menu
    public static void topMenu() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("This is the top level menu. Please select one of the following options:");
        System.out.println("1. Inventory Actions");
        System.out.println("2. Sales Actions");
        System.out.println("3. Exit");
        int option = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option <= 0 || option >= 4) {
            System.out.println("Please select a valid option");
            option = Integer.parseInt(myObj.nextLine());
        }

        switch (option) {
            case 1:
                Inventory();
                break;
            case 2:
                if(items.length == 0){
                    System.out.println("Please add at least one product before proceeding to sales");
                    topMenu();
                }
                else{
                    Sales();
                }
                
                break;
            default:
                exit();
                break;
        }
        myObj.close();
    }

    // administration menu
    public static void Inventory() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("This is the inventory menu. Please select one of the following options:");

        System.out.println("1. Add product");
        System.out.println("2. View inventory");
        System.out.println("3. Modify product properties");
        System.out.println("4. Return to top menu");
        int option = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option <= 0 || option >= 5) {
            System.out.println("Please select a valid option");
            option = Integer.parseInt(myObj.nextLine());
        }
        
        switch (option) {
            case 1:
                addProduct();
                break;
            case 2:
                if(items.length == 0){
                    System.out.println("Please add at least one product before viewing inventory");
                    Inventory();
                }
                else{
                    viewInventory();
                }
                break;
            case 3:
                if(items.length == 0){
                    System.out.println("Please add at least one product before viewing modifying products");
                    Inventory();
                }
                else{
                    modifyProduct();
                }
                break;
            default:
                topMenu();
                break;
        }
        
        myObj.close();
    }

    // reporting menu
    public static void Sales() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("This is the sales menu. Please select one of the following options:");
        System.out.println("1. View a list of products and properties");
        System.out.println("2. Buy an amount of product");
        System.out.println("3. Return an amount of product");
        System.out.println("4. Return to top menu");
        int option = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option <= 0 || option >= 5) {
            System.out.println("Please select a valid option");
            option = Integer.parseInt(myObj.nextLine());
        }

        switch (option) {
            case 1:
                viewProduct();
                break;
            case 2:
                buyProduct();
                break;
            case 3:
                returnProduct();
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

    public static void addProduct(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter the name of the product you wish to add:");
        String name = myObj.nextLine();
        System.out.println("Please enter the quantity of the product you wish to add:");
        int quantityAvailable = Integer.parseInt(myObj.nextLine());
        System.out.println("Please enter the cost of the product you wish to add:");
        double cost = Double.parseDouble(myObj.nextLine());
        System.out.println("Product " + name + " has been added to the system.");
        Item[] tempItems = new Item[items.length+1];
        for (int i = 0; i<items.length; i++){
            tempItems[i]=items[i];
        }
        tempItems[items.length]= new Item(name, quantityAvailable, cost);
        items = tempItems;
        Inventory();
    }

    public static void viewInventory(){
        System.out.println("Here are the quantities available of each item:");
        for (int i = 0; i<items.length; i++){
            System.out.println(items[i].getName() + ": " + items[i].getQuantityAvailable());
        }
        Inventory();
    }
    
    public static void modifyProduct(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Which product do you wish to modify?");
        for(int i = 0; i < items.length; i++){
            System.out.println((i+1) + ": " + items[i].getName());
        }
        int option = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option <= 0 || option >= items.length+1) {
            System.out.println("Please select a valid option");
            option = Integer.parseInt(myObj.nextLine());
        }

        System.out.println("What do you want to modify about product " + option);
        System.out.println("1: Name");
        System.out.println("2: Quantity Available");
        System.out.println("3: Cost");
        System.out.println("4: Cancel Modification");
        int option2 = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option2 <= 0 || option2 >= 5) {
            System.out.println("Please select a valid option");
            option = Integer.parseInt(myObj.nextLine());
        }
        if(option2 == 4){
            Inventory();
        }
        else{
            switch (option2) {
                case 1:
                    System.out.println("What do you wish to change the name to?");
                    items[option-1].setName(myObj.nextLine());
                    System.out.println("You have successfully changed the name");
                    break;
                case 2:
                    System.out.println("What do you wish to change the quantity available to?");
                    items[option-1].setQuantityAvailable(Integer.parseInt(myObj.nextLine()));
                    System.out.println("You have successfully changed the quantity available");
                    break;
                default:
                    System.out.println("What do you wish to change the cost to?");
                    items[option-1].setCost(Double.parseDouble(myObj.nextLine()));
                    System.out.println("You have successfully changed the cost");
                    break;
            }
            Inventory();
        }
        


    }

    public static void viewProduct(){
        System.out.println("Here is a list of all products");
        for(int i = 0; i < items.length; i++){
            System.out.println("Item " + (i+1) + ":");
            System.out.println("Name: " + items[i].getName());
            System.out.println("Quantity Available: " + items[i].getQuantityAvailable());
            System.out.println("Cost: " + items[i].getCost());
        }
        Sales();
    }

    public static void buyProduct(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter the number corresponding to the product you wish to buy");
        int option = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option <= 0 || option >= items.length+1) {
            System.out.println("Please select a valid option");
            option = Integer.parseInt(myObj.nextLine());
        }

        System.out.println("How many " + items[option-1].getName() + " do you want to buy?");
        int option2 = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option2 <= 0) {
            System.out.println("Please enter a positive value");
            option2 = Integer.parseInt(myObj.nextLine());
        }
        if(option2 > items[option-1].getQuantityAvailable()){
            System.out.println("Sorry. We only have " + items[option-1].getQuantityAvailable() + " available units of " + items[option-1].getName() + ". Please rebuy the product.");
        }
        else{
            System.out.println("The cost of " + option2 + " " + items[option-1].getName() + " will cost $" + (option2 * items[option-1].getCost()) + ". Type 1 if you wish to proceed, or 0 if you wish to cancel.");
            int option3 = Integer.parseInt(myObj.nextLine());
            // check for valid selection
            while (option3 < 0 || option3 > 1) {
                System.out.println("Please select a valid option");
                option = Integer.parseInt(myObj.nextLine());
            }
            if(option3 == 1){
                System.out.println("Thank you for your purchase.");
                items[option-1].setQuantityAvailable(items[option-1].getQuantityAvailable()-option2);
            }
            else{
                System.out.println("Order has been cancelled.");
            }
        }
        

        Sales();
    }
    public static void returnProduct(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter the number corresponding to the product you wish to return");
        int option = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option <= 0 || option >= items.length+1) {
            System.out.println("Please select a valid option");
            option = Integer.parseInt(myObj.nextLine());
        }

        System.out.println("How many " + items[option-1].getName() + " do you want to return?");
        int option2 = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option2 <= 0) {
            System.out.println("Please enter a positive value");
            option2 = Integer.parseInt(myObj.nextLine());
        }

        
        System.out.println("You will recieve $" + (option2 * items[option-1].getCost()) + " for the return of " + option2 + " " + items[option-1].getName() + ". Type 1 if you wish to proceed, or 0 if you wish to cancel.");
        int option3 = Integer.parseInt(myObj.nextLine());
        // check for valid selection
        while (option3 < 0 || option3 > 1) {
            System.out.println("Please select a valid option");
            option = Integer.parseInt(myObj.nextLine());
        }
        if(option3 == 1){
            System.out.println("You have successfully been given a refund.");
            items[option-1].setQuantityAvailable(items[option-1].getQuantityAvailable()-option2);
        }
        else{
            System.out.println("Refund has been cancelled.");
            items[option-1].setQuantityAvailable(items[option-1].getQuantityAvailable()+option2);
        }
        
        

        Sales();
    }
    public static void main(String[] args) {
        topMenu();
    }
}
