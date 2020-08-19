/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magazine;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main class for the program to manage an online weekly personalized magazine service
 * @author Faiz Syed (33243485)
 */
public class Magazine 
{
    final static double magazinePrice = 2; //price of main magazine
    static ArrayList<Customer> CustomerList = new ArrayList<Customer>();  //Paying customer list   
      
    /**
     * The main method
     * @param args command line arguments
     */
    public static void main(String[] args) 
    {          
        displayStudentDetails();  //Display student details
        
        performAction(); //Runs the main functionalities of the program

    } /*End of Main method*/
    
    
    /**
     * Runs the different functions
     */
    private static void performAction()
    {
        System.out.print("ADDING PAYING CUSTOMERS: ");
        AddPayingCustomers();
        
        if(CustomerList.size() > 0)
        {
            System.out.print("ADDING ASSOCIATE CUSTOMERS: ");
            AddAssociateCustomers();

            System.out.print("DISPLAYING SUBSCRIPTION EMAILS: \n");
            for(int i=0; i<CustomerList.size(); i++)
            {   
                printCustomerEmail(CustomerList.get(i)); /*Weekly magazine email*/
            }

            System.out.print("DISPLAYING PAYMENT BILLS: \n");
            for(int i=0; i<CustomerList.size(); i++) //Printing emails for all customers
            {  
                calcPayment(CustomerList.get(i)); /*Monthly payment email*/
            } 

            System.out.print("REMOVING PAYING CUSTOMERS: \n");
            RemovePayingCustomer();

            System.out.print("REMOVING ASSOCIATE CUSTOMERS: \n");
            RemoveAssociateCustomer();


            System.out.print("DISPLAYING SUBSCRIPTION EMAILS AFTER REMOVING CUSTOMERS: \n");
            for(int i=0; i<CustomerList.size(); i++)
            {   
                printCustomerEmail(CustomerList.get(i)); /*Weekly magazine email*/
            }

            System.out.print("DISPLAYING PAYMENT BIILS AFTER REMOVING CUSTOMERS: \n");
            for(int i=0; i<CustomerList.size(); i++) //Printing emails for all customers
            {  
                calcPayment(CustomerList.get(i)); /*Monthly payment email*/
            } 

            addSupplements(); //Method to add more new supplements to customers

            System.out.print("DISPLAYING PAYMENT BIILS AFTER ADDING NEW SUPPLEMENTS: \n");
            for(int i=0; i<CustomerList.size(); i++) //Printing emails for all customers
            {  
                calcPayment(CustomerList.get(i)); /*Monthly payment email*/
            } 

            removeSupplements(); //Calling method to remove supplements

            System.out.print("DISPLAYING PAYMENT BIILS AFTER REMOVING SUPPLEMENTS: \n");
            for(int i=0; i<CustomerList.size(); i++) //Printing emails for all customers
            {  
                calcPayment(CustomerList.get(i)); /*Monthly payment email*/
            } 
        }
        
        else
            System.out.println("No paying customers have been added!");
        
                        
    }
       
    /**
     * Creates and adds Paying customers
     */
    public static void AddPayingCustomers()
    {       
        ArrayList<String> pc1Supp = new ArrayList<>();
        pc1Supp = AddPayingCustomer1Supp(pc1Supp);
        AddNewPayingCustomer("Tom Sawyer", "tom@student.com", 'P', 1234567, "Debit", pc1Supp);
        
        ArrayList<String> pc2Supp = new ArrayList<>();
        pc2Supp = AddPayingCustomer2Supp(pc2Supp);
        AddNewPayingCustomer("James Richard", "james@student.com", 'P', 1947667, "Credit", pc2Supp);
        
        ArrayList<String> pc3Supp = new ArrayList<>();
        pc3Supp = AddPayingCustomer3Supp(pc3Supp);
        AddNewPayingCustomer("Julian Corman", "julie@student.com", 'P', 464564, "Debit", pc3Supp);
        
        System.out.println("\nNo. of paying customer(s) added: " + CustomerList.size());
        for(int i=0; i<CustomerList.size(); i++)
            System.out.println(CustomerList.get(i).getName());
        System.out.println();
    }
    
