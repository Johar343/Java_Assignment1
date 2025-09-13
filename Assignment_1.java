import java.util.Scanner;

// Account class
class Account {
    int accountNumber;
    String accountHolderName;
    double balance;
    String email;
    String phoneNumber;

    // Deposit method
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    // Display account details
    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }

    // Update contact details
    void updateContactDetails(String newEmail, String newPhoneNumber) {
        email = newEmail;
        phoneNumber = newPhoneNumber;
        System.out.println("Contact details updated successfully!");
    }
}

// UserInterface class
public class Assignment_1 {
    static Account[] accounts = new Account[100]; // array to store accounts
    static int accountCount = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nWelcome to the Banking Application!");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                createAccount();
            } else if (choice == 2) {
                performDeposit();
            } else if (choice == 3) {
                performWithdrawal();
            } else if (choice == 4) {
                showAccountDetails();
            } else if (choice == 5) {
                updateContact();
            } else if (choice == 6) {
                System.out.println("Thank you for using the Banking Application!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);
    }

    // Create account
    static void createAccount() {
        Account acc = new Account();
        acc.accountNumber = 1000 + accountCount + 1; // simple auto-generated account number
        System.out.print("Enter account holder name: ");
        acc.accountHolderName = sc.nextLine();
        System.out.print("Enter initial deposit amount: ");
        acc.balance = sc.nextDouble();
        sc.nextLine(); // consume newline
        System.out.print("Enter email address: ");
        acc.email = sc.nextLine();
        System.out.print("Enter phone number: ");
        acc.phoneNumber = sc.nextLine();

        accounts[accountCount] = acc;
        accountCount++;

        System.out.println("Account created successfully with Account Number: " + acc.accountNumber);
    }

    // Find account
    static Account findAccount(int accNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].accountNumber == accNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    // Deposit
    static void performDeposit() {
        System.out.print("Enter account number: ");
        int accNumber = sc.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        Account acc = findAccount(accNumber);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw
    static void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNumber = sc.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        Account acc = findAccount(accNumber);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Show details
    static void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNumber = sc.nextInt();

        Account acc = findAccount(accNumber);
        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    // Update contact
    static void updateContact() {
        System.out.print("Enter account number: ");
        int accNumber = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter new email: ");
        String email = sc.nextLine();
        System.out.print("Enter new phone number: ");
        String phone = sc.nextLine();

        Account acc = findAccount(accNumber);
        if (acc != null) {
            acc.updateContactDetails(email, phone);
        } else {
            System.out.println("Account not found.");
        }
    }
}
