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
    
    int retrieveAccountNumber(){
        int accountNum = scan.nextInt();
        return accountNum;
    }
    int retrieveClientId(){
        int clientId = scan.nextInt();
        return clientId;
    }
    double retrieveTransactionAmount(){
        double transAmount = scan.nextDouble();
        return transAmount;
    }
    int retrieveUserOption(){
        int r = 1;
        for (int i = 0; i <= r; i++) {
    
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
