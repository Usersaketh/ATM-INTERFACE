import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nSuccessfully deposited: ₹" + amount);
        } else {
            System.out.println("\nDeposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\nSuccessfully withdrew: ₹" + amount);
        } else if (amount > balance) {
            System.out.println("\nInsufficient balance. Withdrawal failed.");
        } else {
            System.out.println("\nWithdrawal amount must be positive.");
        }
    }
}

class ATM {
    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("\nATM Interface:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> checkBalance();
                    case 2 -> {
                        System.out.print("Enter deposit amount: ₹");
                        double depositAmount = scanner.nextDouble();
                        deposit(depositAmount);
                    }
                    case 3 -> {
                        System.out.print("Enter withdrawal amount: ₹");
                        double withdrawalAmount = scanner.nextDouble();
                        withdraw(withdrawalAmount);
                    }
                    case 4 -> {
                        exit = true;
                        System.out.println("\nThank you for using the ATM. Goodbye!");
                    }
                    default -> System.out.println("\nInvalid choice. Please try again.");
                }
            }
        }
    }

    private void checkBalance() {
        System.out.println("\nYour current balance is: ₹" + account.getBalance());
    }

    private void deposit(double amount) {
        account.deposit(amount);
    }

    private void withdraw(double amount) {
        account.withdraw(amount);
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(10000.00);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
