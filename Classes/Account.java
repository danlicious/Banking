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

       return balance;
    }
    public void displayAllTransactions(){

         for (Transaction transactions : transactions) {
             System.out.println(transactions);
        }
    }
      public ArrayList<Transaction> getTransactions(){
  
            return transactions;
    }
        
   @Override
    public String toString(){

      return "Ayylmao";
    }
    public double withdrawal(double w){

          return w;
    }
}
