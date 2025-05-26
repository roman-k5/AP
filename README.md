RURAL BANK ACCOUNT MANAGEMENT SYSTEM

The Rural Bank Account Management System (RBAMS) is a console-based Java application designed to simulate banking operations for a rural bank in Nepal.It supports two types of accounts: Savings Account (with interest) and Current Account (with overdraft limit). The system is built using Object-Oriented Programming (OOP) principles to ensure modularity, scalability, and maintainability.

Class Design

BankAccount (Abstract Class)
-Serves as the base class for all account types.
-Contains common attributes like accountHolderName, accountNumber, and balance.
-Provides shared functionality such as deposit().
-Declares abstract methods withdraw() and displayAccountDetails() for implementation in child classes.

SavingsAccount (Child Class)
-Extends BankAccount.
-Adds functionality to apply interest to the balance.
-Disallows overdraft; throws exception if withdrawal exceeds balance.

CurrentAccount (Child Class)
-Extends BankAccount.
-Allows overdraft up to a predefined limit.
-Implements custom withdrawal logic to account for overdraft conditions.

Customer
-Represents a customer of the bank.
-Aggregates multiple BankAccount objects, supporting one-to-many relationship.
-Provides functionality to display all accounts associated with a customer.

InsufficientFundsException
-Custom exception class.
-Thrown when withdrawal operations violate account rules (e.g., overdraft exceeded).

Main Class
-Contains the main() method.
-Handles console interaction using a menu-driven interface.
-Allows deposit, withdrawal, interest addition, and viewing of accounts.

 
OOP Concepts Used

Abstraction
-Achieved through the BankAccount abstract class and method declarations.
-Hides implementation details from the user and exposes only relevant functionality.

Encapsulation
-Implemented using private access modifiers for class attributes.
-Data is accessed via public getter and setter methods to protect internal state.

Inheritance
-SavingsAccount and CurrentAccount inherit from the BankAccount class.
-Promotes code reuse and specialization of behavior.

Polymorphism
-Abstract methods like withdraw() are overridden differently in child classes.
-Allows for dynamic method binding and cleaner code in the main application.

Aggregation
-The Customer class holds a collection of BankAccount objects.
-Demonstrates a “has-a” relationship between customer and accounts.

Exception Handling
-Custom InsufficientFundsException improves program robustness.
-Handled gracefully in the main class to ensure user-friendly error messages.


Application Features
-Deposit funds into savings or current accounts.
-Withdraw money with account-specific constraints.
-Add interest to savings accounts.
-Handle overdrafts for current accounts.
-Display all accounts for a given customer.
-User-friendly console interface with menu selection.
