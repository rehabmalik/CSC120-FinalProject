/* This is a stub for the Customer class */

import java.util.ArrayList;
import java.util.Map;
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
    public Integer finalTip = 10;
    
     

    /** 
    *  Constructs a house using its parameters and initializes residents
    *  @param 
    */

    //constructor 
    public Customer(String name, Food order, Boolean hasQuestion, Integer finalTip) {
        
        //initialize residents to a new ArrayList<String>()
        this.name = ""; 
        this.order = "";
        this.hasQuestion = false;
        this.finalTip = finalTip;
    }

    //accessors

    /** 
    *  Checks if the house has a dining room
    *  @return T/F on whether the house has a dining room or not 
    */


    public String order(){
        //get random number of the length of Hashtable 
        Random rand = new Random();
        int randomOrder = rand.nextInt(15);

        // access menu
        String chosenFood = Restaurant.menu.get(randomOrder);

        // print customers order
        System.out.println("Can I have " + chosenFood + "?");

        return chosenFood;
    }


    public String askQuestion(){
        //get random number
        Random rand2 = new Random();
        int randomQ = rand2.nextInt(Restaurant.questionKeys.size());
        
        //picks randomly
        String chosenQ = Restaurant.questionKeys.get(randomQ);

        return chosenQ;
    }


    public void tip(amount){
        //default tip amount is $10
        finalTip = finalTip + amount;
    }
 
    public Integer finalTip(){
        //accessing the table's total tip 
        return this.finalTip;
    }
    
}
