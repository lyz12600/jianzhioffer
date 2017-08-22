package process;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by liyanzhen on 17/1/11.
 */
public class ThirdThread {
    public static void main(String args[]){
        ThirdThread t = new ThirdThread();
        FutureTask<Integer> task;
//        task = new FutureTask<Integer>((Callable<Integer>)() ->{
//                int i = 0;
//                for ( ; i < 100 ; i++){
//                    System.out.println(Thread.currentThread().getName() + "------" + i);
//                }
//                return i;
//        });

        task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int i = 0;
                for (;i<100;i++){
                    System.out.println(Thread.currentThread().getName() + "------" + i);
                }
                return i;
            }
        });

        for (int i = 0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + "******" + i);
            if (i == 20){
                new Thread(task,"miracle").start();
            }
        }


        try{
            System.out.println("子线程返回值：" + task.get());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
