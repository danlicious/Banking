package banking;

import java.util.ArrayList;

public class Client implements IClient {

    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accountList;
    private static int counter = 1;

    public Client() {
        this.accountList = new ArrayList<>();
        this.id = counter;
        counter++;
    }

    @Override//Daniel
    public void addAccount(Account newAccount) {

        this.accountList.add(newAccount);
    }

    @Override//Daniel
    public void displayAccounts() {

        System.out.println("\nAccounts for " + this.lastName + ", " + this.firstName + " (" + this.id + "):");
        accountList.forEach((i) -> {
            System.out.println(i);
        });

    }

    @Override//Daniel
    public Account getAccount(int accountNumber) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountNumber == accountList.get(i).getAccountNumber()) {
                return accountList.get(i);
            }
        }
        return null;
    }

    @Override //Marius
    public String toString() {

        String clientObj = "(" + id + ") " + lastName + ", " + firstName;

        return clientObj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        Client.counter = counter;
    }

}
