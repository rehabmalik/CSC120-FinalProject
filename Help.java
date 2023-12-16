import java.util.Scanner;
import java.util.ArrayList;

public class Help{
    static Scanner scanner = new Scanner(System.in);
    /**
     * Stores a list of all the available commands the player can use
     */
    public static ArrayList<String> availableCommands;

    public Help(){
        availableCommands = new ArrayList<>();
        availableCommands.add("Get Current Fuck Ups");
        availableCommands.add("Get Fuck Ups Left");
        availableCommands.add("Get Max Fuck Ups");
        availableCommands.add("Get Tips");
        availableCommands.add("View Menu");
    }

    /**
     * Allows the player to choose to get a list of available commands they can use or access the game rules again
     */
    public static void help(){
        System.out.println("\nWhat do you need help with?\n" + "A. Available Commands\n" + "B. Game Rules\n");
        String scan1 = scanner.nextLine();
        if (scan1.equalsIgnoreCase("A")){
            System.out.println("This is a list of all the commands you can use.\n\n---");
            System.out.println("welcome\ngreet\nenter\nserve\nhelp");
            System.out.println("---\n");
        }

        else if (scan1.equalsIgnoreCase("B")){
            /*prints all game rules */
            System.out.println("---RULES---");
            System.out.println("- *welcome* guests when they arrive.");
            System.out.println("- *greet* your table once they've all sat down and take their order.");
            System.out.println("- *enter* their order so it gets sent to the kitchen.");
            System.out.println("- *serve* their food.\n");
            System.out.println("- If customers have any questions, be sure to answer them by picking the correct answer that you will be given beforehand.");
            System.out.println("- Don't be afraid to ask for help, but make sure you answer customers quickly. We wouldn't want to keep anyone waiting!\n----------\n\n");
        }

        else {
            help();
        }
    }

    public static void main(String[] args) {
        Help gameHelp = new Help();
        gameHelp.help();
    }
}
