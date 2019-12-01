package banking;

import java.util.ArrayList;

public class Bank implements IBank {

    //Daniel - I put conditions to protect 0the bank properties
    private static final String bankNumber = "123456789";
    private static final String address = "821 Sainte Croix Ave";
    private static ArrayList<Client> clientList = new ArrayList<>();
    

    public boolean createClient() {

        System.out.println("(DEVELOPMENT) Creating a new Client...");
        Client newClient = UserInputManager.retrieveClientInfo();
        addClient(newClient);
        return true;

    }

    public boolean createAccount() {

        if (getClientList().size() > 0) {
            System.out.println("(DEVELOPMENT) Creating a new Account...");
            Client client = getClient(UserInputManager.retrieveClientId());
            System.out.println("(DEVELOPMENT) Client: " + client.toString());
            Account account = UserInputManager.retrieveAccountType(client);
            client.addAccount(account);

        } else {
            System.err.println("Sorry! We don't have any clients yet.\n");
        }
        return true;
    }

    public boolean createTransaction(String type) { //Daniel

        if (getClientList().size() > 0) {
            Client client = getClient(UserInputManager.retrieveClientId());
            if (client.getAccountList().size() > 0) {
                            
                        client.displayAccounts();                      
                        int accNum = UserInputManager.retrieveAccountNumber();
                        Account acc = client.getAccount(accNum);
                        
                        if(acc == null){
                            createTransaction(type);
                        }else{
                            double accBalance = acc.getBalance();
                            System.out.println("Your balance is " + Math.round(accBalance*100)/100.0 + "$\n");
                            double amount = UserInputManager.retrieveTransactionAmount();
                            Transaction t = new Transaction(type, amount);
                            System.out.println("Transaction: " + t + "\n");
                            switch (type) {                                                         
                                case "deposit":                                      
                                        
                                    acc.setBalance(acc.getBalance() + amount);
                                    
                                    break;

                                case "withdrawal":

                                    acc.setBalance(acc.getBalance() - amount);

                                    break;

                            }
                            
                            acc.getTransactions().add(t);
                            System.out.println("Your new balance for this account is: \n" + acc);
                            
                        }
                                                                        
            } else {
                System.err.println("Sorry! " + client + " does not have an account yet.\n");
            }
        } else {
            System.err.println("Sorry! We don't have any clients yet.\n");
        }
        return false;
    }

    public boolean listAccountTransactions() {//Daniel  //Marius

        if (getClientList().size() > 0) {
            Client client = getClient(UserInputManager.retrieveClientId());
            if (client.getAccountList().size() > 0) {
                System.out.println("(DEVELOPMENT) Account ID needed for listing.");
                        client.displayAccounts();                      
                        int accNum = UserInputManager.retrieveAccountNumber();
                        Account acc = client.getAccount(accNum);
                        
                        if(acc == null){
                            listAccountTransactions();
                        }else{                        
                        System.out.println("\nDisplaying transaction history of account: [" + acc + "]\n" + acc.getTransactions());                       
                        }
                
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
         if (getClientList().size() > 0) {
            Client client = getClient(clientId);
            client.displayAccounts();
        } else {
            System.err.println("Sorry! We don't have any clients yet.\n");
        }
    
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
        Client c = this.getClient(clientId);
        if(c != null){
            return c.getAccount(accountNumber);
        }
        return null;
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