    /**
     * Creates and adds associate customers to the given paying customer
     */
        public static void AddAssociateCustomers()
    {
        //AddNewAssociateCustomer(Associate name, email, customer type (A), Paying customer name, Supplement list);
        
        //Associates for 1st Paying customer
        ArrayList<String> Assoc1Supp = new ArrayList<>();
        Assoc1Supp.add("Health");
        Assoc1Supp.add("Fashion");
        AddNewAssociateCustomer("John", "john@ymail.com", 'A', "Julian Corman", Assoc1Supp);      
                                
        
        //Associates for 3rd Paying customer
        ArrayList<String> Assoc3Supp = new ArrayList<>();
        Assoc3Supp.add("Beauty");
        AddNewAssociateCustomer("Alex", "huda@robbie.com", 'A', "Tom Sawyer", Assoc3Supp);
        AddNewAssociateCustomer("Peter", "noora@robbie.com", 'A', "Tom Sawyer", Assoc3Supp);
               
        //Adding an associates customer to non-existent paying customer
        ArrayList<String> Assoc2Supp = new ArrayList<>();
        Assoc2Supp.add("Tech");
        AddNewAssociateCustomer("Robbie", "rob@student.com", 'A', "James Brendon", Assoc2Supp);
                        
    }
    
    
        
    /**
     * 
     * @return return user input
     */
    public static int printMenu()
    {
        Scanner input = new Scanner(System.in);
        int userIn;
        
        System.out.println("Select an option: \n1) Print weekly magazine Email \n2) "
                + "Print monthly payment Email\n3) Add Paying customers\n4) Add Associate customers\n"
                + "5) Remove Paying customer\n6) Remove Associate Customer\n7) Exit\n");
        
        //Takes user input
        System.out.println("Enter Choice: ");
        userIn = input.nextInt();
        
        return userIn;
    }
    
    /**
     * Prints weekly customer email
     * @param obj Customer object
     */  
    public static void printCustomerEmail(Customer obj)
    {
        System.out.println("Dear " + obj.getName() + 
                ",\t\t" + LocalDate.now());

        //Printing the supplements paying customer has subscribed to 
        /*for(int j=0; j<obj.getPayingSupplementList().size(); j++)
        {
            System.out.println((j+1) + ") " + obj.getPayingSupplementList().get(j) +" - $" 
                    + getPrices(obj.getPayingSupplementList().get(j)));
        }*/
        
        //Printing the supplements paying customer has subscribed to 
        printPayingCustomerSupplements(obj);

        //Printing the supplements Associate customers have subscribed to
        printAssociateCustomerSupplements(obj);

        
        System.out.println("\n");
    }
    
    /**
     * Prints list of supplements subscribed by the Paying customer
     * @param obj An object of Customer
     */
    public static void printPayingCustomerSupplements(Customer obj)
    {
        System.out.println("Your weekly magazine includes: ");
        for(int j=0; j<obj.getPayingSupplementList().size(); j++)
        {
            System.out.println((j+1) + ") " + obj.getPayingSupplementList().get(j) +" - $" 
                    + getPrices(obj.getPayingSupplementList().get(j)));
        }
    }
    
    /**
     * Prints list of supplements subscribed by the Associate customer
     * @param obj Customer object
     */
    public static void printAssociateCustomerSupplements(Customer obj)
    {  
        //No.of associate customers for this paying customer(obj)
        for(int i=0; i<obj.getAssocCustomer().size(); i++)
        {           
            System.out.println("Associate customer " + (i+1) + " name: " + obj.getAssocCustomer().get(i).getName());
            System.out.println("Subscriptions: ");
            //No.of supplements subscribed by associate customer
            for(int j=0; j<obj.getAssocCustomer(i).getAssociateSupplementList().size(); j++)
            {
                //printing the supplements each associate customer has subscribed to
                System.out.println((j+1) + ") " +  obj.getAssocCustomer(i).getAssociateSupplementList().get(j)
                 + " - $" + getPrices(obj.getAssocCustomer(i).getAssociateSupplementList().get(j)));                                          
            }
        }       
    }
    
