package niuke;

/**
 * Created by liyanzhen on 16/10/20.
 */
public class ByteDemo {
    public static void main(String[] args) {
        byte b1 = 1, b2 = 2, b3, b6;
        final byte b4 = 4, b5 = 6;

        b6 = b4 + b5;
        int n = b1 + b2;
        b3 = (byte) (b1 + b2);//byte、short、char进行计算时会转化为int型
        System.out.println(b6 + "&&&" + b3);
    }
}
