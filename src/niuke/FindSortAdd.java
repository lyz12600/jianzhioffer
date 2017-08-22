package niuke;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/3/8.
 */
public class FindSortAdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;
        while (in.hasNextInt()) {//注意while处理多个case
            a = in.nextInt();
            b = in.nextInt();
            findSortNum(a, b);
             System.out.println("\n");
        }

    }

    public static void findSortNum(int n, int l) {
        int min = 0, count = 0, sum = 0, position = 0;
        if (n < 1 | n > 1000000000) {
            System.out.println("No");
            return;
        }
        if (l < 2 | l > 100) {
            System.out.println("No");
            return;
        }

        for (int i = l; min < 100 && i < n; i++) {
            int j = i;
            sum = 0;
            count = 0;
            while (sum < n) {
                count++;
                sum += j;
                j++;
                if (sum == n) {
                    if (min == 0) {
                        min = count;
                        position = i;
                    }
                    if (min > count) {
                        min = count;
                        position = i;
                    }
                }
            }
        }

        for (int z = position; min > 0; z++) {
            min--;
            System.out.print(z + " ");
        }
    }
}
