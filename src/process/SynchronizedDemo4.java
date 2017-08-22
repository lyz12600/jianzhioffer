package process;

/**
 * Created by liyanzhen on 17/3/18.
 */
public class SynchronizedDemo4 {
    public static void main(String[] args) {
        InsertData insertData = new InsertData();
        new Thread() {
            @Override
            public void run() {
                insertData.insert();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                insertData.insert1();
            }
        }.start();
    }
}

class InsertData {
    public synchronized static void insert() {
        System.out.println("执行insert");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行insert完毕");
    }

    public static void insert1() {
        System.out.println("执行insert1");
        System.out.println("执行insert1完毕");
    }
}
