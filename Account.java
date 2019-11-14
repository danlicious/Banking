/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.ArrayList;

/**
 *
 * @author cstuser
 */
public class Account {
    
    ArrayList<Integer> transactions = new ArrayList<Integer>();
    double deposit(double d){
        /**
     * Update the account balance with the amount of the deposit
     * Create the corresponding Transaction element and add it to the transactions list
     * 
     * return the new balance
     */
        
    }
    void displayAllTransactions(){
         /**
     * Print every Transaction listed in the transactions list
     * 
     */
         for (int transactions : transactions) {
             System.out.println(transactions);
        }
    }
        ArrayList<Transaction> getTransactions(){
            /**
     * Update the account balance with the amount of the withdrawl
     * Create the corresponding Transaction element and add it to the transactions list
     * 
     * return the new balance
     */
    }
   
    public String toString(){
         /**
     * return the string that you want to output when printing the object
     */
    }
    double withdrawal(double w){
          /**
     * Update the account balance with the amount of the withdrawal
     * Create the corresponding Transaction element and add it to the transactions list
     * 
     * return the new balance
     */
    
    }
}
