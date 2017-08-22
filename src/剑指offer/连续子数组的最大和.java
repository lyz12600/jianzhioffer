package 剑指offer;

import java.util.Scanner;

/**
 * 连续子数组的最大和
 * Created by liyanzhen on 17/5/31.
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String[] str = s.nextLine().trim().split("\\s+");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(FindGreatestSumOfSubArray(arr));
        }
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length < 1)
            return 0;
        int sum = 0x80000000;
        int curSum = 0;

        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }
            if (curSum > sum) {
                sum = curSum;
            }
        }
        return sum;
    }
}
