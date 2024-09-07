public class Item {
    private String name;
    private int quantityAvailable;
    private double cost;



    Item(String name, int quantityAvailable, double cost){
        this.name = name;
        this.quantityAvailable = quantityAvailable;
        this.cost = cost;
    }
    Item(){
        this.name = "";
        this.quantityAvailable = 0;
        this.cost = 0;
    }
    // get name
    public String getName(){
        return this.name;
    }
    // set name
    public void setName(String name){
        this.name=name;
    }
    // get quantity available
    public int getQuantityAvailable(){
        return this.quantityAvailable;
    }
    // set quantity available
    public void setQuantityAvailable(int quantityAvailable){
        this.quantityAvailable=quantityAvailable;
    }
    // get cost
    public double getCost(){
        return this.cost;
    }
    // set cost
    public void setCost(double cost){
        this.cost=cost;
    }
}
