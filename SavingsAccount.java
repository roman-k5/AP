public class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.05;

    public SavingsAccount(String name, String accNo, double initialBalance) {
        super(name, accNo, initialBalance);
    }

    public void addInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest added: " + interest + ". New balance: " + balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal failed: Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account | Holder: " + getAccountHolderName() +
                " | Acc#: " + getAccountNumber() + " | Balance: " + balance);
    }
}

