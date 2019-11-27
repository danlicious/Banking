package banking;
import java.util.ArrayList;

public class Client implements IClient {  //Marius
    
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accountList;
    private static int counter = 1;

    public Client() {  //Marius
        this.accountList = new ArrayList<>();
    } 

    public Client(String firstName, String lastName) {  //Marius
        this.accountList = new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = counter;
        counter++;
    }
    
    public int getId() {  //Marius
        return id;
    }

    public void setId(int id) {  //Marius
        this.id = id;
    }

    public String getFirstName() {  //Marius
        return firstName;
    }

    public void setFirstName(String firstName) {  //Marius
        this.firstName = firstName;
    }

    public String getLastName() {  //Marius
        return lastName;
    }

    public void setLastName(String lastName) {  //Marius
        this.lastName = lastName;
    }

    public ArrayList<Account> getAccountList() {  //Marius
        return accountList;
    }

    public int getCounter() {  //Marius
        return counter;
    }

    public void setCounter(int counter) {  //Marius
        Client.counter = counter;
    }
    

    @Override//Daniel
    public void addAccount(Account newAccount) {
        
        this.accountList.add(newAccount);
        System.out.println("\n(DEVELOPMENT) New account [" + newAccount.toString() + "]added for [" + this.toString() + "] ");
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
            if(accountNumber == accountList.get(i).getAccountNumber()){
                return accountList.get(i);
            }
        }
        return null;
    }
    @Override //Marius
    public String toString(){
        
    String clientObj = "(" + id + ") " + lastName + ", " + firstName ;
    
    return clientObj;
    }
}
