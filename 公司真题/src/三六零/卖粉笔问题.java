package 三六零;

import 华为.ScannerHelper;

import java.util.Scanner;

/**
 * <p>
 * 有彩色粉笔 n 个；
 * 有白色粉笔 m 个；
 * 把 a 个彩色粉笔盒 b 个白色粉笔打包可以买 x 元：（a彩 + b白） -> x元
 * 把 c 个白色粉笔打包可以卖 y 元： c白 -> y元
 * 把 d 个彩色粉笔打包可以卖 z 元： d 彩 -> z元
 * <p>
 * 用例
 * 输入：
 * 0 5
 * 2 1 3 3
 * 3 2 1
 * 输出：
 * 2
 */
public class 卖粉笔问题 {
    public static void main(String[] args) {
        Scanner s = ScannerHelper.getScanner("./公司真题/src/三六零/input.txt");
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int m = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            int d = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            int z = s.nextInt();
            System.out.println(max(n, m, a, b, c, d, x, y, z));
        }
    }

    public static int max(int n, int m, int a, int b, int c, int d, int x, int y, int z) {
        int i = 0;//混搭盒数
        int res = 0;
        while (i * a <= n && i * b <= m) {
            int temp = 0;
            temp += i * x;
            temp += (n - i * a) / d * z;
            temp += (m - i * b) / c * y;
            if (temp > res) {
                res = temp;
            }
            i++;
        }
        return res;
    }
}
