package 异常;

/**
 * Created by liyanzhen on 17/7/16.
 */
public class TestException2 {
    public static void main(String args[]) {
        int i = 0;
        String greetings[] = {" Hello world !", " Hello World !! ", " HELLO WORLD !!!"};
        while (i < 4) {
            try {
                System.out.println(greetings[i++]);
//                i++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("数组下标越界异常");
            } finally {
                System.out.println("--------------------------");
            }
        }
    }
}
