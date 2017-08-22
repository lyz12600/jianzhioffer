package 美团;

import java.util.Scanner;

public class 最大矩形面积 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println(sum(arr));
        }
    }

    public static int sum(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] >= arr[i]) {
                sum += arr[i];
                j--;
            }//左边

            j = i + 1;
            while (j < arr.length && arr[j] >= arr[i]) {
                sum += arr[i];
                j++;
            }//右边

            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
