package xiaoxiang.各种整除;

import java.util.Scanner;

/**
 * 给定某个正整数N,若为偶数，则N被更新为N/2，否则N被更新为3*N＋1，经过多少步N变成1
 * Created by liyanzhen on 17/6/29.
 */
public class 三N加一猜想 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            System.out.println(collatz(n));
        }
    }

    public static int collatz(int n) {
        int count = 0;
        while (n != 1) {
            if (n == 1) {
                System.out.println("n--->" + n + "count---->" + count);
                return count;
            } else if (n % 2 == 0) {
                count++;
                System.out.println("n--->" + n + "count---->" + count);
                n = n >> 1;
            } else {
                count++;
                System.out.println("n--->" + n + "count---->" + count);
                n = 3 * n + 1;
            }
        }
        return count;
    }
}