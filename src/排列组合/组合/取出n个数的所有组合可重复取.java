package 排列组合.组合;

import java.util.Arrays;

/**
 * 如a={1,2,3}。当n=2时候的所有组合数为11,12,13,22,23,33
 */
public class 取出n个数的所有组合可重复取 {
    public static void main(String[] args) {
        取出n个数的所有组合可重复取 test = new 取出n个数的所有组合可重复取();
        int[] arr = {1, 2, 3, 4};
        int n = 2;
        test.solve(arr, n);
    }

    public static void solve(int[] arr, int n) {
        if (arr == null || arr.length < 1 || n < 1) {
            return;
        }
        Arrays.sort(arr);
        int[] brr = new int[n];
        combine(arr, brr, n, 0);
    }

    public static void combine(int[] arr, int[] brr, int n, int index) {
        if (n == 0) {
            for (int i = 0; i < index; i++) {
                System.out.print(brr[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (index == 0 || arr[i] >= brr[index - 1]) {
                brr[index] = arr[i];
                combine(arr, brr, n - 1, index + 1);
            }
        }
    }
}
