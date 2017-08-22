package 线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by liyanzhen on 17/7/26.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newCachedThreadPool();//
        ExecutorService pool = Executors.newFixedThreadPool(2);//
//        ExecutorService pool = Executors.newSingleThreadExecutor();//
//        ExecutorService pool = Executors.newScheduledThreadPool(1);//
//        ExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        Runnable target = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "的值为：" + i);
            }
        };

        pool.submit(target);
        pool.submit(target);
        pool.shutdown();
    }
}