    /**
     * Calculates the monthly total cost of the magazine and supplements
     * @param obj 
     */
    private static void calcPayment(Customer obj)
    {
        String suppName;
        int numOfWeeks;
        
        //Source: https://howtodoinjava.com/java/date-time/java-date-examples/
        SimpleDateFormat sdf = new SimpleDateFormat("MMM/yyyy");
        String date = sdf.format(new Date());     
        
        System.out.println("Monthly Payment Bill\t\tMonth: " + date);
        if(Character.toUpperCase(obj.getCustomerType()) == 'P')
        {
            System.out.println("\nPaying Customer: " + obj.getName());
            double cost = 0;         
              
            //Adding up cost of supplements subscribed by Paying Customer
            for(int i=0; i<obj.getPayingSupplementList().size(); i++)
            {
                suppName = obj.getPayingSupplementList().get(i);                
                cost += getPrices(suppName); //getting the price of supplements
            }
            
            //Adding up cost of supplements subscribed by Associate Customer
            for(int i=0; i<obj.getAssocCustomer().size(); i++)
            {
                for(int j=0; j<obj.getAssocCustomer(i).getAssociateSupplementList().size(); j++)
                {
                    suppName = obj.getAssocCustomer(i).getAssociateSupplementList().get(j);                    
                    cost += getPrices(suppName);
                }
            }
            
            //Adding up the fixed cost of magazine
            cost += magazinePrice * (obj.getAssocCustomer().size() + 1);
                      
            //To get number of weeks in the current month
            numOfWeeks = getWeeks();
            
            //cost times by the number of weeks in the month
            cost = cost * numOfWeeks;
            
            //Output of total cost
            printPayment(obj, magazinePrice, cost);
        }        
    }
    
    /**
     * Prints the final cost bill
     * @param obj an object of Customer
     * @param magazinePrice Price of main magazine $2
     * @param cost Final payment cost
     */
    public static void printPayment(Customer obj, double magazinePrice, double cost)
    {
        printPayingCustomerSupplements(obj);
            System.out.println("\nNo. of Associates: " + obj.getAssocCustomer().size());
            printAssociateCustomerSupplements(obj);
            System.out.println("\nPayment method: " + obj.getPaymentMethod());
            System.out.println("Account No: " + obj.getBankAccount());
            System.out.println("Weekly cost of main magazine per customer: $" + magazinePrice);
            System.out.println("Total Cost: $" + cost);
            System.out.println("______________________________________________________");            
            System.out.println("\n");
    }
    

    
    
    /**
     * Method to get the price of a given supplement
     * @param suppName Supplement
     * @return The price of given supplement
     */
    public static double getPrices(String suppName)
    {
        Supplement supp = new Supplement();
        double cost = 0;
        
        switch (suppName) 
        {
            case "Nature":
                cost += supp.getNature();
                break;
            case "Tech":
                cost += supp.getTech();
                break;
            case "Health":
                cost += supp.getHealth();
                break;
            case "Fashion":
                cost += supp.getFashion();
                break;
            case "Trade":
                cost += supp.getTrade();
                break;
            case "Beauty":
                cost += supp.getBeauty();
                break;
            case "Research":
                cost += supp.getResearch();
                break;
        }
        
        return cost;
    }
    

