package 小程序;

class SuperClass {
    public SuperClass() {
        System.out.println("SuperClass Constructor");
    }

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }

    public SubClass() {
        System.out.println("SubClass Constructor");
    }
}

public class InitTest {
    public static void main(String[] args) {
        //初始化变量所在类
//        System.out.println(SubClass.value);

        //通过数组定义来引用类，不会触发此类的初始化
        SuperClass[] sca = new SuperClass[10];
    }
}
