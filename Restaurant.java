import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Restaurant {
    /** arraylist of tables in the restaurant */
    ArrayList<Table> tables;
    /** arraylist of foods */
    public ArrayList <Food> menu;
    /** arraylist of customers */
    ArrayList<Customer> customers;
    /** string of restaurant name */
    public String name;
    /** hashtable of customer questions and keys */
    Hashtable <String, Boolean> questions;
    private Random random;
    /** arraylist of customer questions */
    ArrayList <String> questionKeys;

    /** Defualt constructor for restaurant */
    public Restaurant (String name){
        this.name = name;
        this.tables = new ArrayList<Table>();
        this.menu = new ArrayList<Food>();
        
        //customer
        this.customers = new ArrayList<Customer>();

        //questions hashtable
        this.questions = new Hashtable<String, Boolean>();
        this.random = new Random();
        this.questions.put("Do you take debit cards?", random.nextBoolean());
        this.questions.put("Do you have little spoons for babies?", random.nextBoolean());
        this.questions.put("Does this restaurant have gender-neutral bathrooms?", random.nextBoolean());
        this.questions.put("Do you have craft beer?", random.nextBoolean());
        this.questions.put("Does this restaurant do take out?", random.nextBoolean());
        this.questions.put("Is smoking inside allowed?", random.nextBoolean());
        this.questions.put("Are pets allowed in?", random.nextBoolean());
        this.questions.put("Does Matcha contain caffeine?", true);
        this.questions.put("Do you have vegetarian dishes?", true);
        this.questions.put("Do you have vegan dishes?", true);
        this.questions.put("Are there any drinks without alcohol?", true);

        //questions keys
        this.questionKeys = new ArrayList<>();
        this.questionKeys.add("Do you take debit cards?");
        this.questionKeys.add("Do you have little spoons for babies?");
        this.questionKeys.add("Does this restaurant have gender-neutral bathrooms?");
        this.questionKeys.add("Do you have craft beer?");
        this.questionKeys.add("Does this restaurant do take out?");
        this.questionKeys.add("Is smoking inside allowed?");
        this.questionKeys.add("Are pets allowed in?");
        this.questionKeys.add("Does Matcha contain caffeine?");
        this.questionKeys.add("Do you have vegetarian dishes?");
        this.questionKeys.add("Do you have vegan dishes?");
        this.questionKeys.add("Are there any drinks without alcohol?");
        
        
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
        return this.name;
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
        System.out.println("** " + this.getName() + "Menu! **");
        for (Food f: this.menu){
            f.print();
        }
    }
     /**
      * adds customer to the first vacant spot on a table
      * @param customer
      */
    public void enter(Customer customer){
        for (Table table : tables) {
            try {
                table.sitCustomer(customer);
                System.out.println(customer.getName() + " seated at Table " + tables.indexOf(table));
                // Customer seated successfully, break out of the loop
                break;
            } catch (RuntimeException e) {
                // Table is full or customer is already seated, try the next table
            }
        }
    }

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
