package bishi;

import java.util.Scanner;

/**
 * 庆祝六一
 * Created by liyanzhen on 17/6/16.
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println(maxBtChild(arr, n));
        }
    }

    public static int maxBtChild(int[] arr, int n) {
        int max = 0;
        for (int i = 1; i < n; i++) {
            int temp = Math.abs(arr[i] - arr[i - 1]);
            if (temp > max) {
                max = temp;
            }
        }
        if (Math.abs(arr[0] - arr[n - 1]) > max) {
            max = Math.abs(arr[0] - arr[n - 1]);
        }
        return max;
    }
}
