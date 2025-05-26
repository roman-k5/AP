public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String name, String accNo, double initialBalance, double overdraftLimit) {
        super(name, accNo, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance + overdraftLimit) {
            throw new InsufficientFundsException("Withdrawal failed: Overdraft limit exceeded!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Current Account | Holder: " + getAccountHolderName() +
                " | Acc#: " + getAccountNumber() + " | Balance: " + balance + " | Overdraft Limit: " + overdraftLimit);
    }
}
