package JVM.chaptertwo;

/**
 * Created by liyanzhen on 17/1/7.
 * String.intern()返回引用的测试---P57
 */
public class RuntimeConstantPoolOOMIntern {
    public static void main(String args[]) {
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);
        String s1 = new String("1");
        s1 = s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
