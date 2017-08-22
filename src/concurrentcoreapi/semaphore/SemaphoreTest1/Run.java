package concurrentcoreapi.semaphore.SemaphoreTest1;

/**
 * Created by liyanzhen on 17/6/6.
 * semaphore的同步性
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(service);
        threadB.setName("B");
        ThreadC threadC = new ThreadC(service);
        threadC.setName("C");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
