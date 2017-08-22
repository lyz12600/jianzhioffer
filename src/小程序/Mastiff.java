package 小程序;

/**
 * Created by liyanzhen on 17/7/6.
 */

class Dog {
    public Dog() {
        System.out.println("父类的构造函数");
    }
}

public class Mastiff extends Dog {

    public Mastiff() {
        System.out.println("子类的构造函数");
    }

    {
        System.out.println("子类的非静态代码块");
    }

    static {
        System.out.println("子类的静态代码块");
    }

    public static void main(String[] args) {
        Mastiff mastiff = new Mastiff();
    }
}