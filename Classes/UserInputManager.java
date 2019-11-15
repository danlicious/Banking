/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;
import java.util.Scanner;
/**
 *
 * @author cstuser
 */
public class UserInputManager {
     Scanner scan = new Scanner(System.in);
    Client TestObject = new Client(retrieveClientId(),firstName,lastName,accountList);
    int userOption;
    
    
    
   
    int retrieveAccountNumber(){
         /**
    * Inquires the user to input the account number of the desired account
    * then retrieves the entry from the console
    * 
    * return the account number
    */
        System.out.print("Please enter the account number of the desired account: ");
        int accountNum = scan.nextInt();
        return accountNum;
    }
    Account retrieveAccountType(){
        
    /**
    * Inquires the user to input the type of new account desired
    * then retrieves the entry from the console
    * 
    * return the Account object (based on the desired type)
    */
        System.out.println("Please enter the type of account desired (\"1\" for Checkings, \"2\" for Savings) ");
        int accountType = scan.nextInt();                                                       //default type is 3, meaning no type
    return Account;
    }
    int retrieveClientId(){
        /**
    * Inquires the user to input the id of the desired Client
    * then retrieves the entry from the console
    * 
    * return the client id
    */
        System.out.print("Please enter your client id: ");
        int clientId = scan.nextInt();
        return clientId;
    }
    Client retrieveClientInfo(){
   /**
    * Inquires the user to input the first and last names of the new client
    * then retrieves the entries from the console
    * 
    * return the Client object (using the entered data)
    */
        System.out.println("Please input your first name");
        String firstName = scan.next();                                                            // get variables firstName, lastName from Client??                 
        String lastName = scan.next();
        return Client;
    }
    double retrieveTransactionAmount(){
             /**
    * Inquires the user to input the desired amount for the current transaction
    * then retrieves the entry from the console
    * 
    * return the amount of the transaction
    */  System.out.print("Please enter the desired amount for the current transaction: ");
        retrieveTransactionAmount();
        double transAmount = scan.nextDouble();
        return transAmount;
    }
    int retrieveUserOption(){
        /**
    * Inquires the user to input the number associated with the operation he/she wants to execute
    * then retrieves the entry from the console
    * 
    * return the selected option number
    */
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
