package banking;
import java.util.Scanner;

public class UserInputManager {
     Scanner scan = new Scanner(System.in);
   // Client TestObject = new Client(retrieveClientId(),firstName,lastName,accountList);
    int userOption;
    
    
    
   
    int retrieveAccountNumber(){

        System.out.print("Please enter the account number of the desired account: ");
        int accountNum = scan.nextInt();
        return accountNum;
    }
    Account retrieveAccountType(){
        Account test = new Account();
        System.out.println("Please enter the type of account desired (\"1\" for Checkings, \"2\" for Savings) ");
        int accountType = scan.nextInt();                                                       //default type is 3, meaning no type
        return test;
    }
    int retrieveClientId(){

        System.out.print("Please enter your client id: ");
        int clientId = scan.nextInt();
        return clientId;
    }
    Client retrieveClientInfo(){

        System.out.println("Please input your first name");
        String firstName = scan.next();                                                            // get variables firstName, lastName from Client??                 
        String lastName = scan.next();
        Client client = new Client();                                                             // needs 'firstName,lastName' constructor
        return client;
    }
    double retrieveTransactionAmount(){
        System.out.print("Please enter the desired amount for the current transaction: ");
        retrieveTransactionAmount();
        double transAmount = scan.nextDouble();
        return transAmount;
    }
    int retrieveUserOption(){

        int r = 1;
        for (int i = 0; i <= r; i++) {
            System.out.println("Please enter the digit of one of the 7 options available: ");
        userOption = scan.nextInt();
        
        if(userOption <= 7 && userOption >= 1){                
       
        }
        else{
            r++;
            System.out.println("banking.UserInputManager.retrieveUserOption()");
            
        }
    }
        return userOption;
    }
}
