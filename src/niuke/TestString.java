package niuke;

/**
 * Created by liyanzhen on 16/10/28.
 */
public class TestString {
    public static void main(String args[]) {
        String s1 = new String("abc");
        s1.intern();
        String s2 = "abc";
        System.out.println(s1 == s2);
    }

}
