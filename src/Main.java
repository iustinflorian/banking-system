import java.util.Scanner;

abstract class bankAccount{
    public String firstName;
    public String lastName;
    private int accBalance;
}

class currentAccount extends bankAccount{
    public String firstName;
    public String lastName;
    private int accBalance;
    public int getBalance(){
        return accBalance;
    }
    public void setBalance(int b){
        this.accBalance = b;
    }
    public void deposit(double amount){
        this.accBalance += amount;
        System.out.println("DEPOSIT: Account balance of " + this.firstName
        + " " + this.lastName + " becomes $" + this.accBalance);
    }
    public void withdraw(double amount){
        if (this.accBalance >= amount) {
            this.accBalance -= amount;
            System.out.println("WITHDRAW: Account balance of " + this.firstName
                    + " " + this.lastName + " becomes $" + this.accBalance);
        }
        else System.out.println("ERROR: Insufficient funds.");
    }
    public void transfer(double amount, currentAccount acc){
       if (this.accBalance >= amount) {
           this.accBalance -= amount;
           acc.accBalance += amount;
           System.out.println("TRANSFER: Account balance of " + this.firstName
                   + " " + this.lastName + " becomes $" + this.accBalance);
           System.out.println("TRANSFER: Account balance of " + acc.firstName
                   + " " + acc.lastName + "(sender) becomes $" + acc.accBalance);
       }
        else System.out.println("ERROR: Insufficient funds.");
    }
}

public class Main{
    public static void main(String[] args){
        currentAccount acc1 = new currentAccount();
        currentAccount acc2 = new currentAccount();
        Scanner sc = new Scanner(System.in);
        acc1.firstName = "Tom";
        acc1.lastName = "Ford";
        acc2.firstName = "Thomas";
        acc2.lastName = "Shelby";
        acc1.setBalance(1000);
        acc2.setBalance(2500);
        System.out.println("Tom Ford's account balance: " + acc1.getBalance());
        System.out.println("Thomas Shelby's account balance: " + acc2.getBalance());
        System.out.println("-> The following operations are on Tom Ford's account");
        System.out.print("DEPOSIT: ");
        int amount1 = sc.nextInt();
        acc1.deposit(amount1);
        System.out.print("WITHDRAW: ");
        int amount2 = sc.nextInt();
        acc1.withdraw(amount2);
        System.out.print("TRANSFER from TOM FORD to Thomas Shelby: ");
        int amount3 = sc.nextInt();
        acc1.transfer(amount3, acc2);
    }
}