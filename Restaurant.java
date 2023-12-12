import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Restaurant {
    /** arraylist of tables in the restaurant */
    ArrayList<Table> tables;
    /** arraylist of foods */
    public static ArrayList <Food> menu = new ArrayList<Food>();
    /** arraylist of food names */
    public static ArrayList <String> menuItems = new ArrayList<String>();
    /** arraylist of customers */
    ArrayList<Customer> customers;
    /** string of restaurant name */
    public static String name;
    /** hashtable of customer questions and keys */
    static Hashtable <String, Boolean> questions;
    private Random random;
    /** arraylist of customer questions */
    static ArrayList <String> questionKeys;

    /** Defualt constructor for restaurant */
    public Restaurant (String name){
        Restaurant.name = name;
        this.tables = new ArrayList<Table>();
        
        //customer
        this.customers = new ArrayList<Customer>();

        //questions hashtable
        Restaurant.questions = new Hashtable<String, Boolean>();
        this.random = new Random();
        Restaurant.questions.put("Do you take debit cards?", random.nextBoolean());
        Restaurant.questions.put("Do you have little spoons for babies?", random.nextBoolean());
        Restaurant.questions.put("Does this restaurant have gender-neutral bathrooms?", random.nextBoolean());
        Restaurant.questions.put("Do you have craft beer?", random.nextBoolean());
        Restaurant.questions.put("Does this restaurant do take out?", random.nextBoolean());
        Restaurant.questions.put("Is smoking inside allowed?", random.nextBoolean());
        Restaurant.questions.put("Are pets allowed in?", random.nextBoolean());
        Restaurant.questions.put("Does Matcha contain caffeine?", true);
        Restaurant.questions.put("Do you have vegetarian dishes?", true);
        Restaurant.questions.put("Do you have vegan dishes?", true);
        Restaurant.questions.put("Are there any drinks without alcohol?", true);

        //questions keys
        Restaurant.questionKeys = new ArrayList<>();
        Restaurant.questionKeys.add("Do you take debit cards?");
        Restaurant.questionKeys.add("Do you have little spoons for babies?");
        Restaurant.questionKeys.add("Does this restaurant have gender-neutral bathrooms?");
        Restaurant.questionKeys.add("Do you have craft beer?");
        Restaurant.questionKeys.add("Does this restaurant do take out?");
        Restaurant.questionKeys.add("Is smoking inside allowed?");
        Restaurant.questionKeys.add("Are pets allowed in?");
        Restaurant.questionKeys.add("Does Matcha contain caffeine?");
        Restaurant.questionKeys.add("Do you have vegetarian dishes?");
        Restaurant.questionKeys.add("Do you have vegan dishes?");
        Restaurant.questionKeys.add("Are there any drinks without alcohol?");
        
        
    }
     /**
      * Overloaded constructor with the number of tables
      */
    public Restaurant(String name, int n){
        this(name);
        this.tables = new ArrayList<Table>(n);
    }

    public void addTable(){
        Table table = new Table();
        this.tables.add(table);
    }

    /**
     * Gives name of Restaurant
     * @return name
     */
    public String getName(){
        return Restaurant.name;
    }
     
     /**
      * adds food to menu
      * @param food
      */
    public void addToMenu(Food food){
        menu.add(food);
    }

     /**
      * prints menu in the format of "-- costs $--"
      */
    public void printMenu(){
        System.out.println("** " + this.getName() + " Menu! **");
        for (Food f: Restaurant.menu){
            f.print();
        }
    }
     /**
      * adds customer to the first vacant spot on a table
      * @param customer
      */
    public void enter(Customer customer, Table t){
        try {
            t.sitCustomer(customer);
            System.out.println(customer.getName() + " has been seated.");
        } catch (RuntimeException e) {
            // Table is full or customer is already seated, try the next table
            }
        
    }

    // Don't think we need this, can be directly accessed from Customer
    public void exit(Customer customer){
        customer.getTable.removeCustomer(customer);
    }


    public static void main(String[] args) {
        Food ab = new Food ("ab", FoodCategory.DRINK, false, false, false, false, false, 2);
        Restaurant myRestaurant = new Restaurant("Pashm");
        myRestaurant.addToMenu(ab);
        ab.toString();
       // myRestaurant.printMenu();
    }

}
