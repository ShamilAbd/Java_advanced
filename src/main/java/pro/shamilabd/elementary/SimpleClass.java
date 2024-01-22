package pro.shamilabd.elementary;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 11.04.2023
 */
public class SimpleClass {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(123, "Shamil", 10000);
        BankAccount b2 = new BankAccount(120, "Vasya",5000);
        BankAccount b3 = new BankAccount(125, "Katya",100);

        b1.increaseBalance(1111);
        System.out.println(b1.getBalance());
//        b1.decreaseBalance(71111);
//        System.out.println(b1.getBalance());
        b1.decreaseBalance(258.55);
        System.out.println(b1.getBalance());

        System.out.println(b2.increaseBalance(1));

    }
}

class BankAccount {
    // States
    private static int nextId = 1;
    private final int id;
    private final int account;
    private double balance;
    private final String owner;

    // Constructor
    public BankAccount(int account, String owner, double balance) {
        this.account = account;
        this.owner = owner;
        this.balance = balance;
    }

    // non-static initializer
    {
        id = nextId++;
    }

    // Behaviors
    public double getBalance() {
        return balance;
    }

    public double increaseBalance(double balance) {
        return this.balance += balance;
    }

    public double decreaseBalance(double balance) {
        if(this.balance - balance < 0) throw new RuntimeException("Запрещено уходить в долг :-(");
        return this.balance -= balance;
    }
}
