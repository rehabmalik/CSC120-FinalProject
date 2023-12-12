import java.util.Scanner;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game{
    Difficulty gameDifficulty;
    static Restaurant ourRestaurant;
    Hashtable <String, Boolean> questions;
    static Waiter player;
    static ArrayList<String> customerNames = new ArrayList<String>();
    Random random = new Random();
    String sentence;
    public Scanner input = new Scanner(System.in);

    /** Game constructor */
    public Game(){
        // want to make # of tables change with difficulty perhaps
        ourRestaurant = new Restaurant("The Silky Spoon"); 
        this.questions = new Hashtable <String, Boolean>() ;
        addCustomerNames(customerNames);
        player = new Waiter("", "");
        addMenuItems(Restaurant.menu, Restaurant.menuItems);
    }

    /** 
     * Adds names to list of possible Customer names
     * @param c list of names
     */
    public void addCustomerNames(ArrayList<String> c){
        c.add("Karen");
        c.add("Yusef");
        c.add("Ahmed");
        c.add("Salma");
        c.add("Ezra");
        c.add("Samanosuke");
        c.add("Hasan");
        c.add("Sharmeen");
        c.add("Yuki");
        c.add("Toru");
        c.add("John");
        c.add("Himiko");
    }

    public void addMenuItems(ArrayList <Food> menu, ArrayList<String> menuItems){
        menu.add(new Food("California Roll", FoodCategory.MAIN, false, false, false, false, false, 15));
        menu.add(new Food("Japanese Curry", FoodCategory.MAIN, true, true, false, false, false, 15));
        menu.add(new Food("Moussaka", FoodCategory.MAIN, false, false, false, true, true, 15));
        menu.add(new Food("Biryani", FoodCategory.MAIN, false, false, true, false, false, 15));
        menu.add(new Food("Tahchin", FoodCategory.MAIN, false, true, false, false, true, 15));
        menu.add(new Food("Chana Chaat", FoodCategory.MAIN, true, true, false, false, false, 15));
        menu.add(new Food("Katsudon", FoodCategory.MAIN, false, false, false, true, false, 15));
        menu.add(new Food("Tempura Udon", FoodCategory.MAIN, false, true, false, true, false, 15));
        menu.add(new Food("Matcha Sundae", FoodCategory.DESSERT, false, true, false, true, true, 10));
        menu.add(new Food("Trigona", FoodCategory.DESSERT, false, true, false, true, true, 10));
        menu.add(new Food("Kulfa Falooda", FoodCategory.DESSERT, false, true, false, false, true, 10));
        menu.add(new Food("Baklava", FoodCategory.DESSERT, false, true, false, true, true, 10));
        menu.add(new Food("Fereni", FoodCategory.DESSERT, false, true, false, false, true, 10));
        menu.add(new Food("Water", FoodCategory.DRINK, true, true, false, false, false, 0));
        menu.add(new Food("Lassi", FoodCategory.DRINK, false, true, false, false, true, 5));
        menu.add(new Food("Tea", FoodCategory.DRINK, true, true, false, false, false, 5));
        menu.add(new Food("Beer", FoodCategory.DRINK, true, true, false, true, false, 7));
        menu.add(new Food("Sake", FoodCategory.DRINK, true, true, false, false, false, 7));
        for (int i=0; i<menu.size(); i++){
            menuItems.add(menu.get(i).name);
        }
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

    public void printBorder(int n){
        System.out.println("~ " + "-".repeat(n) + " ~");
    }

    /**
     * Adds 4 customers to table 
     * @param round number of current round
     */
    public void seatTable(Table table, int round){
        int r = round^2;
        // In the first round(round=0), 0 customers will have a question
        // In the second round, 1 customer will have a question
        // In the third round, 4 customers will have a question
        ArrayList<String> unusedNames = Game.customerNames;
        Customer c;
        for (int i=0 ; i<r ; i++){
            c=new Customer(unusedNames.get(random.nextInt(unusedNames.size())), 
            Restaurant.menu.get(random.nextInt(Restaurant.menu.size())), true);
            unusedNames.remove(c.name);
            ourRestaurant.enter(c, table);
        }
        for (int i=0 ; i<(4-r) ; i++){
            ourRestaurant.enter(new Customer(unusedNames.get(random.nextInt(unusedNames.size())), 
            Restaurant.menu.get(random.nextInt(Restaurant.menu.size())), false), table);
        }
    }

    public String setDifficulty(String difficulty){
        while (!difficulty.equalsIgnoreCase("A") && !difficulty.equalsIgnoreCase("B") && !difficulty.equalsIgnoreCase("C")) {
            System.out.println("Game: Select difficulty: \n A. Easy \n B. Medium \n C. Difficult");
            difficulty = input.nextLine();
            if (difficulty.equalsIgnoreCase("A")){
                this.gameDifficulty = Difficulty.EASY;
            }
            else if (difficulty.equalsIgnoreCase("B")){
                this.gameDifficulty = Difficulty.MEDIUM;
            }
            else if (difficulty.equalsIgnoreCase("C")){
                this.gameDifficulty = Difficulty.DIFFICULT;
            }
            else {
                System.out.println("Game: Choose one of the given options.");
            }
        }
        return difficulty;
    }

    public void fullTable(int round){
        Table table = new Table();
        sentence = input.nextLine().toLowerCase();

        if (sentence.contains("welcome")){
            player.welcome();
            this.seatTable(table, round);
        }

        sentence = input.nextLine().toLowerCase();

        if (sentence.contains("greet")){
            player.greet();
            for (int i=0; i<table.customers.size(); i++){
                table.customers.get(i).order();
            }
        }

        sentence = input.nextLine().toLowerCase();

        if (sentence.contains("enter")){
            Customer c;
            for (int i=0; i<table.customers.size(); i++){
                c=table.customers.get(i);
                player.enterOrder(c.order.name, c.name);
            }
        }

        for (int i=0; i<table.customers.size(); i++){
            Customer c = table.customers.get(i);
            if (table.customers.get(i).hasQuestion==true){
                int r = random.nextInt(Restaurant.questionKeys.size());
                String question = Restaurant.questionKeys.get(r);
                System.out.println(question);
                player.answerQuestion(question, 2);
            }
            }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Game g = new Game();
        String sentence; // For player input
        Random random = new Random();
        int round = 0;
        String difficulty = "";

        g.printBorder(25);
        
        difficulty = g.setDifficulty(difficulty);

        g.printBorder(75);

        System.out.print("Manager: Welcome to " + ourRestaurant.getName() + "! I'm your new manager. What's your name? \nYou: ");
        player.name = input.nextLine();
        System.out.println("Manager: We're happy to have you on the team, " + player.getName() + ". You'll be a great waiter in no time!");
        
        // Add later?
        /* System.out.println("Manager: First, take a look at the menu. Make sure you read it over carefully.");
        TimeUnit.SECONDS.sleep(3); // wait 3 seconds
        g.printBorder(70);
        ourRestaurant.printMenu();
        g.printBorder(70);
        TimeUnit.SECONDS.sleep(1); // wait 10 seconds   EDIT THIS BACK
        // MOVE AFTER 1ST TABLE
        System.out.println("Manager: There's also a few questions you should be able to answer.");
        //ourRestaurant.printQuestions(); //need questions in restaurant, not here
        System.out.println(ourRestaurant.questions); //--> based on Restaurant class. Could this be what you need?  */

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Manager: Let's go over what to do when a table arrives.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("         First, *welcome* guests when they arrive!");
        System.out.println("         Next, *greet* the guests once they've sat at the table and take their order.");
        System.out.println("         Next, you'll *enter* their order so it gets sent to the kitchen.");
        System.out.println("         Finally, you'll *serve* their food.");
        System.out.println("         And if customers have any questions, be sure to answer them!");
        System.out.println("         Don't be afraid to ask for help, but make sure you answer customers quickly. We wouldn't want to keep anyone waiting!");
        System.out.println("Hint: Type 'help' if you're not sure what to do next.");
        g.printBorder(60);
        System.out.println("Manager: Alright, time for your first table. Welcome the guests!");

        g.fullTable(round);

        if (player.getCurrentFuckUps()==0){
            System.out.println("Manager: Nice work! Before you move on to your next table, there's a few questions you should be able to answer.");
        }
        else {
            System.out.println("Manager: Ok, a bit of a shaky start. You'll get the hang of it.");
            System.out.println("Before you move on to your next table, there's a few questions you should be able to answer.");
        }
        System.out.println(Restaurant.questions);
        
        for (int i=0; i<2; i++){
            round +=1;
            g.printBorder(60);
            System.out.println("Manager: Alright, time for your next table. You know the drill!");
            g.fullTable(round);
        }

    }
}