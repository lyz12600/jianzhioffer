package 银行卡取款;

/**
 * Created by liyanzhen on 17/6/23.
 */
public class Account {
    private String name;
    private double balance;

    public Account() {
    }

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount) {
        if (balance >= drawAmount) {
            System.out.println(Thread.currentThread().getName() + "取钱成功，出钞：" + drawAmount);
            balance -= drawAmount;
            System.out.println("余额为：" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足～");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
