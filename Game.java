import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/** Game Class */
public class Game{
    Difficulty gameDifficulty;
    static Restaurant ourRestaurant;
    Hashtable <String, Boolean> questions;
    static Waiter player;
    static ArrayList<String> customerNames = new ArrayList<String>();
    Random random = new Random();
    String sentence;
    public static Scanner input;
    int tip;
    public static ArrayList<String> playerNames = new ArrayList<String>();

    /** Game constructor */
    public Game(){
        // want to make # of tables change with difficulty perhaps
        ourRestaurant = new Restaurant("The Silky Spoon"); 
        this.questions = new Hashtable <String, Boolean>() ;
        addCustomerNames(customerNames);
        player = new Waiter("", "");
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

    /**
     * Prints border with inputted length
     * @param n length of border
     */
    public static void printBorder(int n){
        System.out.println("~ " + "-".repeat(n) + " ~");
    }

    /**
     * Prints text and waits for user input to move to next line
     * @param s text to be printed
     */
    public static void printDialogue(String s){
        System.out.print(s);
        input.nextLine();
    }

    /** Sets difficulty to a user inputted value */
    public void setDifficulty(){
        String difficulty = "";
        while (!difficulty.equalsIgnoreCase("A") && !difficulty.equalsIgnoreCase("B") && !difficulty.equalsIgnoreCase("C")) {
            System.out.println("Game: Select difficulty: \n A. Easy \n B. Medium \n C. Difficult");
            difficulty = input.nextLine();
            if (difficulty.equalsIgnoreCase("A")){
                this.gameDifficulty = Difficulty.EASY;
                tip = 0;
            }
            else if (difficulty.equalsIgnoreCase("B")){
                this.gameDifficulty = Difficulty.MEDIUM;
                tip = -3;
            }
            else if (difficulty.equalsIgnoreCase("C")){
                this.gameDifficulty = Difficulty.DIFFICULT;
                tip = -5;
            }
            else {
                System.out.println("Game: Choose one of the given options.");
            }
        }
    }

    /** Checks name for repeaters */
    public static void checkName(String name){
        if (playerNames.contains(player.name)){
            System.out.println("Welcome back, "+ player.name + "!\nYou are hired again!\n");
        }
        else {
            playerNames.add(player.name);
        }
    }
    

    /** Fires player and ends game */
    public static void fired(){
        printDialogue("Manager: You've fucked up too many times. Take your tips and get out!");
        printDialogue(player.name + ": Damn. Guess I'll have to find another place to work...");
        endGame();
    }

    /** Ends game, gives ending dialogue */
    public static void endGame(){
        printBorder(30);
        printDialogue("Game: You made a total of $" + player.tips);
        printDialogue("      Thank you for playing!");
        System.exit(0);
    }

    /**
     * Adds 4 customers to table 
     * @param round number of current round
     */
    public void seatTable(Table table, int round){
        int r = round*round;
        // In the first round(round=0), 0 customers will have a question
        // In the second round, 1 customer will have a question
        // In the third round, 4 customers will have a question
        ArrayList<String> unusedNames = Game.customerNames;
        Customer c;
        for (int i=0 ; i<r ; i++){
            c = new Customer(unusedNames.get(random.nextInt(unusedNames.size())), 
            Restaurant.menu.get(random.nextInt(Restaurant.menu.size())), true, 10, table);
            unusedNames.remove(c.name);
            ourRestaurant.enter(c, table);
        }
        for (int i=0 ; i<(4-r) ; i++){
            c = new Customer(unusedNames.get(random.nextInt(unusedNames.size())), 
            Restaurant.menu.get(random.nextInt(Restaurant.menu.size())), false, 10, table);
            unusedNames.remove(c.name);
            ourRestaurant.enter(c, table);
        }
    }

    /**
     * Runs a round of the game, seats and serves a table
     * @param round
     */
    public void fullTable(int round) {
        Table table = new Table();
        sentence = input.nextLine().toLowerCase();

        // Welcome guests
        if (sentence.contains("welcome")){
            printDialogue(player.name + ": Welcome to " + Restaurant.name + "! Your table is right this way.");
            printDialogue("Game: Your guests feel welcomed.");
            table.totalTip+=1;
        }

        if (sentence.equalsIgnoreCase("help")){
            Help.help();
        }

        else{
            printDialogue(player.name + ": Your table is right this way.");
            printDialogue("Game: Your guests seem dissapointed that they didn't get a warm welcome.");
            table.totalTip-=1;
        }
        this.seatTable(table, round);

        sentence = input.nextLine().toLowerCase();

        // Greet table
        if (sentence.contains("greet")){
            printDialogue(player.name + ": Hello! My name is " + player.name + ". What can I get started for you today?");
        }
        if (sentence.equalsIgnoreCase("help")){
            Help.help();
        }
        else{
            printDialogue(player.name + ": What would you like to order?");
            printDialogue("Game: Your guests seem dissapointed that they didn't get a friendly greeting.");
            table.totalTip-=1;
        }

        for (int i=0; i<table.customers.size(); i++){
            table.customers.get(i).order();
        }

        printDialogue(player.name + ": I'll get that started for you. Before I go, do you have any questions?");

        // Customers ask questions
        for (int i=0; i<table.customers.size(); i++){
            if (table.customers.get(i).hasQuestion){
                String question = Restaurant.questionKeys.get(random.nextInt(Restaurant.questionKeys.size()));
                printDialogue(table.customers.get(i).name + ": " + question);
                player.answerQuestion(question, tip, table.customers.get(i));
            }
            else{
                printDialogue(table.customers.get(i).name + ": I don't have any questions.");
            }
        }

        printDialogue(player.name + ": Your food will be out soon!");

        sentence = input.nextLine().toLowerCase();

        // Enter order
        if (sentence.equalsIgnoreCase("help")){
            Help.help();
        }
        while (!sentence.contains("enter")){
            System.out.println("Manager: Didn't you just take your table's order? You should have entered it by now!");
            sentence = input.nextLine().toLowerCase();
        }

        printBorder(30);

        ArrayList<Boolean> correctOrder = new ArrayList<Boolean>(); // did player correctly enter order

        if (sentence.contains("enter")){
            Customer c;
            for (int i=0; i<table.customers.size(); i++){
                c=table.customers.get(i);
                correctOrder.add(player.enterOrder(c.order.name, c.name));
            }
        }
        else if (sentence.equalsIgnoreCase("help")){
            Help.help();
        }
        printBorder(30);

        System.out.println("Chef: Order up! " + player.name + ", go serve your table!");
        sentence = input.nextLine().toLowerCase();
        if (sentence.equalsIgnoreCase("help")){
            Help.help();
        }

        // Serve food
        while (!sentence.contains("serve")){
            System.out.println("Chef: Oy, " + player.name + "! Serve the food before it goes cold!");
            sentence = input.nextLine().toLowerCase();
            if (sentence.equalsIgnoreCase("help")){
            Help.help();
            }
        }

        printDialogue(player.name + ": Here's your food! Enjoy your meal.");
        player.serveFood(correctOrder, table, tip);

        player.tips += table.totalTip();
        printDialogue("Game: Your table finished their meal.");
        printDialogue(player.name + ": I got $" + table.totalTip + " in tips from that table. I've earned $" + player.tips + " today!");
    }

    public static void main(String[] args) throws InterruptedException {
        input = new Scanner(System.in);
        Game g = new Game();
        int round = 0;

        Game.printBorder(25);
        
        g.setDifficulty();

        Game.printBorder(75);

        System.out.println("Manager: Welcome to " + ourRestaurant.getName() + "! I'm your new manager. What's your name?");
        System.out.println("Game: Type in a response whenever you are given a new line.");
        player.name = input.nextLine(); 
        Game.checkName(player.name);
        System.out.println(player.name + ": My name is " + player.name + "!");
        printDialogue("Game: Press enter to move to next line of dialogue.");
        printDialogue("Manager: We're happy to have you on the team, " + player.getName() + ". You'll be a great waiter in no time!");

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

        printDialogue("Manager: Let's go over what to do when a table arrives."); 
        System.out.println("         First, *welcome* guests when they arrive!");
        System.out.println("         Next, *greet* your table once they've all sat down and take their order.");
        System.out.println("         Next, you'll *enter* their order so it gets sent to the kitchen.");
        System.out.println("         Finally, you'll *serve* their food.");
        System.out.println("         And if customers have any questions, be sure to answer them!");
        printDialogue("         Don't be afraid to ask for help, but make sure you answer customers quickly. We wouldn't want to keep anyone waiting!"); 
        printDialogue("Hint: Type 'help' if you're not sure what to do next.");
        Game.printBorder(60);
        System.out.println("Manager: Alright, time for your first table. Welcome the guests!");
        g.fullTable(round);

        Game.printBorder(110);
        if (player.getCurrentFuckUps()==0){
            printDialogue("Manager: Nice work! Before you move on to your next table, there's a few questions you should be able to answer.");
        }
        else {
            System.out.println("Manager: Ok, a bit of a shaky start. You'll get the hang of it.");
            printDialogue("         Before you move on to your next table, there's a few questions you should be able to answer.");
        }

        ourRestaurant.printQuestions();
        input.nextLine();

        for (int i=0; i<2; i++){
            round +=1;
            Game.printBorder(60);
            System.out.println("Manager: Alright, time for your next table. You know the drill!");
            g.fullTable(round);
        }
        System.out.println("Manager: Congrats! You've finished your first shift.");
        endGame();
    }
}