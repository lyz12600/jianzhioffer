package leetcode.回文;

import java.util.Scanner;

/**
 * 回文數(或迴文數)是指一个像16461这样“对称”的数，
 * 即：将这个数的数字按相反的顺序重新排列后，所得到的数和原来的数一样。
 * <p>
 * Created by liyanzhen on 17/7/16.
 */
public class 回文数 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int num = s.nextInt();
            System.out.println(isPalindromeNumber(num));
        }
    }

    public static boolean isPalindromeNumber(int x) {
        if (x < 0) {
            return false;
        }

        /**
         * 此方法是翻转值后比较
         * 该做法欠缺翻转后溢出情况
         */
//        int a = x, r = 0;
//        while (a > 0) {
//            r = r * 10 + a % 10;
//            a = a / 10;
//        }
//        return r == x;


        /**
         * 此方法是通过截头截尾来比较
         * 防止溢出
         */
        int a = x, h = 1;

        while (a / h >= 10) { //计算有多少位
            h = h * 10;
        }

        while (a > 0) {
            if (a % 10 != a / h) { //首尾不等退出
                return false;
            }
            a = a % h; //去头
            a = a / 10;//去尾
            h /= 100; //位数减2
        }
        return true;
    }
}
