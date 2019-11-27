package banking;

import java.util.ArrayList;

public class Bank implements IBank {

    //Daniel - I put conditions to protect 0the bank properties
    private static final String bankNumber = "123456789";
    private static final String address = "821 Sainte Croix Ave";
    private static ArrayList<Client> clientList = new ArrayList<>();
    private static final UserInputManager uim = new UserInputManager();

    public boolean createClient() {

        System.out.println("(DEVELOPMENT) Creating a new Client...");
        Client newClient = uim.retrieveClientInfo();
        addClient(newClient);
        return true;

    }

    public boolean createAccount() {

        if (getClientList().size() > 0) {
            System.out.println("(DEVELOPMENT) Creating a new Account...");
            Client client = getClient(uim.retrieveClientId());
            System.out.println("(DEVELOPMENT) Client: " + client.toString());
            Account account = uim.retrieveAccountType(client);
            client.addAccount(account);

        } else {
            System.err.println("Sorry! We don't have any clients yet.\n");
        }
        return true;
    }

    public boolean listClientAccounts() { //Daniel

        if (getClientList().size() > 0) {
            Client client = getClient(uim.retrieveClientId());
            client.displayAccounts();
        } else {
            System.err.println("Sorry! We don't have any clients yet.\n");
        }

        return true;
    }

    public boolean createTransaction(String type) { //Daniel

        if (getClientList().size() > 0) {
            Client client = getClient(uim.retrieveClientId());
            if (client.getAccountList().size() > 0) {
                switch (type) {
                    case "deposit":
                        System.out.println("(DEVELOPMENT) Making a deposit...");

                        
                        //needs to get AccountNumber from console, must belong to client
                        //gets amount of transaction from console
                        //creates the transaction
                        //adds the transaction to list of transactions
                        //updates the account's balance
                        //output in this form: accountType(accountNumber): balance$
                        
                        
                        break;
                    case "withdrawal":
                        System.out.println("(DEVELOPMENT) Making a withdrawal...");
                        
                        
                        //get accountNumber from console, must belong to selected client
                        //retrieve amount of transaction from console
                        //create the transaction
                        //add transaction to the account's list of transactions
                        //update account balance
                        //output in this form: accountType(accountNum): balance
                        
                        
                        break;
                }
            } else {
                System.err.println("Sorry! " + client + " does not have an account yet.\n");
            }
        } else {
            System.err.println("Sorry! We don't have any clients yet.\n");
        }
        return true;
    }

    public boolean listAccountTransactions() {//Daniel

        if (getClientList().size() > 0) {
            Client client = getClient(uim.retrieveClientId());
            if (client.getAccountList().size() > 0) {
                System.out.println("(DEVELOPMENT) Listing accounts...");

                
                //output transactions in this form: -transactionType of transactionAmount
                // and this form: accountType(accountNum): balance
                
                
            } else {
                System.err.println("Sorry! " + client + " does not have an account yet.\n");
            }
        } else {
            System.err.println("Sorry! We don't have any clients yet.\n");
        }
        return true;

    }

    @Override //Farhan
    public void addClient(Client newClient) {

        clientList.add(newClient.getId() - 1, newClient);
        System.out.println("\n(DEVELOPMENT) Added client " + clientList.toString());

    }

    @Override
    public void displayClientAccounts(int clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //Daniel
    public void displayClientList() {

        System.out.println("\nList of current clients:");
        for (int i = 0; i < clientList.size(); i++) {
            System.out.println(clientList.get(i).toString());
        }

    }

    @Override//Daniel
    public Client getClient(int id) {
        return clientList.get(id - 1);
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
