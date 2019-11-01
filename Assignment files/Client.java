
package banking;


public class Client implements IClient {
    
    int id;
    String firstName;
    String lastName;
    String[] accountList;
    String[] clientName;
    int counter;

    
    
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

    public String[] getAccountList() {
        return accountList;
    }

    public void setAccountList(String[] accountList) {
        this.accountList = accountList;
    }

    public String[] getClientName() {
        return clientName;
    }

    public void setClientName(String[] clientName) {
        this.clientName = clientName;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    public void createClient(String input){
       
    }

    @Override
    public void addAccount(Account newAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayAccounts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getAccount(int accountNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
