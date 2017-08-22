package chapterone.不推荐使用;

/**
 * Created by liyanzhen on 17/7/3.
 */
public class StopDemo {
    public static void main(String[] args) {
        SynchronizedObject object = new SynchronizedObject();
        PrintThread pt = new PrintThread(object);
        pt.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pt.stop();
        System.out.println(object.getUsername() + "----" + object.getPassword());
    }
}

class PrintThread extends Thread {
    SynchronizedObject object;

    public PrintThread(SynchronizedObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("bb", "bbb");
    }
}

class SynchronizedObject {
    private String username = "aa";
    private String password = "aaa";

    public synchronized void printString(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}