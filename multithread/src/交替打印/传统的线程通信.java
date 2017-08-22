package 交替打印;

/**
 * Created by liyanzhen on 17/7/25.
 */
class Accout {
    private String accountNo;
    private double balance;
    private boolean flag = false;

    public Accout() {
    }

    public Accout(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void draw(double drawAccount) {
        try {
            if (!flag) {//刚刚取了钱
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱：-" + drawAccount);
                balance -= drawAccount;
                System.out.println("账户余额：" + balance);
                flag = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {

        try {
            if (flag) {//账户刚刚存了钱
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "存钱：" + depositAmount);
                balance += depositAmount;
                System.out.println("余额：" + balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DrawThread extends Thread {
    private Accout accout;
    private String name;
    private double drawAmount;

    public DrawThread(String name, Accout accout, double drawAmount) {
        this.accout = accout;
        this.name = name;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            accout.draw(drawAmount);
        }
    }
}

class DepositThread extends Thread {
    private Accout accout;
    private String name;
    private double depositAmount;

    public DepositThread(String name, Accout accout, double depositAmount) {
        this.name = name;
        this.accout = accout;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            accout.deposit(depositAmount);
        }
    }
}

public class 传统的线程通信 {
    public static void main(String[] args) {
        Accout act = new Accout("aaa", 0);
        new DrawThread("取钱者", act, 800).start();
        new DepositThread("存款者A", act, 800).start();
        new DepositThread("存款者B", act, 800).start();
        new DepositThread("存款者C", act, 800).start();
    }
}
