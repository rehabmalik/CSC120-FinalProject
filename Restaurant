public class Restaurant {
    ArrayList<Table> tables;
    Hashtable <Food, Double> menu;
    ArrayList<Customer> customers;
    String name;

    /** Defualt constructor for restaurant */
    public Restaurant (String name){
        this.name = name;
        this.tables = new ArrayList<Table>();
        this.menu = new Hashtable<Food, double>();
        this.customers = new ArrayList<Customer>();
    }
     /**
      * Overloaded constructor with the number of tables
      */
    public Restaurant(String name, int n){
        this();
        this.tables = new ArrayList<Table>(n);
    }
}