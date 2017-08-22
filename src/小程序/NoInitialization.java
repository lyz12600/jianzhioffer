package 小程序;

class ConstClass {
    static {
        System.out.println("ConstClass");
    }

    //编译阶段存储到了NoInitialization类的常量池中
    public static final String str = "Hello World";
}

public class NoInitialization {
    public static void main(String[] args) {
        System.out.println(ConstClass.str);
    }
}
