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
    public String name;
    Hashtable <String, Boolean> questions;
    private Random random;
    ArrayList <String> questionKeys;

    /** Defualt constructor for restaurant */
    public Restaurant (String name){
        this.name = name;
        this.tables = new ArrayList<Table>();
        this.menu = new ArrayList<Food>();
        


        this.customers = new ArrayList<Customer>();


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
