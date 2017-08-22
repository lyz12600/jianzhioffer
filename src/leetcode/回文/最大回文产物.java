package leetcode.回文;

import java.util.Scanner;

/**
 * 找到由两个n位数字产生的最大的回文。
 * 由于结果可能非常大，
 * 您应该返回最大的回文mod 1337。
 * <p>
 * Created by liyanzhen on 17/7/17.
 */
public class 最大回文产物 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            System.out.println(largestPalindrome(n));
        }
    }


    public static int largestPalindrome(int n) {
        if (n < 1 || n > 8) {
            return -1;
        }

        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1;
        int min = max / 10;

        for (int i = max - 1; i > min; i--) {
            long sum = Long.parseLong(i + new StringBuilder().append(i).reverse().toString());//创造回文
            for (long j = max; j * j >= sum; j--) {
                if (sum % j == 0) {
                    return (int) (sum % 1337);
                }
            }
        }
        return 0;
    }
}
