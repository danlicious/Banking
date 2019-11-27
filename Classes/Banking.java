package banking;

public class Banking {

    /* NOTES
    
    Console outputs beginning with "(DEVELOPMENT") won't (or don't need to) be in the final build.
    
    [x] 1. Add a new Client 
    [x] 2. Create a new Account 
    [ ] 3. Make a Deposit             
    [ ] 4. Make a Withdrawal       
    [ ] 5. List Account Transactions  
    [x] 6. List Clients
    [x] 7. List Client Accounts
    
    Dan: So, this is how this thing works. 
    
        1. Checks userInput 
        2. Depending on option, Banking calls appropriate method in Bank.
        3. The methods in bank do what they have to do.
        
        Inside of the UIM, please use the scanInput(String desiredType) method. It allows for cleaner code execution.
        If that is too intimidating, just do whatever works for now... then we'll see.
    
    */
    

    public static void main(String[] args) {
        
        System.out.println("\n     { Welcome to BBM \"Big Brains, Big Money\" }");
        
        Bank bank = new Bank();    
        int userOption = UserInputManager.retrieveUserOption();
        boolean doLoop = true;
        
        while (doLoop) {
            
            switch (userOption) {
                case 1: //Daniel
                    bank.createClient();
                    break;
                    
                case 2: //Daniel
                    bank.createAccount();  
                    break;
                    
                case 3:
                    System.out.println("You selected: Make a Deposit\n");
                    
                    //needs to get clientId from console
                    System.out.println(UserInputManager.retrieveClientId());
                    //needs to get AccountNumber from console, must belong to client
                    
                    //gets amount of transaction from console
                    
                    //creates the transaction
                    
                    //adds the transaction to list of transactions
                    
                    //updates the account's balance
                    
                    //output in this form: accountType(accountNumber): balance$
                    
                  
                    break;
                case 4:
                    System.out.println("You selected: Make a Withdrawal\n");
                    //get clientId from console
                    System.out.println(UserInputManager.retrieveClientId());
                    //get accountNumber from console, must belong to selected client
                    
                    //retrieve amount of transaction from console
                    
                    //create the transaction
                    
                    //add transaction to the account's list of transactions
                    
                    //update account balance
                    
                    //output in this form: accountType(accountNum): balance
                    
                    break;
                case 5:
                    System.out.println("You selected: List Account Transactions\n");
                    //output transactions in this form: -transactionType of transactionAmount
                    
                    // and this form: accountType(accountNum): balance
                           
                    break;
                case 6: //Daniel
                    bank.displayClientList();  
                    break;
                    
                case 7: //Daniel
                    bank.listClientAccounts();
                    break;
            }
            userOption = UserInputManager.retrieveUserOption();
        }

    }
}
