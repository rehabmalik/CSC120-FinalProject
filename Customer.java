/* This is a stub for the Customer class */

import java.util.ArrayList;
import java.util.Random; 

/** 
 *  Class representing customers 
 *  Customers are contained in Table which is contained in Restaurant
 *  Parent class of hardCustomer, easyCustomer, mediumCustomer
 */
 
public class Customer{


    //attributes
    private String name;
    private Arraylist <food> Order;
    private Random randomPreference;
    
     

    /** 
    *  Constructs a house using its parameters and initializes residents
    *  @param name  The name of house
    *  @param address  The address of house
    *  @param nFloors  The number of floors
    *  @param hasDiningRoom  If the house has a dining room  
    *  @param hasElevator  If the house has an elevator 
    */

    //constructor 
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        super(name, address, nFloors);

        System.out.println("\n===\nYou have built a house: 🏠\n===\n");
        
        //initialize residents to a new ArrayList<String>()
        this.residents = new ArrayList<String>(); 
        this.hasDiningRoom = hasDiningRoom; //sets hasDiningRoom to indicate whether or not the house has a dining room. 
        this.hasElevator = hasElevator;
    }


    /** 
     *  Checks if the house has a dining room
    *  @return T/F on whether the house has a dining room or not 
    */

    //accessors
    public boolean enterRestaurant(){ 
        this.add to restaurant.customers
    }


    public boolean exitRestaurant(){
        this.remove from restaurant.customers
    }


    public order(){

    }

    public askQuestion(){

    }

    public tip(){

    }

    /** 
     *  Counts and returns the number of residents in the house
    *  @return the size of the residents 
    */

    public chooseRandom(){

    }
    


    

}
