package banking;

import static banking.Bank.getClientList;
import java.util.Set;

public class Banking {

    public static void main(String[] args) {

        System.out.println("\n     { Welcome to BBM \"Big Brains, Big Money\" }");

        Bank bank = new Bank();
        UserInputManager uim = new UserInputManager();
        int userOption;
        Client client;
        Account account;

        do {

            userOption = uim.retrieveUserOption();

            if (userOption == 1) {                          //CREATE CLIENT
                client = uim.retrieveClientInfo();
                bank.addClient(client);

            } else if (userOption == 2) {                 //CREATE ACCOUNT 

                if (Bank.getClientList().size() > 0) {
                    try {
                        client = bank.getClient(uim.retrieveClientId());
                        account = uim.retrieveAccountType(client);

                        if (account == null) {
                            System.err.println("Sorry! that wasn't an option.\n");
                        } else {
                            client.addAccount(account);
                        }

                    } catch (Exception e) {
                        System.err.println("Sorry! this client does not exist.\n");
                    }

                } else {
                    System.err.println("Sorry! We don't have any clients yet.\n");
                }

            } else if (userOption == 3 || userOption == 4) {    //DEPOSIT/WITHDRAWAL

                if (getClientList().size() > 0) {

                    try {

                        client = bank.getClient(uim.retrieveClientId());

                        if (client.getAccountList().size() > 0) {

                            try {
                                bank.displayClientAccounts(client.getId());
                                account = client.getAccount(uim.retrieveAccountNumber());
                                double amount = uim.retrieveTransactionAmount();
                                
                                if (userOption == 3) {
                                    account.deposit(amount);
                                  
                                }
                                if (userOption == 4) {  
                                    account.withdrawal(amount);
                                    
                                }
                                System.out.println(account);
                                

                            } catch (Exception e) {
                                System.err.println("Sorry! this account does not belong to " + client + ".\n");
                            }

                        } else {
                            System.err.println("Sorry! " + client + " does not have an account yet.\n");
                        }

                    } catch (Exception e) {
                        System.err.println("Sorry! This client does not exist.\n");
                    }

                } else {
                    System.err.println("Sorry! We don't have any clients yet.\n");
                }
            } else if (userOption == 5) {
                //TODO
                //bank.listAccountTransactions();

            } else if (userOption == 6) {

                bank.displayClientList();

            } else if (userOption == 7) {
                if (getClientList().size() > 0) {
                    try {
                        bank.displayClientAccounts(uim.retrieveClientId());
                    } catch (Exception e) {
                        System.err.println("Sorry! This client does not exist.\n");
                    }
                } else {
                    System.err.println("Sorry! We don't have any clients yet.\n");
                }

            } else {
                System.err.println("Your input must correspond to one of the options [1,7]\n");
            }

        } while (!(userOption == 0));
        System.out.println("\n(TESTING) Input was " + userOption + ", stopping program.");
    }
}
