package niuke;

/**
 * Created by liyanzhen on 17/2/24.
 */
public class ArrayDemo {
    public static void main(String[] args) {
        String[] a = {"1", "2", "2", "5", "4", "5", "3", "7"};
        for (String b : a) {
            if (b == "5") {
                break; //最后输出1,2,2
                //return;//最后输出1,2,2
                //continue;//最后输出1,2,2,4,3,7
            } else {
                System.out.println(b);
            }
        }
    }
}
