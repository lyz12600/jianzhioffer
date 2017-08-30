package api.string;

public class StringDemo {
    public static void main(String[] args) {
//        String a = "abc";
//        String b = "abc";
//        String c = a;
//        System.out.println(a == b);
//        System.out.println(a == c);
//        System.out.println(b == c);
//        System.out.println("================");
//        a = "abcd";
//        System.out.println("a" + " " + a);
//        System.out.println("b" + " " + b);
//        System.out.println("c" + " " + c);
//        System.out.println(a == b);
//        System.out.println(a == c);
//        System.out.println(b == c);
//
//
//        /***
//         *
//         */
//        String aa = new String("ab");
//        String bb = new String("ab");
//        String cc = "ab";
//        String dd = "a" + "b";
//        String ee = "b";
//        String ff = "a" + ee;
//        System.out.println(bb.intern() == aa);
//        System.out.println(bb.intern() == cc);
//        System.out.println(bb.intern() == dd);
//        System.out.println(bb.intern() == ff);
//        System.out.println(bb.intern() == aa.intern());
//        System.out.println("=========================");
//
//        /**
//         * 对于被final修饰的变量，会在class文件常量池中保存一个副本，
//         * 也就是说不会通过连接而进行访问，对final变量的访问在编译期间都会直接被替代为真实的值。
//         * 那么String c = b + 2;在编译期间就会被优化成：String c = "hello" + 2。
//         */
//        String aaa = "hello12";
//        final String bbb = "hello1";
//        String ccc = bbb + 2;
//        System.out.println(aaa == ccc);
//        System.out.println("===============");
//
//        /**
//         * 输出结果为false。这里面虽然将b用final修饰了，
//         * 但是由于其赋值是通过方法调用返回的，那么它的值只能在运行期间确定，
//         * 因此a和c指向的不是同一个对象。
//         */
//        String a = "hello2";
//        final String b = getHello();
//        String c = b + 2;
//        System.out.println((a == c));
//    }
//

        /**
         * 这里面涉及到的是String.intern方法的使用。
         * 在String类中，intern方法是一个本地方法，在JAVA SE6之前，
         * intern方法会在运行时常量池中查找是否存在内容相同的字符串，
         * 如果存在则返回指向该字符串的引用，如果不存在，则会将该字符串入池，
         * 并返回一个指向该字符串的引用。因此，a和d指向的是同一个对象。
         */
        String a = "hello";
        String b = new String("hello");
        String c = new String("hello");
        String d = b.intern();

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(b == d);
        System.out.println(a == d);
    }
//    public static String getHello() {
//        return "hello";
//    }
}
