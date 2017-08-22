package 小程序;

/**
 * Created by liyanzhen on 17/7/6.
 */
class Dog1 {

    public Dog1() {
        System.out.println("父类的构造函数");
    }

    static {
        System.out.println("父类的静态代码块");
    }

    {
        System.out.println("父类的非静态代码块");
    }
}

public class Mastiff1 extends Dog1 {

    public Mastiff1() {
        System.out.println("子类的构造函数");
    }

    {
        System.out.println("子类的非静态代码块");

    }

    static {
        System.out.println("子类的静态代码块");
    }


    public static void main(String[] args) {
        Mastiff1 mastiff = new Mastiff1();
        Mastiff1 mastiff1 = new Mastiff1();
    }
}
