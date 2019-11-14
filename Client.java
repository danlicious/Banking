/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

/**
 *
 * @author cstuser
 */
public class Client implements IClientextends Bank{
    int clientId;
    String firstName;
    String lastName;
    String[] accountList;
    int counter;

    public Client(int clientId, String firstName, String lastName, String[] accountList) {
        this.clientId = clientId;
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

    public String[] getAccountList() {
        return accountList;
    }

    public void setAccountList(String[] accountList) {
        this.accountList = accountList;
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
