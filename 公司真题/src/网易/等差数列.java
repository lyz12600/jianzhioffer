package 网易;

import java.util.Arrays;
import java.util.Scanner;

public class 等差数列 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            if (solve(arr)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }

    public static boolean solve(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return false;
        }
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        for (int i = 0; i < sum; i++) {
            int temp = arr[0] * arr.length + arr.length * (arr.length - 1) / 2 * i;
            if (temp == sum) {
                return true;
            }
        }
        return false;
    }
}
