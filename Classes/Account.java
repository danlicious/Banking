package banking;

import java.util.ArrayList;


public class Account{  //Marius
    
    private static int counter = 0;   
    private int accountNumber;
    protected Client owner;
    private String type; 
    protected double balance;
    protected ArrayList<Transaction> transactions;

    public Account() {
    }
    
    public Account(String type) {  //Marius
        transactions = new ArrayList<>();
        this.accountNumber = counter+1;
        this.owner = null;
        this.type = type;
        this.balance = 0;
        counter++;
    }
    
    
    public int getAccountNumber() {  //Marius
        return this.accountNumber;
    }
    
    public void setAccountNumber(int accountNumber) {  //Marius
        this.accountNumber = accountNumber;
    }

    public static int getCounter() {  //Marius
        return Account.counter;
    }

    public void setCounter(int counter) {  //Marius
        this.counter = counter;
    }

    public double getBalance() {  //Marius
      
        return this.balance;
    }

    public void setBalance(double balance) {  //Marius
        this.balance = balance;
    }

    public Client getOwner() {  //Marius
        return this.owner;
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
        Transaction tr = new Transaction("Deposit", d);
        this.transactions.add(tr);
        
        return balance;
           
    }
    public void displayAllTransactions(){  //Marius
      
        for (Transaction transaction : this.transactions) {
            System.out.println(transaction);
        }
    }
      //Marius

    public ArrayList<Transaction> getTransactions() { //Marius
        return this.transactions;
    }                                          
    
        
   @Override
    public String toString(){ //Marius
      
     
      String accountInfo = this.type + "(" + this.accountNumber + "): " + Math.round(this.balance*100)/100.0 + "$";  //Math.round function to round at 2 decimals after point
      return accountInfo;
         
    }
    
    public double withdrawal(double w){  //Marius
          
       this.balance = this.balance - w;
       Transaction tr = new Transaction ("Withdrawal", w);
       this.transactions.add(tr);
     
       return balance;
     
    
    }
}

