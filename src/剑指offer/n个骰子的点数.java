package 剑指offer;

import java.util.Scanner;

/**
 * 面试题：43
 * n个骰子的点数
 * Created by liyanzhen on 17/6/15.
 */
public class n个骰子的点数 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            int s = scanner.nextInt();
//            方法一：递归
            if (n < 1 || s < 1)
                return;
            int[] arr = new int[n * 5 + 1];
            calculate1(arr, n, n, 0);
            int total = 0;
            for (int i = 0; i < arr.length; i++) {
                total += arr[i];
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.println("和为" + (i + n) + "出现的概率为：" + arr[i] + "/" + total);
            }

//            方法二：
            calculate2(n);
        }
    }

    /**
     * 方法一：基于递归
     *
     * @param arr       保存对应和可能产生的次数
     * @param restCount 剩余骰子数
     * @param curSum    当前的和
     */
    private static void calculate1(int[] arr, int n, int restCount, int curSum) {
        if (restCount == 0) {
            arr[curSum - n]++;
            return;
        }

        for (int i = 1; i <= 6; i++) {
            calculate1(arr, n, restCount - 1, curSum + i);
        }
    }

    /**
     * 方法二：基于循环
     *
     * @param n
     */
    private static void calculate2(int n) {
        if (n < 1)
            return;
        int[][] arr = new int[2][6 * n + 1];

        int flag = 0;
        for (int i = 1; i <= 6; i++) {
            arr[flag][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++)
                arr[1 - flag][j] = 0;

            for (int j = i; j <= 6 * i; j++) {
                arr[1 - flag][j] = 0;
                for (int k = 1; k <= j && k <= 6; k++)
                    arr[1 - flag][j] += arr[flag][j - k];
            }
            flag = 1 - flag;
        }

        int total = (int) Math.pow(6, n);
        for (int i = n; i <= 6 * n; i++) {
            System.out.println("和为" + i + "的概率为：" + arr[flag][i] + "/" + total);
        }
    }
}
