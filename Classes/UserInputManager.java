package banking;

import java.util.Scanner;

public class UserInputManager {

    private static final Scanner scan = new Scanner(System.in);
    private static String userInput;
    private static String finalInput;
    private static String sample;
    private static int inputLength;
    private static int counter;

    /* Daniel P.
        When the console needs to retrieve information, this code will prevent unwanted inputs. 
     */
    private String scanInput(String desiredType) {

        //Until the appropriate conditions are met, scanned values will not be returned.
        boolean willReturn = false;
        while (willReturn == false) {

            userInput = scan.nextLine();
            inputLength = userInput.length();
            counter = 0;

            System.out.println("\n[ DEV Detected input: " + userInput + " ]\n");

            switch (userInput) {
                case "stop":
                    System.err.println("INPUT WAS 'stop' (STOPPING THE PROGRAM)");
                    System.exit(0);
                case "":
                    System.err.println("Nothing happens. The program is silent.\n");
                    break;
                default:
                    switch (desiredType) {

                        //Caters the input so that it satisfies the calling function.
                        case "option":
                            if (inputLength == 1) {
                                try {
                                    int i = Integer.parseInt(userInput);

                                    if (i <= 7 && i >= 1) {
                                        
                                        return userInput;
                                        
                                    } else {//prevents integers other than 1 to 7;
                                        
                                        System.err.println(i + " is not an option, try 1-7.\n");
                                    }  
                                } catch (Exception e) {//Prevents non-integer input
                                    
                                    System.err.println("The input must be a whole number. Try 1-7.\n");
                                    
                                }
                            } else {//executes when input is longer than 1.
                                
                                System.err.println("The selection must contain a single digit. Try 1-7.\n");
                                
                            }
                            break;

                        case "name":

                            if (inputLength < 1 || inputLength > 32) {
                                System.err.println("You name must contain 1 to 32 characters.\n");
                                break;
                            } else {
                                
                                String possibleComponents[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "-", " "};
                                boolean validName = false;
                                boolean doLoop = true;

                                //Check every letter so that it belongs to the possibleCharacters[] array.
                                while (counter < inputLength && doLoop == true) {
                                    
                                    validName = false;
                                    sample = userInput.substring(counter, counter + 1);

                                    for (String pc : possibleComponents) {
                                        if (sample.equals(pc)) {
                                            validName = true;
                                        }
                                    }
                                    if (validName == false) {   //If no match found, stop checking the characters.
                                        doLoop = false;
                                    } else {
                                        counter++;
                                    }
                                }                           
                                if (validName == true) {    //If each component has a match, continue.
                                    
                                    finalInput = autoCapitalize(userInput); //Auto-capitalize name
                                    return finalInput;
                                    
                                } else {
                                    System.err.println("Your name is not valid. Please use a-Z.\n");
                                }
                            }
                            break;

                        case "id":
                            System.out.println("Beep Boop");
                            break;

                    }

                    break;
            }
        }
        System.out.println("reached end. BAD");
        return "Bruh Moment 100 (error)";
    }

    private String autoCapitalize(String initialString) {

        String capitalizedName = "";
        int sLength = initialString.length();
        System.err.println("INITIALSTRING: " + initialString);
        for (counter = 0; counter < sLength; counter++) {


            String s = initialString.substring(counter, counter + 1);
            System.out.print("COUNTER: " + counter + "  SUBSTRING:  " + s);

            if (s.equals(" ") || s.equals("-")) {

                //prevent useless spaces/hypens by checking what is after a space or hyphen.
                try {
                    if (initialString.substring(counter + 1, counter + 2).equals(" ") || initialString.substring(counter + 1, counter + 2).equals("-")) {
                        //WHEN THERE IS A "-" THERE IS A PROBLEM
                        
                    } else {
                        capitalizedName = capitalizedName + s + initialString.substring(counter + 1, counter + 2).toUpperCase();
                        System.out.println("capitalizing at: " + s);
                        counter++;
                    }
                } catch (Exception e) {
                    System.err.println("[ DEV Exception in UserInputManager, autoCapitalize() for " + initialString + " ]");
                }
            } else if (counter == 0) {
                capitalizedName = capitalizedName + initialString.substring(counter, counter + 1).toUpperCase();
            } else {
                capitalizedName = capitalizedName + initialString.substring(counter, counter + 1).toLowerCase();
            }
        }
        return capitalizedName;
    }

    int retrieveUserOption() {
        String option1 = "[1] Add a new Client";
        String option2 = "[2] Create a new Account";
        String option3 = "[3] Make a Deposit";
        String option4 = "[4] Make a Withdrawal";
        String option5 = "[5] List Account Transactions";
        String option6 = "[6] List Clients";
        String option7 = "[7] List Client Accounts";
        //System.out.println("\n\n      Welcome to our bank \"Big Brains, Big Money\"");
        System.out.println("\n=========================================================");
        System.out.printf("%n%-32s%-32s%n%-32s%-32s%n%-32s%-32s%n%-32s%n%n=========================================================%n%n", option1, option2, option3, option4, option5, option6, option7);
        System.out.println("[Bank] Please enter the digit of one of the 7 options available: \n");
        int userOption = Integer.parseInt(scanInput("option"));

        return userOption;
    }

    Client retrieveClientInfo() {

        System.out.println("[Bank] What is the client's first name?\n");
        String firstName = scanInput("name");
        System.out.println("[Bank] What is the client's last name?\n");
        String lastName = scanInput("name");
        Client client = new Client(firstName, lastName);
        return client;
    }

    int retrieveClientId() {

        System.out.print("Please enter your client id: ");
        int id = Integer.parseInt(scanInput("id"));

        /*
           System.out.print("Please enter your client id: ");
        int id = scan.nextInt();
        int clientLength = Bank.getClientList().size();
        clientLength = 1;
        System.err.println("clientLength = " + clientLength);
        int r = 0;
        for (int i = 0; i <= r; i++) {             //Assuming 'clientId' starts at '1'
            if(clientLength == 0){
                System.err.println("There");
            }
            else if (id <= clientLength+1 && id > 0) {
                System.err.println("if: r = " + r);   //testing
                
            } else {
                System.err.println("Error, not a valid id");   
                System.err.println("else: r = " + r);   //testing
                r++;
            }
        }

        return id;
         */
        return id;
    }

    int retrieveAccountNumber() {

        System.out.print("Please enter the account number of the desired account: ");
        int accountNum = scan.nextInt();
        return accountNum;
    }

    // THIS NEEDS TO BE REWORKED   
    Account retrieveAccountType() {
        System.out.println("Please enter the type of account desired (\"1\" for Checkings, \"2\" for Savings) ");
        int accountType = scan.nextInt();   //default type is 3, meaning no type
        //Assuming the account will be created in this function
        Account Account = null;

        switch (accountType) {
            case 1: {
                Account = new CheckingAccount();
                break;
            }
            case 2: {
                Account = new SavingsAccount();
                break;
            }
            default:
                System.err.println("Not a valid option - please try again");
                break;
        }

        return Account;
    }

    double retrieveTransactionAmount() {
        System.out.print("Please enter the desired amount for the current transaction: ");
        retrieveTransactionAmount();
        double transAmount = scan.nextDouble();
        return transAmount;
    }

}
