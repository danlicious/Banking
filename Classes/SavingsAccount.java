package banking;

import java.util.ArrayList;

/**
 *
 * @author cstuser
 */
public class SavingsAccount extends Account{
    
    public SavingsAccount(int accountNumber, double balance, ArrayList<Transaction> transactions, Client owner, String type) {
        super(accountNumber, balance, transactions, owner, type = "Savings");
    }

    public SavingsAccount() {
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

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
}
