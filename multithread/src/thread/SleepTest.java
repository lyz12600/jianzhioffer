package thread;

import java.util.Date;

/**
 * Created by liyanzhen on 17/6/23.
 */
public class SleepTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前时间：" + new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
