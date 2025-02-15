public class BankAccount {
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {  
        return balance;
    }

    public void showAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}

// Separate SavingsAccount class
class SavingsAccount extends  BankAccount {
    private double interestRate;

    public SavingsAccount(String accountHolderName, double balance, double interestRate) {
        super(accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        deposit(getBalance() * interestRate / 100);
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("Ali", 30000, 7);
        savingsAccount.showAccountDetails();
        savingsAccount.applyInterest();
        System.out.println("New Balance after Interest: " + savingsAccount.getBalance());
    }
}
