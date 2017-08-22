package chapterone;

import java.io.FileOutputStream;
import java.util.HashSet;

/**
 * Created by liyanzhen on 17/6/26.
 */
public class InterruptedDemo {
    public static void main(String[] args) throws Exception {
        InterruptedThread it = new InterruptedThread();
        it.start();
        Thread.sleep(1000);
        it.interrupt();
        FileOutputStream fis = new FileOutputStream("out.txt");
//        Thread.currentThread().interrupt();
        fis.write(it.interrupted() ? "true".getBytes() : "flase".getBytes());
        fis.write(it.interrupted() ? "true".getBytes() : "flase".getBytes());
        fis.flush();
        fis.close();
    }
}

class InterruptedThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + (i + 1));
        }
    }
}

