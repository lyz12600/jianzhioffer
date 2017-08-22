package bishi;

import java.util.*;

public class SubAdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] strings = str.trim().split("\\s+");
            int[] arr = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                arr[i] = Integer.valueOf(strings[i]);
            }
            res = maxSum(arr);
            System.out.println(String.valueOf(res));
        }
    }

    static int maxSum(int[] arr) {
        int index = 0;
        int max = 0;
        int len = arr.length;
        if (arr == null || arr.length < 1) {
            return -1;
        }

        for (int i = 0; i < len; i++) {
            index += arr[i];
            if (index < max) {
                index = 0;
            }else {
                max = index;
            }
        }

        if (max == 0) {
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    max = arr[i];
                }
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        return max;
    }
}