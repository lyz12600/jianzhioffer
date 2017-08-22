package niuke;

/**
 * Created by liyanzhen on 17/2/23.
 */
public class ByteDemo02 {
    public static void add(Byte b) {
        b = b++;
    }

    public static void main(String args[]) {
        Byte a = 127;
        Byte b = 127;

        add(++a);
        System.out.println(a + " ");
        add(b);
        System.out.println(b + " ");
    }
}
