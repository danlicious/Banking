package banking;

import java.util.Scanner;

public class UserInputManager {

    private static final Scanner scan = new Scanner(System.in);
    private static String userInput;
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
                    System.err.println("Sorry, I didn't get that.\n");
                    break;
                default:
                    switch (desiredType) {

                        //Selection of the 7 banking options.
                        case "option":

                            //Only allow 1 digit when selecting.
                            if (inputLength == 1) {
                                try {
                                    int i = Integer.parseInt(userInput);

                                    //Only allow 1 to 7
                                    if (i <= 7 && i >= 1) {
                                        return userInput;
                                    } else {
                                        System.err.println(i + " is not an option, try 1-7.\n");
                                    }

                                    //Only allow integers
                                } catch (Exception e) {
                                    System.err.println("The input must be a whole number. Try 1-7.\n");
                                }
                            } else {
                                System.err.println("The selection must contain a single digit. Try 1-7.\n");
                            }
                            break;

                        case "name":

                            if (inputLength < 1 || inputLength > 32) {
                                System.err.println("You name must contain 1 to 32 characters.\n");
                                break;
                            } else {

                                String possibleCharacters[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "-", " "};
                                boolean validName = false;
                                boolean doLoop = true;

                                //Check every letter
                                while (counter < inputLength && doLoop == true) {

                                    sample = userInput.substring(counter, counter + 1);

                                    validName = false;

                                    //Look for match
                                    for (String pc : possibleCharacters) {
                                        if (sample.equals(pc)) {
                                            validName = true;
                                        }
                                    }
                                    if (validName == false) {
                                        doLoop = false;
                                    } else {
                                        counter++;
                                    }
                                }
                                if (validName == true) {

                                    //Auto-capitalize name
                                    String capitalizedName = "";

                                    for (counter = 0; counter < inputLength; counter++) {

                                        int i = counter;
                                        String s = userInput.substring(i, i + 1);

                                        if (s.equals(" ") || s.equals("-")) {

                                            //prevent useless spaces/hypens
                                            try {
                                                if (userInput.substring(i + 1, i + 2).equals(" ") || userInput.substring(i + 1, i + 2).equals("-")) {
                                                    counter++;
                                                } else {
                                                    capitalizedName = capitalizedName + s + userInput.substring(i + 1, i + 2).toUpperCase();
                                                    System.out.println("capitalize at: " + s);
                                                    counter++;
                                                }
                                            } catch (Exception e) {

                                            }
                                        } else if (i == 0) {

                                            capitalizedName = capitalizedName + userInput.substring(i, i + 1).toUpperCase();
                                        } else {

                                            capitalizedName = capitalizedName + userInput.substring(i, i + 1).toLowerCase();
                                        }
                                    }
                                    return capitalizedName;
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
        return userInput;
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
            
            /*int clientLength = Bank.getClientList().size() + 1;
            int r = 1;
            for (int i = 0; i < r; i++) {
                if (id <= clientLength && id > 0) {
                } else {
                    System.out.println("banking.UserInputManager.retrieveClientId()");
                    r++;
                }
            }
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
        Account test = new Account();
        System.out.println("Please enter the type of account desired (\"1\" for Checkings, \"2\" for Savings) ");
        int accountType = scan.nextInt();                                                       //default type is 3, meaning no type
        return test;
    }

    
    

    double retrieveTransactionAmount() {
        System.out.print("Please enter the desired amount for the current transaction: ");
        retrieveTransactionAmount();
        double transAmount = scan.nextDouble();
        return transAmount;
    }

}
