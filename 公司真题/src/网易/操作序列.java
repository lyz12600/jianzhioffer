package 网易;

import java.util.Scanner;

public class 操作序列 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            int[] res = solve(n, arr);
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    System.out.print(res[i]);
                } else {
                    System.out.print(res[i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static int[] solve(int n, int[] arr) {
        int[] res = new int[n];
        if (n < 2 || arr == null || arr.length < 1) {
            return res;
        }

        boolean flag;//是否是偶数
        if (n % 2 == 0) {
            flag = true;
        } else {
            flag = false;
        }


        if (flag) {
            int left = (n - 1) / 2;
            int right = (n - 1) / 2 + 2;
            res[(n - 1) / 2 + 1] = arr[0];
            for (int i = 1; i < n; i++) {
                if (flag) {
                    res[left] = arr[i];
                    flag = false;
                    left--;
                } else {
                    res[right] = arr[i];
                    flag = true;
                    right++;
                }
            }
        } else {
            res[(n - 1) / 2] = arr[0];
            int left = (n - 1) / 2 - 1;
            int right = (n - 1) / 2 + 1;
            for (int i = 1; i < n; i++) {
                if (!flag) {
                    res[right] = arr[i];
                    flag = true;
                    right++;
                } else {
                    res[left] = arr[i];
                    flag = false;
                    left--;
                }
            }
        }
        return res;
    }
}