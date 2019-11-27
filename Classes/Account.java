package banking;

import java.util.ArrayList;


public class Account{  //Marius
    
    protected static int counter = 1;   
    private int accountNumber;
    protected Client owner;
    protected String type; 
    protected double balance;
    protected ArrayList<Transaction> transactions;
    
  
    public Account(Client owner, String type) {  //Marius
        this.accountNumber = counter;
        this.owner = owner;
        this.type = type;
        this.balance = 0;
        counter++;
    }
    
    
    public int getAccountNumber() {  //Marius
        return accountNumber;
    }
    
    public void setAccountNumber(int accountNumber) {  //Marius
        this.accountNumber = accountNumber;
    }

    public int getCounter() {  //Marius
        return counter;
    }

    public void setCounter(int counter) {  //Marius
        this.counter = counter;
    }

    public double getBalance() {  //Marius
        return balance;
    }

    public void setBalance(double balance) {  //Marius
        this.balance = balance;
    }

    public Client getOwner() {  //Marius
        return owner;
    }

    public void setOwner(Client owner) {  //Marius
        this.owner = owner;
    }

    public String getType() {  //Marius
        return type;
    }

    public void setType(String type) {  //Marius
        this.type = type;
    }
    
    
    double deposit(double d){  //Marius
    
        this.balance = this.balance+d;
      
        // Create the corresponding Transaction element and add it to the transactions list
        
        return this.balance;
           
    }
    public void displayAllTransactions(){  //Marius
      
      transactions.forEach((i) -> {
          System.out.println(i);
      });
    }
    public ArrayList<Transaction> getTransactions(){  //Marius
      return null;
                     
    }
        
   @Override
    public String toString(){  //Marius
      
      String accountInfo = type + "(" + accountNumber + "): " + balance + "$";  
      return accountInfo;
         
    }
     
    public double withdrawal(double w){  //Marius
          
       this.balance = this.balance - w;
       
     
     // Create the corresponding Transaction element and add it to the transactions list
      
     return this.balance;
     
    
    }
}

