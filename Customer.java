package magazine;
import java.util.ArrayList;

/**
 * Contains paying customer information
 */
public class Customer 
{
    private String name; //Customer name
    private String email; //Customer email if
    private char customerType; //Customer Type (P/A)
    private long bankAccount; //Bank account number
    private String paymentMethod; //Payment method (Debit/Credit)
    private ArrayList<String> PayingSupplements; //Supplement list
    
    //List of associate customer for the paying customer instance
    private ArrayList<AssociateCustomer> AssocListObj = new ArrayList<AssociateCustomer>();
    
    /**
     * Constructor
     * @param name Paying customer name
     * @param email Email
     * @param customerType Customer Type
     * @param bankAccount Bank Account number
     * @param paymentMethod Payment Method (Debit/Credit)
     * @param PayingSupplements Paying customer supplement list
     */
    public Customer(String name,String email, char customerType, long bankAccount, String paymentMethod, 
            ArrayList<String> PayingSupplements)
    {
        this.name = name;
        this.email = email;
        this.customerType = customerType;
        this.bankAccount = bankAccount;
        this.paymentMethod = paymentMethod;
        this.PayingSupplements = PayingSupplements;
      
    }
    
    /**
     * 
     * @return Customer name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * 
     * @return Email id
     */
    public String getEmail()
    {
        return email;
    }
    
    
    /**
     * 
     * @return Customer Type
     */
    public char getCustomerType()
    {
        return customerType;
    }
    
    /**
     * 
     * @return Bank account number
     */
    public long getBankAccount()
    {
        return bankAccount;
    }
    
    /**
     * 
     * @return Payment method
     */
    public String getPaymentMethod()
    {
        return paymentMethod;
    }
    
    /**
     * 
     * @return List of supplements
     */
    public ArrayList<String> getPayingSupplementList()
    {
        return PayingSupplements;
    }
    
    /**
    * Method to add supplements to the paying customer's subscription list
    * @param supp Supplement
    */
    public void addSupplement(String supp)
    {
        PayingSupplements.add(supp);
    }
 
    /**
    * Method to remove a supplement from paying customer's subscription list
    * @param supp Supplement
    */
    public void removeSupplement(String supp)
    {
        PayingSupplements.remove(supp);
    }    
    
    /**
     * Adds new associate customer to a paying customer
     * @param name Associate customer name
     * @param email Email
     * @param customerType Customer type (A)
     * @param AssociateSupplements Supplement list
     */
    public void AddAssociateCustomer(String name, String email, char customerType, ArrayList<String> AssociateSupplements)
    {
        AssociateCustomer obj= new AssociateCustomer(name, email, customerType, AssociateSupplements);
        AssocListObj.add(obj); //new associate customer added here
    }
    
    /**
     * 
     * @return List of Associate customer of a Paying customer
     */
    public ArrayList<AssociateCustomer> getAssocCustomer()
    {
        return AssocListObj;
    }
    
    /**
     * 
     * @param i Specified associate customer from the ArrayList
     * @return A particular Associate customer's information is returned
     */
     public AssociateCustomer getAssocCustomer(int i)
    {
        return AssocListObj.get(i);
    }
    
}
