package magazine;
import java.util.ArrayList;

/**
 * Contains associate customer details
 */
public class AssociateCustomer
{
    private String name; //Name of associate customer
    private String email; //Email ID of associate customer
    private char customerType; //Customer type  (P/A)
    
    
    private ArrayList<String> AssociateSupplements; //List of supplements
    
    /**
     * Constructor
     * @param name Associate customer name
     * @param email Email
     * @param customerType Customer Type
     * @param AssociateSupplements Associate customer supplement list
     */
    public AssociateCustomer(String name, String email, char customerType, ArrayList<String> AssociateSupplements)
    {
        this.name = name;
        this.email = email;
        this.customerType = customerType;
        this.AssociateSupplements = AssociateSupplements;
        
    }
    
    /**
     * 
     * @return Name of associate customer
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * 
     * @return Email ID of associate customer
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * 
     * @return Customer type (P/A)
     */
    public char getCustomerType()
    {
        return customerType;
    }
      
    /**
     * 
     * @return List of supplements
     */
     public ArrayList<String> getAssociateSupplementList()
    {
        return AssociateSupplements;
    }
     
    /**
    * Method to add supplements to the associate customer's subscription list
    * @param supp Supplement
    */
    public void addSupplement(String supp)
    {
        AssociateSupplements.add(supp);
    }
      
}
