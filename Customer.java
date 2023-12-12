/* This is a stub for the Customer class */
import java.util.Random; 

/** 
 *  Class representing customers 
 *  Customers are contained in Table which is contained in Restaurant
 */ 
 
public class Customer{


    //attributes
    public String name;
    public Food order; 
    public Boolean hasQuestion; 
    public Integer finalTip;
    public Table table;
    

    /** 
    *  Constructs a house using its parameters and initializes residents
    *  @param 
    */

    //constructor 
    public Customer(String name, Food order, Boolean hasQuestion) {
        
        //initialize residents to a new ArrayList<String>()
        this.name = name; 
        this.order = order;
        this.hasQuestion = false;
        this.finalTip = 10;
    }

    //accessors

    /** 
    *  Checks if the house has a dining room
    *  @return T/F on whether the house has a dining room or not 
    */


    public Food order(){
        // print customers order
        System.out.println(this.name + ": I'll have the " + order.name + ".");
        return order;
    }


    public String askQuestion(){
        //get random number
        Random rand2 = new Random();
        int randomQ = rand2.nextInt(Restaurant.questionKeys.size());
        
        //picks randomly
        String chosenQ = Restaurant.questionKeys.get(randomQ);

        return chosenQ;
    }


    public void tip(int amount){
        //default tip amount is $10
        finalTip = finalTip + amount;
    }
 
    public Integer finalTip(){
        //accessing the table's total tip 
        return this.finalTip;
    }

    public String getName(){
        return this.name;
    }


    public Table getTable(){
        return this.table;
    }
    
}
