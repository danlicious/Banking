package banking;
import java.util.ArrayList;

public class Client implements IClient {
    
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accountList;
    private static int counter = 0;

    public Client() {
        this.accountList = new ArrayList<>();
    } 

    public Client(String firstName, String lastName) {
        this.accountList = new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        counter++;
        this.id = counter;
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
    

    @Override
    public void addAccount(Account newAccount) {
        
        this.accountList.add(newAccount);
    }

    @Override
    public void displayAccounts() {
       
        accountList.forEach((i) -> {
            System.out.println(i);
        });
    }

    @Override
    public Account getAccount(int accountNumber) {
        for (int i = 0; i < accountList.size(); i++) {
            if(accountNumber == accountList.get(i).getAccountNumber()){
                return accountList.get(i);
            }
        }
        return null;
    }
    @Override
    public String toString(){
        
    String clientObj = lastName + ", " + firstName + "(" + id + ")";
    
    return clientObj;
    }
}