    /**
     * Method to add a new Paying customer
     * @param name Paying customer name
     * @param email email id
     * @param customerType Type of customer (P/A)
     * @param bankAccount Bank account number
     * @param paymentMethod Payment method (Debit/Credit)
     * @param PayingSupplements A list of supplements customer has subscribed to
     */
    public static void AddNewPayingCustomer(String name, String email, char customerType, long bankAccount,
                    String paymentMethod, ArrayList<String> PayingSupplements)
    {    
        try {
                if((!name.matches("[a-zA-Z ]+")))
                 throw new Exception(name);
                
                //try-catch block inside another try block
                try
                {
                    if((!validateEmail(email)))
                      {
                          throw new Exception(email);
                      }

                      else
                      {   Customer customer = new Customer(name, email, customerType, bankAccount,
                              paymentMethod, PayingSupplements);
                          CustomerList.add(customer);
                      }
                    //try-catch block inside nested try block
                 }
                 catch(Exception e2) 
                 {
                    //Exception Message
                         System.out.println("Invalid email: " + email);
                 }
        }
                //Catch of Main(parent) try block
        catch(Exception e3) {
              //Exception Message
            System.out.println("Invalid customer name: " + name);
        }
                
    } //End of AddCustomer method
    
    /**
     * Method to add new Associate customer
     * @param name Name of Associate customer
     * @param email email id
     * @param customerType Customer Type (A)
     * @param payerName Paying customer's name of this Associate Customer
     * @param AssocSuppList List of supplements subscribed to
     */
    public static void AddNewAssociateCustomer(String name, String email, char customerType, String payerName, 
                                                ArrayList<String> AssocSuppList)                                                     
    {
        boolean flag = false;        

        for(int i=0; i<CustomerList.size(); i++)
        {
            if(CustomerList.get(i).getName().equals(payerName))
            {
                CustomerList.get(i).AddAssociateCustomer(name, email, customerType, AssocSuppList);
                System.out.println("\nNew Associate customer " + name +" added to Paying customer " 
                                    + CustomerList.get(i).getName()+ "\n");
                flag = true;
            }
        }

        //If the name entered does not match any Paying customer
        if(flag == false)
        {
            System.out.println("\nPaying customer " + payerName + " not found!\n");
        }

    }
    
    /**
     * Overloaded method that removes a Paying customer
     * @param name Name of paying customer to be removed
     */
    public static void RemoveCustomer(String name) 
    {
        boolean flag = false;
        
        for(int i=0; i<CustomerList.size(); i++)
        {
            if(CustomerList.get(i).getName().equals(name))
            {
                CustomerList.remove(i);
                flag = true;
            }
        }
        if(flag == true)
            System.out.println(name + " has been removed!\n");
        else
            System.out.println("No customer named " + name + " exists!\n");
    }
    
