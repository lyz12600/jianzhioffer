package leetcode.回文;

import java.util.Scanner;

/**
 * 如果一个数字从左边读和从右边读一样，那么这个数字就是一个回文数。
 * 例如32123就是一个回文数；17在某种意义上也是一个回文数，因为它的二进制型式——10001——是一个回文数。
 * 请你帮忙开发一个程序，判断一个数n在任意进制（2-16）下是否有回文数。
 * <p>
 * Created by liyanzhen on 17/7/16.
 */
public class 进制回文数 {
    private static char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int num = s.nextInt();
            if (num < 1 || num > Integer.MAX_VALUE) {
                return;
            }
            if (isExistPalindromeNumber(num)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean isExistPalindromeNumber(int num) {
        for (int i = 2; i <= 16; i++) {
            String str = product(num, i);
            if (isPalindromeNumber(str)) {
                return true;
            }
        }
        return false;
    }

    public static String product(int num, int target) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(arr[num % target]);
            num /= target;
        }
        return sb.reverse().toString();
    }

    public static boolean isPalindromeNumber(String str) {
        if (str == null || str.length() < 1) {
            return false;
        }
        StringBuilder sb = new StringBuilder(str).reverse();
        if (sb.toString().equals(str)) {
            return true;
        }
        return false;
    }
}
