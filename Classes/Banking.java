package banking;

public class Banking {

    public static void main(String[] args) {
        UserInputManager uim = new UserInputManager();
        Bank bank = new Bank();

        //System.out.print(uim.scanInput());
        String option1 = "[1] Add a new Client";
        String option2 = "[2] Create a new Account";
        String option3 = "[3] Make a Deposit";
        String option4 = "[4] Make a Withdrawal";
        String option5 = "[5] List Account Transactions";
        String option6 = "[6] List Clients";
        String option7 = "[7] List Client Accounts";
        System.out.println("\n\n      Welcome to our bank \"Big Brains, Big Money\"\n\n=========================================================");
        System.out.printf("%n%-32s%-32s%n%-32s%-32s%n%-32s%-32s%n%-32s%n%n=========================================================%n%n", option1, option2, option3, option4, option5, option6, option7);

        int userOption = uim.retrieveUserOption();

        while (!uim.userInput.equals("stop")) {
            switch (userOption) {

                case 1:
                    System.out.println("You selected: Add a new Client");
                    bank.addClient(uim.retrieveClientInfo());
                    break;
                case 2:
                    System.out.println("You selected: Create a new Account");
                    System.out.println(uim.retrieveClientId());
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
            userOption = uim.retrieveUserOption();
        }

    }
}
