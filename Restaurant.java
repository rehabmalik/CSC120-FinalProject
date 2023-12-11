import java.util.ArrayList;

public class Restaurant {
    ArrayList<Table> tables;
    ArrayList <Food> menu;
    ArrayList<Customer> customers;
    String name;

    /** Defualt constructor for restaurant */
    public Restaurant (String name){
        this.name = name;
        this.tables = new ArrayList<Table>();
        this.menu = new ArrayList<Food>();
        this.customers = new ArrayList<Customer>();
    }
     /**
      * Overloaded constructor with the number of tables
      */
    public Restaurant(String name, int n){
        this(name);
        this.tables = new ArrayList<Table>(n);
    }

    /**
     * Gives name of Restaurant
     * @return name
     */
    public String getName(){
        return this.name;
    }

    public void addToMenu(Food food){
        menu.add(food);
    }
    
    public void printMenu(){
        System.out.println("** " + this.getName() + "Menu! **");
        for (Food f: this.menu){
            f.print();
        }
    }


    public static void main(String[] args) {
        Food ab = new Food ("ab", FoodCategory.DRINK, false, false, false, false, false, 2);
        Restaurant myRestaurant = new Restaurant("Pashm");
        myRestaurant.addToMenu(ab);
        ab.toString();
       // myRestaurant.printMenu();
    }

}
