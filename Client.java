
package banking;


public class Client implements IClient {
    
    int id;
    String firstName;
    String lastName;
    ArrayList<String> accountList = new ArrayList<>();
    int counter;

    public Client() {
        
    }

    public Client (int id, String firstName, String lastName, ArrayList<String> accountList){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountList = accountList;
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

    public ArrayList<String> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<String> accountList) {
        this.accountList = accountList;
    }


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    

    @Override
    public void addAccount(Account newAccount) {
        
        for (String i : accountList) {
  System.out.println(i);
    
    }

    @Override
    public void displayAccounts() {
       
    }

    @Override
    public Account getAccount(int accountNumber) {
     
    }
}
