package 阿里;

import java.util.Scanner;

public class 从出发到指定公用多少步 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int start = s.nextInt();
            int end = s.nextInt();
            int step = s.nextInt();
            System.out.println(solve(n, start, end, step));
        }
    }

    public static int solve(int n, int start, int end, int step) {
        if (n <= 1 || start < 1 || start > n || end < 0 || end > n || step < 1) {
            return 0;
        }

        int[][][] dp = new int[n][n][step];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = Math.abs(i - j) == 1 ? 1 : 0;
            }
        }


        for (int k = 1; k < step; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0) {
                        dp[i][j][k] = dp[i][j + 1][k - 1];
                    } else if (j == n - 1) {
                        dp[i][j][k] = dp[i][j - 1][k - 1];
                    } else {
                        dp[i][j][k] = dp[i][j - 1][k - 1] + dp[i][j + 1][k - 1];
                    }
                }
            }

        }
        return dp[start - 1][end - 1][step - 1];
    }
}