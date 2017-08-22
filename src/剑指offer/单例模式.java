package 剑指offer;

/**
 * Created by liyanzhen on 17/3/7.
 * 设计一个类只能生成该类的实例
 * 实现Singleton模式
 * 各种单例模式
 */
public class 单例模式 {
    public static void main(String[] args) {
    }
}

/**
 * 双重检验锁式
 */
class Singleton1 {
    private volatile static Singleton1 singleton;//禁止指令重排

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (singleton == null) {
            synchronized (Singleton1.class) {
                if (singleton == null) {
                    singleton = new Singleton1();
                }
            }
        }
        return singleton;
    }
}

/**
 * 饿汉式
 */
class Singleton2 {
    private static final Singleton2 singleton2 = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return singleton2;
    }
}

/**
 * 懒汉式
 */
class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {
    }

    public static synchronized Singleton3 getInstance() {
        if (singleton3 == null) {
            return new Singleton3();
        }
        return singleton3;
    }
}

/**
 * 内部类式 推荐
 */
class Singleton4 {
    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4() {
    }

    public static final Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

/**
 * 枚举类式
 */
enum Singleton5 {
    INSTANCE;
}