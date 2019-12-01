package banking;

import java.util.ArrayList;

public class Account {

    protected static int counter = 1;
    private int accountNumber;
    protected Client owner;
    protected String type;
    protected double balance;
    protected ArrayList<Transaction> transactions;

    public Account(Client owner, String type) {
        this.transactions = new ArrayList<>();
        this.accountNumber = counter;
        this.owner = owner;
        this.type = type;
        this.balance = 0;
        counter++;
    }

    public double deposit(double d) {

        Transaction transaction = new Transaction();
        transaction.setType("deposit");
        transaction.setAmount(d);
        transactions.add(transaction);
        this.balance = this.balance + d;
        return this.balance;
        
    }

    public void displayAllTransactions() {

        transactions.forEach((i) -> {
            System.out.println(i);
        });
    }

    @Override
    public String toString() { //Daniel

        String accountInfo = type + "(" + accountNumber + "): " + balance + "$";
        return accountInfo;

    }

    public double withdrawal(double w) {

        Transaction transaction = new Transaction();              
        transaction.setType("withdrawal");
        transaction.setAmount(w);
        this.transactions.add(transaction);
        this.balance = this.balance - w;
        return this.balance;

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

    public ArrayList<Transaction> getTransactions() {
        return null;

    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

}
