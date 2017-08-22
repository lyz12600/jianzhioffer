package process;

/**
 * Created by liyanzhen on 17/1/12.
 */
public class StartDead extends Thread {
    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + "------" + i);
        }
    }

    public static void main(String args[]) {
        StartDead startDead = new StartDead();
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "********" + i);
            if (i == 20){
                startDead.start();
                System.out.println(startDead.isAlive());
            }

//            if (i > 20 && !startDead.isAlive()){
//                startDead.start();
//            }
        }
    }
}
