package banking;
public class Banking {
    public static void main(String[] args) {
       UserInputManager uim = new UserInputManager();
       Bank bank = new Bank();
       System.out.println("Welcome to our bank! Please select an option below:\n[1] Add a new Client\n[2] Create a new Account\n[3] Make a Deposit\n[4] Make a Withdrawal\n[5] List Account Transactions\n[6] List Clients\n[7] List Client Accounts ");
       int userOption = uim.retrieveUserOption();
       switch (userOption){
           case 1:
               System.out.println("You selected: Add a new Client");
               bank.addClient(uim.retrieveClientInfo());
               break;
           case 2:
               System.out.println("You selected: Create a new Account");
               break;
           case 3:
               System.out.println("You selected: Make a Deposit");
               break;
           case 4:
               System.out.println("You selected: Make a Withdrawal");
               break;
           case 5:
               System.out.println("You selected: List Account Transactions");
               break;
            case 6:
               System.out.println("You selected: List Clients");
               break;
            case 7:
               System.out.println("You selected: List Client Accounts");
               break;
       } 
    }
}
