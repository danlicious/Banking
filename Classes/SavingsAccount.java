package banking;

import java.util.ArrayList;

public class SavingsAccount extends Account{

    public SavingsAccount(Client owner, String type) {
        super(owner, type);
    }

    public int getCounter() {
        return counter;
    }

    public Client getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setCounter(int counter) {
        Account.counter = counter;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
   
}
