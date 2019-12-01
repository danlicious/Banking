package banking;

import java.util.ArrayList;

public class Bank implements IBank {


    private static final String bankNumber = "123456789";
    private static final String address = "821 Sainte Croix Ave";
    private static ArrayList<Client> clientList = new ArrayList<>();
    private static final UserInputManager uim = new UserInputManager();

    @Override //Farhan
    public void addClient(Client newClient) {

        clientList.add(newClient.getId() - 1, newClient);

    }

    @Override
    public void displayClientAccounts(int clientId) {
        
          Client client = getClient(clientId);
          client.displayAccounts();
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
