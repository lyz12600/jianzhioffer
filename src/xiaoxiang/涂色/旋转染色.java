package xiaoxiang.涂色;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 红蓝两色染8个棋子，旋转染色
 * Created by liyanzhen on 17/6/29.
 */
public class 旋转染色 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            System.out.println(polva(n));
        }
    }

    public static int polva(int n) {
        int k1, k2;
        int m = 1 << n;
        int[] arr = new int[m];
        Arrays.fill(arr, 1);
        for (int i = 0; i < m; i++) {
            if (arr[i] == 1) {
                k1 = i;
                for (int j = 0; j <= n; j++) {
                    k2 = rotateShiftLeft(k1, n);
                    if (k2 == i)
                        break;
                    if (k2 > i)
                        arr[k2] = 0;
                    else {
                        arr[i] = 0;
                        break;
                    }
                    k1 = k2;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        return count;
    }


    /**
     * 循环左移一位
     * <p>
     * eg:
     * 11001001 左移7位得到最高位得到1
     * <p>
     * 11001001
     * 01111111两个相与得到后七位（01111111等于1左移7位-1）
     * <p>
     * 1001001<<1 再或high即可
     *
     * @param x 某个数
     * @param n n位数
     * @return
     */
    public static int rotateShiftLeft(int x, int n) {
        int high = (x >> (n - 1));
        x &= ((1 << (n - 1)) - 1);
        x <<= 1;
        x |= high;
        return x;
    }
}
