package 交替打印.atomicinteger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liyanzhen on 17/6/22.
 */
public class AtomicIntegerExample {
    private AtomicInteger sycValue = new AtomicInteger(0);
    private static final int MAX_SYC_VALUE = 3 * 10;

    public static void main(String args[]) {
        AtomicIntegerExample example = new AtomicIntegerExample();
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(example.new RunnableA());
        service.execute(example.new RunnableB());
        service.execute(example.new RunnableC());

        service.shutdown();
    }

    private class RunnableA implements Runnable {

        @Override
        public void run() {
            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 0) {
                    System.out.print("A");
                    sycValue.getAndIncrement();
                }
            }
        }
    }

    private class RunnableB implements Runnable {

        @Override
        public void run() {
            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 1) {
                    System.out.print("B");
                    sycValue.getAndIncrement();
                }
            }
        }
    }

    private class RunnableC implements Runnable {

        @Override
        public void run() {
            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 2) {
                    System.out.print("C");
                    sycValue.getAndIncrement();
                }
            }
        }
    }
}
