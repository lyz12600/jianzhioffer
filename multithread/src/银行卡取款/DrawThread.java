package 银行卡取款;

/**
 * Created by liyanzhen on 17/6/23.
 */
public class DrawThread extends Thread {
    private Account account;
    private double drawAmount;

    public DrawThread(String name, Account a, double amount) {
        super(name);
        account = a;
        drawAmount = amount;
    }

    @Override
    public void run() {
        synchronized (account) {
            if (account.getBalance() >= drawAmount) {
                System.out.println(getName() + "取钱成功,取钞：" + drawAmount);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("余额为：" + account.getBalance());
            } else {
                System.out.println(getName() + "余额不足!");
            }
        }
//        account.draw(drawAmount);
    }
}
