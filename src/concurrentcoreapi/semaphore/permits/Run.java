package concurrentcoreapi.semaphore.permits;

/**
 * Created by liyanzhen on 17/6/7.
 */
public class Run {
    public static void main(String[] args) {
//        ServiceAvailablePermits myService = new ServiceAvailablePermits();
//        myService.testMethod();
        ServiceDrainPermits service = new ServiceDrainPermits();
        service.testMethod();
    }
}
