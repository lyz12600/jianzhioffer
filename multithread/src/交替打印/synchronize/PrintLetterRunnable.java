package 交替打印.synchronize;

/**
 * Created by liyanzhen on 17/6/22.
 */
public class PrintLetterRunnable implements Runnable {
    private SyncObj syncObj;
    private char letter;

    public PrintLetterRunnable(SyncObj syncObj, char letter) {
        this.syncObj = syncObj;
        this.letter = letter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (syncObj) {
                /**
                 * 如果当前线程的字符和同步对象的字符不一致，则当前线程一直等待
                 */
                while (letter != syncObj.getLetter()) {
                    try {
                        syncObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                /**
                 * 输出当前线程的字符
                 */
                System.out.println(letter);
                /**
                 * 改变同步对象的letter值
                 */
                syncObj.nextLetter();
                /**
                 * 通知其它所有等待线程
                 */
                syncObj.notifyAll();
            }
        }
    }
}
