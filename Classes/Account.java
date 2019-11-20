package banking;

import java.util.ArrayList;

/**
 *
 * @author cstuser
 */
public class Account{
    
  private int accountNumber;
    protected int counter = 10000;
    protected double balance;
    protected ArrayList<Transaction> transactions;
    protected Client owner;
    String type;
  
    


    public Account(int accountNumber, double balance, ArrayList<Transaction> transactions, Client owner, String type) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = transactions;
        this.owner = owner;
        this.type = type;
        
    }
    
    
    public Account() {
        this.accountNumber = counter++;
        this.transactions = new ArrayList<>();
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
    
    
    double deposit(double d){
        /**
     * Update the account balance with the amount of the deposit
     * Create the corresponding Transaction element and add it to the transactions list
     * 
     * return the new balance
     */
        
    }
    public void displayAllTransactions(){
         /**
     * Print every Transaction listed in the transactions list
     * 
     */
         for (Transaction transactions : transactions) {
             System.out.println(transactions);
        }
    }
        public ArrayList<Transaction> getTransactions(){
            /**
     * Update the account balance with the amount of the withdrawl
     * Create the corresponding Transaction element and add it to the transactions list
     * 
     * return the new balance
     */
    }
        
   @Override
    public String toString(){
         /**
     * return the string that you want to output when printing the object
     */
      
      
    }
    public double withdrawal(double w){
          /**
     * Update the account balance with the amount of the withdrawal
     * Create the corresponding Transaction element and add it to the transactions list
     * 
     * return the new balance
     */
    
    }
}
