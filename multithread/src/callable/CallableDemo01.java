package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by liyanzhen on 17/6/20.
 */
public class CallableDemo01 {
    public static void main(String args[]) {
        CallableDemo01 c = new CallableDemo01();
        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>) () -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "----->" + i);
            }
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----->" + i);
            if (i == 20) {
                new Thread(task, "有返回值的线程1").start();
                new Thread(task, "有返回值的线程2").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + task.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}