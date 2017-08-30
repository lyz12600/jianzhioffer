package api.string;

public class StringTest {
    private static String staticStr = "Hello";
    private String memberStr = "Hello";

    public void sayHello() {
        String methodStr = "Hello";
        System.out.println("sayHello memberStr---->" + memberStr.hashCode());
        System.out.println("sayHello methodStr---->" + methodStr.hashCode());
    }

    public static void main(String[] args) {
        StringTest t = new StringTest();
        t.sayHello();
        String threadStr = "Hello";
        System.out.println("t.memberStr----->" + t.memberStr.hashCode());
        System.out.println("threadStr----->" + threadStr.hashCode());
        System.out.println("staticStr----->" + staticStr.hashCode());
    }
}
