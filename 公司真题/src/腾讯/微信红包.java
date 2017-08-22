package 腾讯;

import java.util.Scanner;

import static 华为.字符串运算.getScanner;

public class 微信红包 {
    public static void main(String[] args) {
        Scanner s = getScanner("/Users/liyanzhen/IdeaProjects/crazy/公司真题/src/腾讯/input.txt");
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }

            System.out.println(getValue(arr, n));
        }
    }

    public static int getValue(int[] gifts, int n) {
        int result = gifts[0];
        int times = 1;

        for (int i = 1; i < gifts.length; i++) {
            if (times == 0) {
                result = gifts[i];
                times = 1;
            } else if (gifts[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        if (!isExist(gifts, result))
            return 0;
        return result;
    }

    public static boolean isExist(int[] arr, int a) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                count++;
            }
        }
        if (count > arr.length / 2) {
            return true;
        }
        return false;
    }
}
