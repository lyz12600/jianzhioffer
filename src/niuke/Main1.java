package niuke;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/3/23.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int count = caculate(a, b, c);
            System.out.println(count);
        }
    }

    private static int caculate(int a, int b, int c) {
        int count = 0;
        if (b % 2 == 0) {
            int index = b / 2;
            for (int i = 1; i <= index; i++) {
                count *= a;
            }
            return count;
        } else {
            for (int i = b; i > 1; i--) {
                count = a * i;
            }

            for (int i = a-b; i >=1; i--) {
                count = count/i;
            }
            return count;
        }
    }
}
