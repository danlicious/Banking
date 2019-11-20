package banking;
import java.util.ArrayList;
public class Bank implements IBank{
    
    //Daniel - I put conditions to protect the bank properties
    private static final String bankNumber = "123456789"; 
    private static final String address = "821 Sainte Croix Ave";
    private static ArrayList<Client> clientList = new ArrayList<>();
    
    @Override
    public void addClient(Client newClient) {
        System.out.println("Creating a new client!");
        System.out.println("Plea");
    }

    @Override
    public void displayClientAccounts(int clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayClientList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client getClient(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getClientAccount(int clientId, int accountNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String getBankNumber() {
        return bankNumber;
    }

    public static String getAddress() {
        return address;
    }

    public static ArrayList<Client> getClientList() {
        return clientList;
    }
    
    //Daniel - I am not sure about this yet.
    public static void setClientList(ArrayList<Client> clientList) {
        Bank.clientList = clientList;
    }
    
    
    
}