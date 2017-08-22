package 腾讯;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/7/15.
 */
public class geohash编码 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int num = s.nextInt();
            System.out.println(geohash(num));
        }
    }

    public static String geohash(int num) {
        if (num < -90 || num > 90) {
            return null;
        }
        int left = -90;
        int right = 90;
        int[] arr;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            arr = findFlag(num, left, right);
            sb.append(arr[0]);
            left = arr[1];
            right = arr[2];
        }
        return sb.toString();
    }

    public static int[] findFlag(int val, int left, int right) {//当前左右
        int[] arr = new int[3];
        int mid = (int) Math.floor((left + right) / 2);
        if (val >= left && val < mid) {
            arr[0] = 0;
            arr[1] = left;
            arr[2] = mid;
        } else if (val >= mid && val <= right) {
            arr[0] = 1;
            arr[1] = mid;
            arr[2] = right;
        }
        return arr;
    }
}
