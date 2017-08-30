package 搜狐;

import 阿里.Template;

import java.util.Scanner;

public class Kolakoski序列 {
    public static void main(String[] args) {
        Scanner in = Template.getScanner("./公司真题/src/搜狐/input.txt");
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = in.nextInt();
            }
            solve(n, m, arr);
            System.out.println();
        }
    }

    public static void solve(int n, int m, int[] arr) {
        if (arr == null || arr.length < 1 || m < 1) {
            return;
        }
        int[] result = new int[n];
        int index_arr = 0;

        //保存值而已，下面会覆盖
        //大于2时，res前面都是arr[0]
        if (arr[0] == 1) {
            result[0] = arr[0];
            result[1] = arr[1];
        } else {
            result[0] = arr[0];
            result[1] = arr[0];
        }

        //  index_arr保存arr[]的指针
        //  index保存res的指针
        //  count表示每个重复次数计数
        //  num当前填充的值
        for (int i = 0, index = 0; index < n; i++) {
            int num = arr[index_arr++];
            if (index_arr == arr.length) {
                index_arr = 0;
            }
            for (int count = 0; count < result[i] && index < n; count++) {
                result[index++] = num;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
