import java.util.Scanner;

class Account {
    String name;
    int accNo;
    String accType;
    double balance;

    Account(String n, int a, String t, double b) {
        name = n;
        accNo = a;
        accType = t;
        balance = b;
    }

    void deposit(double amt) {
        balance += amt;
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavAcct extends Account {
    double rate = 0.04;

    SavAcct(String n, int a, double b) {
        super(n, a, "Savings", b);
    }

    void computeInterest() {
        balance += balance * rate;
    }

    void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurAcct extends Account {
    double minBalance = 500;
    double penalty = 50;

    CurAcct(String n, int a, double b) {
        super(n, a, "Current", b);
    }

    void checkMinBalance() {
        if (balance < minBalance) {
            balance -= penalty;
            System.out.println("Penalty imposed. New Balance: " + balance);
        }
    }

    void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
            checkMinBalance();
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter account type (1 for Savings, 2 for Current): ");
        int type = sc.nextInt();

        if (type == 1) {
            SavAcct sAcc = new SavAcct(name, accNo, balance);
            sAcc.deposit(500);
            sAcc.computeInterest();
            sAcc.displayBalance();
            sAcc.withdraw(200);
            sAcc.displayBalance();
        } else if (type == 2) {
            CurAcct cAcc = new CurAcct(name, accNo, balance);
            cAcc.deposit(500);
            cAcc.displayBalance();
            cAcc.withdraw(200);
            cAcc.displayBalance();
        } else {
            System.out.println("Invalid account type.");
        }
    }
}
