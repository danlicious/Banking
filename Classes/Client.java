package banking;
import java.util.ArrayList;

public class Client implements IClient {  //Marius
    
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accountList;
    private static int counter = 1;

 
    public Client(String firstName, String lastName) {  //Marius
        this.accountList = new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = counter;
        counter++;
    }
    
    public int getId() {  //Marius
        return this.id;
    }

    public void setId(int id) {  //Marius
        this.id = id;
    }

    public String getFirstName() {  //Marius
        return this.firstName;
    }

    public void setFirstName(String firstName) {  //Marius
        this.firstName = firstName;
    }

    public String getLastName() {  //Marius
        return this.lastName;
    }

    public void setLastName(String lastName) {  //Marius
        this.lastName = lastName;
    }

    public ArrayList<Account> getAccountList() {  //Marius
        return this.accountList;
    }

    public int getCounter() {  //Marius
        return this.counter;
    }

    public void setCounter(int counter) {  //Marius
        this.counter = counter;
    }
    

    @Override//Daniel
    public void addAccount(Account newAccount) {
        newAccount.setOwner(this);
        this.accountList.add(newAccount);
        System.out.println("\n(DEVELOPMENT) New account [" + newAccount.toString() + "]added for [" + this.toString() + "] ");
    }

    @Override//Daniel
    public void displayAccounts() {
        
        System.out.println("\nAccounts for " + this.toString() + ":\n");
        this.accountList.forEach((i) -> {
            System.out.println(i);
        });
        
    }

    @Override//Daniel
    public Account getAccount(int accountNumber) {
        for (int i = 0; i < this.accountList.size(); i++) {
            if(accountNumber == this.accountList.get(i).getAccountNumber()){
                return this.accountList.get(i);
            }
        }
        return null;
    }
    
    @Override //Marius
    public String toString(){
        
        String clientObj = "(" + this.id + ") " + this.lastName + ", " + this.firstName ;

        return clientObj;
    }
}
