package 动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class 最长递增子序列 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr;
        while (s.hasNextLine()) {
            String[] str = s.nextLine().trim().split(",");
            arr = new int[str.length - 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int n = Integer.parseInt(str[str.length - 1]);
            System.out.println(LIS(arr, n));
        }
    }

    public static int LIS(int[] arr, int n) {
        if (arr == null || arr.length == 0 || n == 0) {
            return 0;
        }

        int max = 1;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    res[i] = Integer.max(res[j] + 1, res[i]);
                }
            }
            max = max > res[i] ? max : res[i];
        }
        return max;

    }
}
