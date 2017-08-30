package 今日头条;

/**
 * 输入：
 * 3
 * 6 2 1
 * 输出：
 * 36
 * 计算过程：
 * ［6］＝ 6 ＊ 6 ＝ 36；
 * ［2］＝ 2 ＊ 2 ＝ 4；
 * ［1］＝ 1 ＊ 1 ＝ 1；
 * ［6，2］＝ 2 ＊ 8 ＝ 16；
 * ［2，1］＝ 1 ＊3 ＝ 3；
 * ［6，2，1］＝ 1 ＊ 9 ＝ 9；
 */

import java.util.Scanner;

public class 顺序组合后计算 {
    static int max;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println(max(arr));
        }
    }

    public static int max(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        max = 0;
        for (int i = 1; i <= arr.length; i++) {
            combine(arr, i);
        }
        return max;
    }

    public static void combine(int[] arr, int n) {
        int i = 0;
        int j = 0;
        int temp = 0;
        if (n == 1) {//为一位时两个数相乘
            for (int k = 0; k < arr.length; k++) {
                max = max > arr[k] * arr[k] ? max : arr[k] * arr[k];
            }
        } else {//多位计算
            while (i <= arr.length - n) {//从当前节点开始计算n位
                j = 0;
                for (; j < n; j++) {//n位计算
                    temp += arr[j];
                    System.out.print(arr[j] + " ");
                }
                temp *= arr[j - 1];
                max = max > temp ? max : temp;
                i++;
            }
        }
        System.out.println();
    }
}
