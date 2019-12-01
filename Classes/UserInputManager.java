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

    public static int retrieveAccountNumber() {

        System.out.print("\nPlease enter the account number of the desired account: ");
        int accountNum = scan.nextInt();
        return accountNum;
    }

    public static Account retrieveAccountType(Client owner) {

        String type1 = "[1] Checking";
        String type2 = "[2] Savings";
        System.out.println("\nPlease enter the desired type of account.");
        System.out.println("=========================================================");
        System.out.printf("%n%-32s%-32s%n%n=========================================================%nSelection: ", type1, type2);

        int accountType = scan.nextInt();

        Account account = null;

        if(accountType ==1 ){
            account = new CheckingAccount(owner, "Checking");
        }else if(accountType ==2){
            account = new CheckingAccount(owner, "Savings");
        }else{
                account = null; 
        }
        return account;
    }

    //Farhan
    public static int retrieveClientId() {

        System.out.print("\nPlease enter the client's id: ");
        int id = scan.nextInt();
        return id;

    }

    //Farhan
    public static Client retrieveClientInfo() {

        Client client = new Client();
        while(scan.nextLine().isEmpty()){
        System.out.print("\nWhat is the client's first name? ");
        client.setFirstName(scan.nextLine());
        System.out.print("What is the client's last name? ");
        client.setLastName(scan.nextLine());
        break;
        }
        
        return client;
    }

    public static double retrieveTransactionAmount() {
        System.out.print("Please enter the desired amount for the current transaction: ");
        double amount = scan.nextDouble();
        return amount;
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
        int userOption = scan.nextInt();
        return userOption;
    }

}
