import java.util.Scanner;

class Account {
    String customerName;
    String accountNumber;
    String accountType;
    double balance;

    Account(String name, String accNo, String type, double bal) {
        customerName = name;
        accountNumber = accNo;
        accountType = type;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited: " + amount);
        displayBalance();
    }

    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
        displayBalance();
    }
}


class SavAcct extends Account {
    double interestRate = 0.10; 

    SavAcct(String name, String accNo, double bal) {
        super(name, accNo, "Savings", bal);
    }

    void computeAndDepositInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of " + interest + " added to account.");
        displayBalance();
    }
}


class CurAcct extends Account {
    double minBalance = 10000;
    double serviceCharge = 800;

    CurAcct(String name, String accNo, double bal) {
        super(name, accNo, "Current", bal);
    }

    @Override
    void withdraw(double amount) {
        if (balance - amount < 0) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        checkMinimumBalance();
        displayBalance();
    }

    void checkMinimumBalance() {
        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum. Service charge of " + serviceCharge + " imposed.");
        }
    }

    void issueChequeBook() {
        System.out.println("Cheque book issued to " + customerName);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();
        System.out.print("Enter account type (savings/current): ");
        String type = sc.next().toLowerCase();

        Account acc;
        if (type.equals("savings")) {
            acc = new SavAcct(name, accNo, bal);
        } else {
            acc = new CurAcct(name, accNo, bal);
        }

        int choice;
        System.out.println("\n1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Display Balance");
        if (acc instanceof SavAcct)
            System.out.println("4. Compute Interest");
        if (acc instanceof CurAcct)
            System.out.println("5. Issue Cheque Book");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        choice = sc.nextInt();

         while (choice != 0){
            
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wd = sc.nextDouble();
                    acc.withdraw(wd);
                    break;
                case 3:
                    acc.displayBalance();
                    break;
                case 4:
                    if (acc instanceof SavAcct)
                        ((SavAcct) acc).computeAndDepositInterest();
                    break;
                case 5:
                    if (acc instanceof CurAcct)
                        ((CurAcct) acc).issueChequeBook();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
        }

        sc.close();
    }
}
