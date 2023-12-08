import java.util.ArrayList;

public class Table{
    ArrayList <Customer> customers;
    final int nCustomers = 4;
    
    public Table(){
        this.customers = new ArrayList<Customer>();
    }

    public void sitCustomer(Customer customer){
        if (this.customers.size() == 4){
            throw new RuntimeException("This table is full!");
        }

        if (this.customers.contains(customer)){
            throw new RuntimeException(customer.getName() + "is already seated here!");
        }

        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer){
        if (this.customers == null){
            throw new RuntimeException("This table is empty!");
        }

        if (!this.customers.contains(customer)){
            throw new RuntimeException(customer.getName() + "is not at this table!");
        }

        this.customers.remove(customer);
    }

}
