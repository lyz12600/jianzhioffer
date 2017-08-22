package 动态规划;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/7/1.
 */
public class 拼凑钱币 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            System.out.println(getCount(n));
        }
    }

    public static long getCount(int n) {
        int[] arr = {1, 5, 10, 50, 100};
        long[][] count = new long[arr.length][n + 1];
        //由1组成的只有一种
        Arrays.fill(count[0], 1);

        for (int i = 1; i < arr.length; i++) { //几种币种
            for (int j = 1; j <= n; j++) { //钱数
                for (int k = 0; k <= j / arr[i]; k++) { //多张组成
                    count[i][j] += count[i - 1][j - k * arr[i]];
                }
            }
        }

        /**
         * 打印结果
         */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.format("%-10d", count[i][j]);
            }
            System.out.println();
        }

        return count[arr.length - 1][n];
    }
}
