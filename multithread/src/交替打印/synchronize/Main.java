package 交替打印.synchronize;

/**
 * Created by liyanzhen on 17/6/22.
 */
public class Main {
    public static void main(String[] args) {
        SyncObj syncObj = new SyncObj();
        Thread threadA = new Thread(new PrintLetterRunnable(syncObj, 'A'));
        Thread threadB = new Thread(new PrintLetterRunnable(syncObj, 'B'));
        Thread threadC = new Thread(new PrintLetterRunnable(syncObj, 'C'));

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
