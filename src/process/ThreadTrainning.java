package process;

import java.util.Random;

/**
 * Created by liyanzhen on 17/3/17.
 */

class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }
}

public class ThreadTrainning {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.run();
        t2.run();
    }
}
