public class Waiter {

    /**
     * Player name
     */
    String name;

    /**
     * Name of the player's date
     */
    String dateName;

    /**
     * Amount of tips the player currently has
     */
    private double tips;

    /**
     * Current no. of times the user has fucked up
     */
    private int currentFuckUps;

    /**
     * Sets maximum no. of times user can fuck up to 5
     */
    final private int maxFuckUps = 5;

    /**
     * Whether or not the player is fired
     */
    boolean isFired = false;

    public Waiter(String name, String dateName){
        this.name = name;
        this.dateName = dateName;
        this.tips = 0;
        this.currentFuckUps = 0;
    }
     /**
     * Returns the current number of times the player has fucked up
     * @return currentFuckUps
     */

    public int getCurrentFuckUps(){
        return this.currentFuckUps;
    }

    /**
     * Returns the maximum number of times the player can fuck up
     * @return maxFuckUps
     */
    public int getMaxFuckUps() {
        return maxFuckUps;
    }

    /**
     * Returns the current amount of tips the player has
     * @return tips
     */
    public double getTips() {
        return this.tips;
    }

    /**
     * Outputs a message to welcome the customer and begin their order
     */
    public void greet(){
        System.out.println("Hello! My name is " + this.name + "Welcome to " + Restaurant.name + ". What can I get started for you today?");
    }

    public void enterOrder(){
        /*enters order for the customer, should there be a certain format? or just parameters? */
    }

    public void answerQuestion(answer){
        /*asnwers the user's question */
    }

    private void askKitchen(question){
        /*checks the list of questions for an answer?? and returns it?? */
    }

    public void viewMenu(){
        Restaurant.printMenu();
        /*prints the menu */
    }

    public void serveFood(Food food, Customer customer){
        /*serves food from last order to customer */
    }

    public void help(){
        /*shows all available commands */
    }

}
