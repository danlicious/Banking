package banking;
import java.util.Scanner;
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
    private static boolean valid; //Is the input usable by the calling method?
    private static int inputLength;
    private static int counter; //used for counting
    private static String userInput;
    private static String validInput; //Final and (if needed) transformed input.
    private static String sample;   //used for substrings.
    
    private static Scanner scan = new Scanner(System.in);
    
    
     public static String scanInput(String desiredReturn) { //Daniel: When the console needs to retrieve information, this code will prevent unwanted inputs.
        do {//Until the appropriate conditions are met, scanned values will not be returned.
            userInput = scan.nextLine();
            inputLength = userInput.length();
            counter = 0;
            valid = false;

            switch (userInput) {

                //Daniel
                case "stop":
                    System.err.println("INPUT WAS 'stop' (STOPPING THE PROGRAM)");
                    System.exit(0);

                //Daniel    
                case "":
                    System.err.println("Nothing happened.\n");
                    break;

                default:
                    switch (desiredReturn) {

                        //Daniel
                        case "option":

                            try {     //Only allow integers 1 to 7. 
                                int i = Integer.parseInt(userInput);
                                if (i <= 7 && i >= 1) {
                                    valid = true;
                                    validInput = userInput;
                                } else {
                                    valid = false;
                                }
                            } catch (Exception e) {
                                valid = false;
                            }
                            if (valid == false) {
                                System.err.println("Your input must correspond to one of the options [1,7]");
                            }
                            break;

                        //Daniel    
                        case "name":
                            String possibleComponents[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "-", " "};
                            //Every letter must correspond to one in the array
                            do {
                                sample = userInput.substring(counter, counter + 1);
                                valid = false;
                                for (String pc : possibleComponents) {
                                    if (sample.equals(pc)) {
                                        valid = true;
                                    }
                                }
                                if (valid == false) {
                                    counter = inputLength;
                                }
                                counter++;
                            } while (counter < inputLength);
                            if (valid == true) {  //If each component has a match, capitalize and return.

                                validInput = autoCapitalize(userInput);
                            } else {
                                System.err.println("Your name is not valid. Please use a-Z.\n");
                            }
                            break;

                        //Daniel
                        case "clientId":

                            try {     //Only allow integers of existing ids.      
                                int i = Integer.parseInt(userInput);
                                if (i <= Bank.getClientList().size() && i >= 1) {
                                    valid = true;
                                    validInput = userInput;
                                } else {
                                    valid = false;
                                }
                            } catch (Exception e) {
                                valid = false;
                            }
                            if (valid == false) {
                                System.err.println("It appears that client [" + userInput + "] does not exist. Are they perhaps a ghost? Please try again.");
                            }
                            break;

                        //Daniel   
                        case "accountType":

                            try {
                                int i = Integer.parseInt(userInput);
                                if (i <= 2 && i >= 1) {
                                    valid = true;
                                    validInput = userInput;
                                } else {
                                    valid = false;
                                }
                            } catch (Exception e) {
                                valid = false;
                            }
                            if (valid == false) {
                                System.err.println("[" + userInput + "] is not an option. Please select [1] or [2].");
                            }
                            break;

                        case "money":

                            System.out.println("HMMMMMMMM WE LOVE MONEYYYYYYYYYYYYYYYYYYYY");

                            break;

                    }
                    break;
            }
        } while (valid == false);
        return validInput;
    }
     public static String autoCapitalize(String initialString) {
        //This code does two things: 1. Removes uneeded spaces and hypens 2. Capitalizes names (even ones made of two parts)
        initialString = " " + initialString + " ";
        String transformedString = "";
        counter = 0;
        while (counter <= initialString.length() - 1) {
            sample = initialString.substring(counter, counter + 1);
            if (sample.equals(" ") || sample.equals("-")) {
                transformedString = transformedString + sample;
                while (sample.equals(" ") || sample.equals("-")) {
                    try {
                        sample = initialString.substring(counter, counter + 1);
                        counter++;
                    } catch (Exception e) {
                        counter++;
                        sample = "";
                    }
                }
                sample = sample.toUpperCase();
                transformedString = transformedString + sample;
            } else {
                sample = (initialString.substring(counter, counter + 1)).toLowerCase();
                transformedString = transformedString + sample;
                counter++;
            }
        }
        if (transformedString.substring(transformedString.length() - 1, transformedString.length()).equals(" ")) {
            transformedString = transformedString.substring(0, transformedString.length() - 1);
        }
        if (transformedString.substring(0, 1).equals(" ")) {
            transformedString = transformedString.substring(1, transformedString.length());
        }
        return transformedString;
    }

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
                    //@RR
                    int clientId = 1;
                    int accountId = 1;
                    Account a = bank.getClientAccount(clientId, accountId);
                    a.deposit(500.00);
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

