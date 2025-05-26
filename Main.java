import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rural Bank of Nepal");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);

        // Create accounts
        SavingsAccount savings = new SavingsAccount(customerName, "SAV123", 5000);
        CurrentAccount current = new CurrentAccount(customerName, "CUR456", 3000, 2000);

        customer.addAccount(savings);
        customer.addAccount(current);

        int choice;
        do {
            System.out.println("\nChoose operation:\n1. Deposit\n2. Withdraw\n3. Add Interest\n4. View Accounts\n5. Exit");
            choice = scanner.nextInt();

            BankAccount selectedAccount = null;

            if (choice >= 1 && choice <= 3) {
                System.out.print("Select account (1: Savings, 2: Current): ");
                int accChoice = scanner.nextInt();
                selectedAccount = (accChoice == 1) ? savings : current;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    selectedAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        selectedAccount.withdraw(withdrawAmount);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    if (selectedAccount instanceof SavingsAccount) {
                        ((SavingsAccount) selectedAccount).addInterest();
                    } else {
                        System.out.println("Interest can only be added to savings accounts.");
                    }
                    break;

                case 4:
                    customer.displayAllAccounts();
                    break;

                case 5:
                    System.out.println("Thank you for using Rural Bank of Nepal. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
