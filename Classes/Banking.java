package banking;
public class Banking {
    public static void main(String[] args) {
       UserInputManager uim = new UserInputManager();
       System.out.println("Welcome to our bank! Please select an option below:\n[1] Add a new Client\n[2] Create a new Account\n[3] Make a Deposit\n[4] Make a Withdrawal\n[5] List Account Transactions\n[6] List Clients\n[7] List Client Accounts ");
       uim.retrieveUserOption();
    }
}
