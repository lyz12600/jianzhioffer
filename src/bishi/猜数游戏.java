package bishi;

import aaa.Template;

import java.util.Scanner;

/**
 * 现在给出一个整数n,表示已给的提示的长度。请计算出长度为n的合法的提示的个数。
 * 例如 n = 5:
 * 合法的提示有:
 * YNNNN YNNNY YNYNN YNYNY YYNNN YYNNY
 * YYNYN YYNYY YYYNN YYYNY YYYYN YYYYY
 * 所以输出12
 * Created by liyanzhen on 17/3/25.
 */
public class 猜数游戏 {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/bishi/input.txt");
//        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            System.out.println(maxLength(n));
        }
    }

    public static long maxLength(int n) {
        if (n < 1 && n > Math.pow(10, 6)) {
            return -1;
        }
        long count = 1;
        int[] arr = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            int index = 0;
            if (arr[i] == 1) {
                continue;
            }
            for (int j = i + i; j < n + 1; j += i) {
                arr[j] = 1;
            }

            long temp = i;
            while (temp < n + 1) {
                index++;
                temp *= i;
            }
            count = count * (index + 1) % 1000000007;
        }
        return count;
    }
}
