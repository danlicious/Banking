package banking;

import java.util.ArrayList;


public class Account{
    
    protected static int counter = 1;   
    private int accountNumber;
    protected Client owner;
    protected String type; 
    protected double balance;
    protected ArrayList<Transaction> transactions;
    
  
    public Account(Client owner, String type) {
        this.accountNumber = counter;
        this.owner = owner;
        this.type = type;
        this.balance = 0;
        counter++;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    public String toString(){ //Daniel
      
      String accountInfo = type + "(" + accountNumber + "): " + balance + "$";  
      return accountInfo;
         
    }
    
    public double withdrawal(double w){
          
       this.balance = this.balance - w;
       
     
     // Create the corresponding Transaction element and add it to the transactions list
      
     return this.balance;
     
    
    }
}

