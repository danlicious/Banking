package banking;

import java.util.Scanner;

public class UserInputManager {

    Scanner scan = new Scanner(System.in);
    String userInput;

    //Dan-23nov This function allows for a general Scan, letting further functions check if it corresponds to the desired type, i.e. is "phallus" a valid userOption? 
    String scanInput(String desiredType) {

        boolean canBeConverted = false;

        while (canBeConverted == false) {

            userInput = scan.next();

            System.out.println("\nInput: " + userInput);
            //Dan- Stops the program when "stop" is input
            if (userInput.equals("stop")) {
                System.err.println("INPUT WAS 'stop' (STOPPING THE PROGRAM)");
                System.exit(0);
            } else {
                //Dan- prevents crashes if wrong type is scanned
                switch (desiredType) {

                    case "integer":
                        try {
                            int i = Integer.parseInt(userInput);
                            canBeConverted = true;
                            return userInput;
                        } catch (Exception e) {
                            System.err.println("The input must be a whole number , please try again.\n");
                            break;
                        }

                }
            }
        }
        System.out.println("reached end. BAD");
        return userInput;
    }

    //Dan-20nov: When I call this function, it asks me to do it twice.. Please fix. -Dan    I did it!!!! -frahan
    int retrieveUserOption() {

        int userOption = -1;

        while (userOption == -1) {

            System.out.println("Please enter the digit of one of the 7 options available: ");
            userOption = Integer.parseInt(scanInput("integer"));
            
            if (userOption < 1 || userOption > 7) {
                System.err.println(userOption + " is not an option. Please try again.");
                userOption = -1;
            }
        }
        return userOption;
    }

//Updates: Dan-nov22, I changed it to "nextLine()" because some
    Client retrieveClientInfo() {

        System.out.println("What is your first name?");
        String firstName = scan.nextLine();                                                            // get variables firstName, lastName from Client??  
        System.out.println("What is your last name?");
        String lastName = scan.nextLine();
        Client client = new Client(firstName, lastName);                                                             // needs 'firstName,lastName' constructor
        return client;
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

    int retrieveClientId() {

        System.out.print("Please enter your client id: ");
        int id = scan.nextInt();
        int clientLength = Bank.getClientList().size() + 1;
        int r = 1;
        for (int i = 0; i < r; i++) {
            if (id <= clientLength && id > 0) {
            } else {
                System.out.println("banking.UserInputManager.retrieveClientId()");
                r++;
            }
        }

        return id;

    }

    double retrieveTransactionAmount() {
        System.out.print("Please enter the desired amount for the current transaction: ");
        retrieveTransactionAmount();
        double transAmount = scan.nextDouble();
        return transAmount;
    }

}
