import java.util.Scanner;
import java.util.ArrayList;

public class Help{
    Scanner scanner = new Scanner(System.in);
    /**
     * Stores a list of all the available commands the player can use
     */
    public ArrayList<String> availableCommands;

    public Help(){
        this.availableCommands = new ArrayList<>();
        availableCommands.add("Get Current Fuck Ups");
        availableCommands.add("Get Fuck Ups Left");
        availableCommands.add("Get Max Fuck Ups");
        availableCommands.add("Get Tips");
        availableCommands.add("View Menu");
    }

    /**
     * Allows the player to choose to get a list of available commands they can use or access the game rules again
     */
    public void help(){
        System.out.println("What do you need help with?\n" + "A. Available Commands\n" + "B. Game Rules\n");
        if (scanner.nextLine().equals("A")){
            System.out.println("This is a list of all the commands you can use. Please enter one.");
            for (String x: availableCommands) {
                System.out.println(x);
            }
        }
        else if (scanner.nextLine().equals("B")){
            /*prints all game rules */
        }
        else {
            System.out.println("Choose one of the given options.");
            help();
        }
    }

    public static void main(String[] args) {
        Help gameHelp = new Help();
        gameHelp.help();
    }
}
