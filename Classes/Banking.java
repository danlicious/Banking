package banking;

public class Banking {

    public static void main(String[] args) {
        UserInputManager uim = new UserInputManager();
        Bank bank = new Bank();
        System.out.println("\n\n      Welcome to our bank \"Big Brains, Big Money\"");
        int userOption = uim.retrieveUserOption();
        boolean doLoop = true;
        while (doLoop) {
            switch (userOption) {

                case 1:
                    System.out.println("[Bank] You selected: Add a new Client\n");
                    bank.addClient(uim.retrieveClientInfo());
                    break;
                case 2:
                    System.out.println("[Bank] You selected: Create a new Account\n");
                    System.out.println(uim.retrieveClientId());
                    break;
                case 3:
                    System.out.println("[Bank] You selected: Make a Deposit\n");
                    break;
                case 4:
                    System.out.println("[Bank] You selected: Make a Withdrawal\n");
                    break;
                case 5:
                    System.out.println("[Bank] You selected: List Account Transactions\n");
                    break;
                case 6:
                    System.out.println("[Bank] You selected: List Clients\n");
                    break;
                case 7:
                    System.out.println("[Bank] You selected: List Client Accounts\n");
                    break;
            }
            userOption = uim.retrieveUserOption();
        }

    }
}
