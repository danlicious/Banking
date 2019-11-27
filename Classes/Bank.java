package banking;
import java.util.ArrayList;
public class Bank implements IBank{
    
    //Daniel - I put conditions to protect 0the bank properties
    private static final String bankNumber = "123456789"; 
    private static final String address = "821 Sainte Croix Ave";
    private static ArrayList<Client> clientList = new ArrayList<>();
    private static final UserInputManager uim = new UserInputManager();
    
    
    public boolean createClient(){
        
        System.out.println("Creating a new Client...");
        Client newClient = uim.retrieveClientInfo();
        addClient(newClient);
        return true;
        
    }
    
    public boolean createAccount(){

        if(getClientList().size() > 0){
                        System.out.println("(DEVELOPMENT) Creating a new Account...");
                        Client client = getClient(uim.retrieveClientId());
                        System.out.println("(DEVELOPMENT) Client: " + client.toString());
                        Account account = uim.retrieveAccountType(client);
                        client.addAccount(account);
                     
                    }else{
                        System.err.println("Sorry! We don't have any clients yet.\n"); 
                    }
        return true;        
    }
    
    public boolean listClientAccounts(){ //Daniel
        
        Client client = getClient(uim.retrieveClientId());
        client.displayAccounts();
        
        return true;
    }
  
    @Override //Farhan
    public void addClient(Client newClient) {
        
        clientList.add(newClient.getId()-1,newClient);
        System.out.println("\n(DEVELOPMENT) Added client " + clientList.toString());
        
    }
    
    @Override
    public void displayClientAccounts(int clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //Daniel
    public void displayClientList() {
        
        System.out.println("\nList of current clients:");
        for(int i=0; i < clientList.size(); i++){
            System.out.println(clientList.get(i).toString());
        }
        
    }

    @Override//Daniel
    public Client getClient(int id) {
        return clientList.get(id-1);
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
    
    public static void setClientList(ArrayList<Client> clientList) {
        Bank.clientList = clientList;
    }
    
    
    
}