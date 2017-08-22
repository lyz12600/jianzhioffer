package ImportNew.concurrency;

/**
 * Created by liyanzhen on 17/6/20.
 */
public class Child extends Father {
    @Override
    public synchronized void doSomething() {
        super.doSomething();
        System.out.println("child");
    }

    public static void main(String[] args) {
        Child c = new Child();
        new Thread(new Runnable() {
            @Override
            public void run() {
                c.doSomething();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                c.doSomething();
            }
        }).start();
    }
}

class Father {
    public synchronized void doSomething() {
        System.out.println("father");
    }
}
