package bishi;

import java.util.Queue;

/**
 * Created by liyanzhen on 17/3/24.
 * <p>
 * 有三个线程分别打印a,b,c,d
 * 请用多线程编程实现，在屏幕上循环打印15次
 */
public class PrintThread01 {
    public static void main(String args[]) {
        SyncObj syncObj = new SyncObj();
        Thread threadA = new Thread(new PrintLetterRunnable('a', syncObj));
        Thread threadB = new Thread(new PrintLetterRunnable('b', syncObj));
        Thread threadC = new Thread(new PrintLetterRunnable('c', syncObj));
        Thread threadD = new Thread(new PrintLetterRunnable('d', syncObj));

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}

class SyncObj {
    private char letter = 'a';

    public void nextLetter() {
        switch (letter) {
            case 'a':
                letter = 'b';
                break;
            case 'b':
                letter = 'c';
                break;
            case 'c':
                letter = 'd';
                break;
            case 'd':
                letter = 'a';
                break;
            default:
                break;
        }
    }

    public char getLetter() {
        return letter;
    }
}

class PrintLetterRunnable implements Runnable {

    private char letter ;
    private SyncObj syncObj;

    public PrintLetterRunnable(char letter, SyncObj syncObj) {
        this.letter = letter;
        this.syncObj = syncObj;
    }
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            synchronized(syncObj){
                while (letter != syncObj.getLetter()){
                    try {
                        syncObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(letter);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                syncObj.nextLetter();
                syncObj.notifyAll();
            }
        }
    }
}