    /**
     * Overloaded method that removes Associate Customer
     * @param assocName Name of Associate customer being removed
     * @param payerName Name of Paying customer for this Associate customer
     */
    public static void RemoveCustomer(String assocName, String payerName)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        
        for(int i=0; i<CustomerList.size(); i++)
        {
            if(CustomerList.get(i).getName().equals(payerName))
            {
                flag1 = true;
                if(flag1 == true)
                {
                    for(int j=0; j<CustomerList.get(i).getAssocCustomer().size(); j++)
                    {
                        if(CustomerList.get(i).getAssocCustomer(j).getName().equals(assocName))
                        {
                            CustomerList.get(i).getAssocCustomer().remove(j);
                            flag2 = true;
                        }
                    }
                }
                
            }
            
        }
        if(flag1  == false)
        {
            System.out.println("Paying Customer " + payerName + " does not exist!\n");
        }
        else 
            if(flag2 == false)
            {
                System.out.println(payerName + " does not have any associate customer called " + assocName + "!\n" );                
            }
            else
                System.out.println("Associate customer " + assocName + " was removed!\n");
    }
    
    
    /**
     * Specifying the Paying customers that need to be removed
     */
    public static void RemovePayingCustomer()
    {
        RemoveCustomer("Julian Corman");
        RemoveCustomer("Bob");
    }
    
    /**
     * Specifying the Associate customers that need to be removed
     */
    public static void RemoveAssociateCustomer()
    {
        RemoveCustomer("Alex", "James Brendon"); //Payer does not exist
        
        RemoveCustomer("John", "Tom Sawyer"); //Associate does not exist
        
        RemoveCustomer("Alex", "Tom Sawyer"); //Alex will be removed
    }
    
    /**
     * Method to add new supplements to paying customer's magazine subscription
     */
    public static void addSupplements()
    {
        for(int i=0; i<CustomerList.size(); i++)
        {
            //Adding a new supplement to paying customer James Richard
            if(CustomerList.get(i).getName().equals("James Richard"))
                CustomerList.get(i).addSupplement("Research"); 
            
            if(CustomerList.get(i).getName().equals("Tom Sawyer"))
            {
                for(int j=0; j<CustomerList.get(i).getAssocCustomer().size(); j++)
                {
                    //Adding a new supplement to Tom Sawyer's associate customer Peter
                    if(CustomerList.get(i).getAssocCustomer(j).getName().equals("Peter"))
                        CustomerList.get(i).getAssocCustomer(j).addSupplement("Trade");                            
                }
            }
        }      
    }
    
    public static void removeSupplements()
    {
        for(int i=0; i<CustomerList.size(); i++)
        {
            if(CustomerList.get(i).getName().equals("Tom Sawyer"))
            {
                CustomerList.get(i).removeSupplement("Beauty");
            }
        }
    }
    
    /**
     * Adding Supplements for 1st Paying Customer 
     * @param pc1Supp
     * @return ArrayList of supplements
     */
    private static ArrayList<String> AddPayingCustomer1Supp(ArrayList<String> pc1Supp)
    {
        pc1Supp.add("Tech");
        pc1Supp.add("Health");
        pc1Supp.add("Beauty");        
        return pc1Supp;
    }
    
    /**
     * Adding Supplements for 2nd Paying Customer 
     * @param pc2Supp
     * @return ArrayList of supplements
     */
    private static ArrayList<String> AddPayingCustomer2Supp(ArrayList<String> pc2Supp)
    {
        pc2Supp.add("Tech");      
        return pc2Supp;
    }
    
    /**
    * Adding Supplements for 3rd Paying Customer 
    * @param pc3Supp
    * @return ArrayList of supplements
    */
    private static ArrayList<String> AddPayingCustomer3Supp(ArrayList<String> pc3Supp)
    {
        pc3Supp.add("Research");     
        return pc3Supp;
    }
    
        /**
     * Validates whether the email is of an appropriate format
     * @param input Email input for validation
     * @return flag Boolean result
     * https://www.youtube.com/watch?v=OOdO785p3Qo
     */  
    public static boolean validateEmail(String input)
    {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPattern.matcher(input);
        
        if(matcher.find() == true)
            return true; //if valid email
        
                   
        return false; //if invalid email
    }
    
    /**
    * Makes use of the Dates class
    * @return The number of weeks in a month
    */
    public static int getWeeks()
    {
        Dates calendar = new Dates();
        
        //Making final monthly bill
       int d = LocalDate.now().getDayOfMonth();
       int m = LocalDate.now().getMonthValue();
       int y = LocalDate.now().getYear();
       int numOfWeeks;

       //To get number of weeks in the current month
       numOfWeeks = calendar.Week_Of_Month(d, m, y);

       return numOfWeeks;
    }
    
    /**
    * Method to display student details
    */
    public static void displayStudentDetails()
    {
        System.out.println("********************************************");
        System.out.println("Name: Faiz Syed");
        System.out.println("Student number: 33243485");
        System.out.println("Mode of enrolment: internal");
        System.out.println("Tutor: Mr Ferdous Sohel");
        System.out.println("Tutorial day and time: Thursday, 10:30 am");
        System.out.println("********************************************\n");
    }
    
    
} /* End of Class Magazine*/


