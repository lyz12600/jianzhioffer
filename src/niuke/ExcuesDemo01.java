package niuke;

/**
 * Created by liyanzhen on 17/3/12.
 */
public class ExcuesDemo01 {
    public int add(int a, int b) {
        try {
            return a + b;
        } catch (Exception e) {
            System.out.println("catch语句块");
        } finally {
            System.out.println("finally语句块");
        }
        return 0;
    }

    public static void main(String args[]) {
        ExcuesDemo01 excuesDemo01 = new ExcuesDemo01();
        System.out.println("和是：" + excuesDemo01.add(9, 34));
    }
}
