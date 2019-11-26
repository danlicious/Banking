package banking;

import java.util.Scanner;

public class UserInputManager {

    private static boolean valid;
    private static int inputLength;
    private static int counter;
    private static String userInput;
    private static String validInput;
    private static String sample;
    private static final Scanner scan = new Scanner(System.in);

    /* Daniel P.
        When the console needs to retrieve information, this code will prevent unwanted inputs. 
     */
    private String scanInput(String desiredReturn) {

        //Until the appropriate conditions are met, scanned values will not be returned.
        do {
            userInput = scan.nextLine();
            inputLength = userInput.length();
            counter = 0;
            valid = false;

            System.out.println("\n[DEV] Detected input: " + userInput + "\n");

            switch (userInput) {
                case "stop":
                    System.err.println("INPUT WAS 'stop' (STOPPING THE PROGRAM)");
                    System.exit(0);
                case "":
                    System.err.println("Nothing happened.\n");
                    break;
                default:
                    switch (desiredReturn) {

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
                                System.err.println("Your input must correspond to one of the options.");
                            }
                            break;

                        case "name":

                            String possibleComponents[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "-", " "};
                            sample = userInput.substring(counter, counter + 1);

                            //Every letter must correspond to one in the array
                            do {
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

                        case "id":
                            System.out.println("Beep Boop");
                            break;
                    }
                    break;
            }
        } while (valid == false);
        return validInput;
    }

    private String autoCapitalize(String initialString) {

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
        //This removes the surrounding spaces that were added
        if (transformedString.substring(transformedString.length() - 1, transformedString.length()).equals(" ")) {
            transformedString = transformedString.substring(0, transformedString.length() - 1);
        }
        if (transformedString.substring(0, 1).equals(" ")) {
            transformedString = transformedString.substring(1, transformedString.length());
        }
        return transformedString;
    }

    int retrieveUserOption() {
        String option1 = "[1] Add a new Client";
        String option2 = "[2] Create a new Account";
        String option3 = "[3] Make a Deposit";
        String option4 = "[4] Make a Withdrawal";
        String option5 = "[5] List Account Transactions";
        String option6 = "[6] List Clients";
        String option7 = "[7] List Client Accounts";
        System.out.println("\n=========================================================");
        System.out.printf("%n%-32s%-32s%n%-32s%-32s%n%-32s%-32s%n%-32s%n%n=========================================================%n%n", option1, option2, option3, option4, option5, option6, option7);
        System.out.println("[Bank] Please enter the digit of one of the 7 available options : \n");

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
