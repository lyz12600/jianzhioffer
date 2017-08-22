package ImportNew;

/**
 * 参考链接：http://www.importnew.com/19472.html
 * A. a.method1() vs. a.method2() 不可以
 * B. a.method1() vs. b.method1() 可以
 * C. a.method3() vs. b.method4() 不可以
 * D. a.method3() vs. b.method3() 不可以
 * E. a.method1() vs. a.method3() 可以
 */

public class SynchronizedTest {
    public synchronized void method1() {
        System.out.println("========method1==========");
        for (int i = 0; i < 100; i++) {
            System.out.print("method1--->" + i + " ");
        }
    }

    public synchronized void method2() {
        System.out.println("==========method2========");
        for (int i = 0; i < 1000; i++) {
            System.out.print("method2--->" + i + " ");
        }
    }

    public static synchronized void method3() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println("method3");
    }

    public static synchronized void method4() {
        System.out.println("static method4");
    }

    public static void main(String args[]) {
        SynchronizedTest a = new SynchronizedTest();
        SynchronizedTest b = new SynchronizedTest();
        new Thread(() -> {
            a.method1();
            System.out.println("thread 1");
        }).start();

        new Thread(() -> {
            a.method3();
            System.out.println("thread 2");
        }).start();
    }
}
