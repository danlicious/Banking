package banking;

import java.util.Scanner;

public class UserInputManager {

    
    private static final Scanner scan = new Scanner(System.in);
    
    //@RR 
    //TODO move to banking
    

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
        int userOption = Integer.parseInt(Banking.scanInput("option"));
        return userOption;
    }

    public static String Scanner(){
        
       String userInput = scan.nextLine();
       return userInput;
    }
    
    
    //Farhan
    public static Client retrieveClientInfo() {

        //TODO
        System.out.print("\nWhat is the client's first name? ");
        String firstName = Banking.scanInput("name");//Scanner scan = new Scanner(System.in); scan.next();
        System.out.print("What is the client's last name? ");
        String lastName = Banking.scanInput("name");
        Client client = new Client(firstName, lastName);
        return client;
    }

    //Farhan
    public static int retrieveClientId() {

        System.out.print("\nPlease enter the client's id: ");
        int id = Integer.parseInt(Banking.scanInput("clientId"));
        return id;

    }

    public static int retrieveAccountNumber() {  //Marius

        
        System.out.print("\n\nPlease enter the account number of the desired account: ");
        int accountNum = scan.nextInt();
        if (accountNum < 1) {
            System.err.println("This account number is invalid, please try again");
            retrieveAccountNumber();
        } else if (accountNum > Account.getCounter()) {
            System.err.println("This account number is invalid, please try again");
            retrieveAccountNumber();
        }
        return accountNum ;
    }
    


//Farhan, Daniel
public static Account retrieveAccountType(Client owner) {
        
        
        String type1 = "[1] Checking";
        String type2 = "[2] Savings";
        System.out.println("\nPlease enter the desired type of account.");
        System.out.println("=========================================================");
        System.out.printf("%n%-32s%-32s%n%n=========================================================%nSelection: ", type1, type2);
        
        int accountType = Integer.parseInt(Banking.scanInput("accountType"));
        
        Account account = null;
        
        switch (accountType) {
            case 1:
                account = new CheckingAccount();
                break;

            case 2:
                account = new SavingsAccount();
                break;
        }
        return account;
    }

    public static double retrieveTransactionAmount() {
        System.out.print("Please enter the desired amount for the current transaction: ");
        double transAmount = scan.nextDouble();
        return transAmount;
    }

}
