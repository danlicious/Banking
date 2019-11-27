package banking;

import java.util.Scanner;

public class UserInputManager {

    private static boolean valid; //Is the input usable by the calling method?
    private static int inputLength; 
    private static int counter; //used for counting
    private static String userInput; 
    private static String validInput; //Final and (if needed) transformed input.
    private static String sample;   //used for substrings.
    private static final Scanner scan = new Scanner(System.in);

    
    private static String scanInput(String desiredReturn) { //Daniel: When the console needs to retrieve information, this code will prevent unwanted inputs.

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

    //Daniel 
    private static String autoCapitalize(String initialString) { 
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

    //Farhan, Daniel, Marius
    public static int retrieveUserOption() {
        String option1 = "[1] Add a new Client";
        String option2 = "[2] Create a new Account";
        String option3 = "[3] Make a Deposit";
        String option4 = "[4] Make a Withdrawal";
        String option5 = "[5] List Account Transactions";
        String option6 = "[6] List Clients";
        String option7 = "[7] List Client Accounts";
        System.out.println("\nTo perform an action, enter its corresponding number.");
        System.out.println("=========================================================");
        System.out.printf("%n%-32s%-32s%n%-32s%-32s%n%-32s%-32s%n%-32s%n%n=========================================================%nSelection: ", option1, option2, option3, option4, option5, option6, option7);
        int userOption = Integer.parseInt(scanInput("option"));
        return userOption;
    }

    //Farhan
    public static Client retrieveClientInfo() {

        System.out.print("\nWhat is the client's first name? ");
        String firstName = scanInput("name");
        System.out.print("What is the client's last name? ");
        String lastName = scanInput("name");
        Client client = new Client(firstName, lastName);
        return client;
    }

    //Farhan
    public static int retrieveClientId() {

        System.out.print("\nPlease enter the client's id: ");
        int id = Integer.parseInt(scanInput("clientId"));
        return id;

    }
    
    
    public static int retrieveAccountNumber() {

        System.out.print("\nPlease enter the account number of the desired account: ");
        int accountNum = scan.nextInt();
        return accountNum;
    }

    //Farhan, Daniel
    public static Account retrieveAccountType(Client owner) {
        
        
        String type1 = "[1] Checking";
        String type2 = "[2] Savings";
        System.out.println("\nPlease enter the desired type of account.");
        System.out.println("=========================================================");
        System.out.printf("%n%-32s%-32s%n%n=========================================================%nSelection: ", type1, type2);
        
        int accountType = Integer.parseInt(scanInput("accountType"));
        
        Account account = null;
        
        switch (accountType) {
            case 1:
                account = new CheckingAccount(owner, "Checking");
                break;

            case 2:
                account = new SavingsAccount(owner, "Savings");
                break;
        }
        return account;
    }

    public static double retrieveTransactionAmount() {
        System.out.print("Please enter the desired amount for the current transaction: ");
        retrieveTransactionAmount();
        double transAmount = scan.nextDouble();
        return transAmount;
    }

}
