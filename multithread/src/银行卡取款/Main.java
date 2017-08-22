package 银行卡取款;

/**
 * Created by liyanzhen on 17/6/23.
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account("1234567", 1000);

        new DrawThread("甲", account, 800).start();
        new DrawThread("乙", account, 600).start();
    }
}
