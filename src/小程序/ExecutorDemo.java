package 小程序;

/**
 * Created by liyanzhen on 17/7/6.
 */

class A {
    static A aa = new A();

    int j = 7;

    {
        System.out.println("A ---> 父类代码块" + i + "---->" + j);
    }

    static {
        System.out.println("A ---> 父类静态块");
    }


    A() {
        System.out.println("A ---> 父类构造器 " + i + "---->" + j);
    }

    public static void print() {
        System.out.println("A ---> 父类静态函数 --->" + i);
    }

    public void printNormal() {
        System.out.println("A ---> 父类普通方法 --->" + i + "---->" + j);
    }

    static int i = 6;
    static int k = 8;
}

class B extends A {
    static int i = 10;
    int j = 11;
    static int k = 1;

    {
        System.out.println("B ---> 子类代码块" + i + "---->" + j);
    }

    static {
        System.out.println("B ---> 子类静态块" + i + "---->");
    }

    B() {
        System.out.println("B ---> 子类构造器" + i + "---->" + j);
    }

    public static void print() {
        System.out.println("B ---> 子类静态函数" + i);
    }

    public void printNormal() {
        System.out.println("B ---> 子类普通方法 --->" + i + "---->" + j);
    }
}

public class ExecutorDemo {
    public static void main(String[] args) {
        A a = new A();
//        B b = new B();
//        b.printNormal();
//        a.printNormal();
//        System.out.println(B.k);
//        System.out.println(A.k);
    }
}
