package bishi;

public class Test {
    public static void main(String args[]) {
        new Thread(new Didi()).start();
        new Thread(new Gege()).start();
    }
}

class Didi implements Runnable {
    private int time = 0;

    @Override
    public void run() {
        for (int i = 100; i < 1000; i += 4) {
            System.out.println("弟弟：" + i + "------>" + time);
            if ((i - 100) != 0 && (i - 100) % 80 == 0) {
                time += 4;
            } else {
                time++;
            }
        }
    }
}

class Gege implements Runnable {
    private int time = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i += 5) {
            System.out.println("哥哥：" + i + "------>" + time);
            if (i != 0 && i % 80 == 0) {
                time += 4;
            } else {
                time++;
            }
        }
    }
}