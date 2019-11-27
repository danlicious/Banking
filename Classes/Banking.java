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
        
        Inside of the UIM, please use the "scanInput(String desiredType)" method. It allows for cleaner code execution.
        If that is too intimidating, just do whatever works for now... then we'll see.
        
        I moved the bulk of the code into Bank because in the instructions Bankign is supposed to only process user requests. 
        The, from the bank other functions are called inside of UIM, account, client and transactions.
    
        Can you guys create a "scanInput(String money)" that checks if the input is: 
            1. A number
            2. Can be converted into a money transaction
                if not, can it be changed by the code so that it could be converted into double i.e. 10.1445525 becomes 10.14 or something
                remember, the scanInput always returns a STRING, it only CHECKS if the user put in a correct value.
                
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
                    bank.createTransaction("deposit");                   
                    break;
                    
                case 4:
                    bank.createTransaction("withdrawal");  
                    break;
                    
                case 5:
                    bank.listAccountTransactions();         
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
