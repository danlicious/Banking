package banking;

public class Banking {

    public static void main(String[] args) {
        UserInputManager uim = new UserInputManager();
        Bank bank = new Bank();
        System.out.println("\n\n      Welcome to our bank \"Big Brains, Big Money\"");
        int userOption = uim.retrieveUserOption();
        boolean doLoop = true;
        while (doLoop) {
            switch (userOption) {

                case 1:
                    System.out.println("[Bank] You selected: Add a new Client\n");
                    bank.addClient(uim.retrieveClientInfo());
                    //needs to make an AccountList for each client
                    break;
                case 2:
                    System.out.println("[Bank] You selected: Create a new Account\n");
                    System.out.println(uim.retrieveClientId());
                    System.out.println(uim.retrieveAccountType());
                     //needs to add Account to the client's AccountList
                    break;
                case 3:
                    System.out.println("[Bank] You selected: Make a Deposit\n");
                    //needs to get clientId from console
                    System.out.println(uim.retrieveClientId());
                    //needs to get AccountNumber from console, must belong to client
                    
                    //gets amount of transaction from console
                    
                    //creates the transaction
                    
                    //adds the transaction to list of transactions
                    
                    //updates the account's balance
                    
                    //output in this form: accountType(accountNumber): balance$
                    
                  
                    break;
                case 4:
                    System.out.println("[Bank] You selected: Make a Withdrawal\n");
                    //get clientId from console
                    System.out.println(uim.retrieveClientId());
                    //get accountNumber from console, must belong to selected client
                    
                    //retrieve amount of transaction from console
                    
                    //create the transaction
                    
                    //add transaction to the account's list of transactions
                    
                    //update account balance
                    
                    //output in this form: accountType(accountNum): balance
                    
                    break;
                case 5:
                    System.out.println("[Bank] You selected: List Account Transactions\n");
                    //output transactions in this form: -transactionType of transactionAmount
                    
                    // and this form: accountType(accountNum): balance
                           
                    break;
                case 6:
                    System.out.println("[Bank] You selected: List Clients\n");
                    //get and display all clients from bank's clientList in this form:
                    // "list of current clients" \n (clientId)lastName, firstName
                    
                    
                    //output break;
                    
                case 7:
                    System.out.println("[Bank] You selected: List Client Accounts\n");
                    //get clientId from console
                    System.out.println(uim.retrieveClientId());
                    //get selected client from bank's clientList
                    
                    //display all accounts from selected client in this form: 
                    /*
                        "Accounts for " lastName,firstName(clientId):
                    a.	Regular text followed by Last Name, First Name and client id
                          Savings(2): 1210.60$
                          Savings(3): 85.15$
                          Checking(7): -73.70$
                    b.	Account type, account number, balance

                    */
                    
                    
                    break;
            }
            userOption = uim.retrieveUserOption();
        }

    }
}
