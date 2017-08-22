package synchronize;

/**
 *
 * Created by liyanzhen on 17/5/5.
 */
public class CrossPrint {

    public static void main(String[] args) {
        Service service = new Service();
        new Thread(new Customer(service)).start();
        new Thread(new Productor(service)).start();
    }
}


class Service extends  Thread {
    private Object lock = new Object();

    public void printA() {
        synchronized (lock) {
            System.out.println("A");
            lock.notify();
            try {
                lock.wait(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (lock) {
            System.out.println("B");
            lock.notify();
            try {
                lock.wait(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer implements Runnable {

    private Service service;

    Customer(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            service.printA();
        }
    }
}

class Productor implements Runnable {
    private Service service;

    Productor(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            service.printB();
        }
    }
}
