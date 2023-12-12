import java.util.Scanner;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

public class Game{
    Difficulty gameDifficulty;
    static Restaurant ourRestaurant;
    Hashtable <String, Boolean> questions;
    static Waiter player;
    static ArrayList<String> customerNames = new ArrayList<String>();

    /** Game constructor */
    public Game(){
        // want to make # of tables change with difficulty perhaps
        ourRestaurant = new Restaurant("The Restaurant man idk", 3); 
        this.questions = new Hashtable <String, Boolean>() ;
        questions(this.questions);
        addCustomerNames(customerNames);
    }

    /** 
     * Adds names to list of possible Customer names
     * @param c list of names
     */
    public void addCustomerNames(ArrayList<String> c){
        c.add("Karen");
        c.add("Derek");
        c.add("null")
    }

    /** Randomly assigns answer to list of questions */
    // Can move this code to the Restaurant class
    public void questions(Hashtable<String, Boolean> q){
        Random random = new Random();
        q.put("Do you take debit cards?",random.nextBoolean());
        q.put("Do you have little spoons for babies?",random.nextBoolean());
        q.put("Does this restaurant have gender-neutral bathrooms?",random.nextBoolean());
        q.put("Do you have craft beer?",random.nextBoolean());
        q.put("Does this restaurant do take out?",random.nextBoolean());
        q.put("Is smoking inside allowed?",random.nextBoolean());
        q.put("Are pets allowed in?",random.nextBoolean());
        q.put("Do you have vegetarian dishes?", true);
        q.put("Do you have vegan dishes?", true);
        q.put("Are there non-alcoholic drinks?", true);
    }

    /**  */
    public void printQuestions(){
        String element = "";
        for (Enumeration<String> e = this.questions.keys(); e.hasMoreElements();){
            element = e.nextElement();
            if (questions.get(element) == true) {
                System.out.println(element + " Yes.");
            }
            else {
                System.out.println(element + " No.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to " + ourRestaurant.getName() + "! I'm your manager, Patrick. What's your name?");
        player.name = input.nextLine();
        System.out.println("We're happy to have you on the team, " + player.getName() + ". You'll be a great waiter in no time!");

        System.out.println("First, take a look at the menu. Make sure you read it over carefully.");
        ourRestaurant.printMenu();
        System.out.println("There's also a few things you should know about the restaurant.");
        ourRestaurant.printQuestions(); //need questions in restaurant, not here
        //System.out.println(ourRestaurant.questions); --> based on Restaurant class. Could this be what you need?

        System.out.println("Don't be afraid to ask for help, but make sure you answer customers quickly! We wouldn't want to keep anyone waiting.");
        System.out.println("Hint: Type 'help' if you're not sure what to do next");
        System.out.println("Alright, time for your first table!");

        Table table1 = new Table();
        
    }
}