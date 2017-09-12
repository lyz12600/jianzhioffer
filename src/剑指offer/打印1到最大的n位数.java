package 剑指offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 打印1到最大的n位数
 * Created by liyanzhen on 17/5/13.
 */
public class 打印1到最大的n位数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            char[] chars = new char[n];
            Arrays.fill(chars, '0');
            printMaxNumber(chars, 0, n);
        }
    }

    /**
     * 数字排列的方法
     */
    public static void printMaxNumber(char[] chars, int index, int n) {
        if (index == n) { //
            int i = 0;
            while (i < n && chars[i] == '0') {
                i++;
            }
            for (; i < n; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i <= 9; i++) {
            chars[index] = (char) (i + '0');
            printMaxNumber(chars, index + 1, n);
        }
    }
}
