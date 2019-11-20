package banking;

import java.util.ArrayList;


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
    
        this.balance = this.balance+d;
      
        
        // Create the corresponding Transaction element and add it to the transactions list
        
        return this.balance;
        
       
  
     
    
        
    }
    public void displayAllTransactions(){
      
      transactions.forEach((i) -> {
          System.out.println(i);
      });
    }
    public ArrayList<Transaction> getTransactions(){
      return null;
                     
    }
        
   @Override
    public String toString(){
      return null;
         /**
     * return the string that you want to output when printing the object
     */
      
      
    }
    public double withdrawal(double w){
          
       this.balance = this.balance - w;
       
     
     // Create the corresponding Transaction element and add it to the transactions list
      
     return this.balance;
     
    
    }
}

