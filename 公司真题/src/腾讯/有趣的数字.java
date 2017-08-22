package 腾讯;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/7/16.
 */
public class 有趣的数字 {
    public static void main(String[] args) {
        //Todo
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            if (n < 1 || n > 100000) {
                return;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            int[] count = findMinAndMax((arr));
            System.out.println(count[0] + " " + count[1]);
        }
    }

    private static int[] findMinAndMax(int[] arr) {
        int[] count = new int[2];
        if (arr == null || arr.length < 2) {
            return count;
        }

        Arrays.sort(arr);
        count[0] = 1;
        count[1] = 1;
        /**
         * 最大
         */
        int i = 0;
        int j = arr.length - 1;
        int max = arr[j] - arr[i];
        int c = 1;
        while (j > 0 && arr[j] == arr[j - 1]) {
            c++;
            j--;
        }
        if (c == arr.length) {
            count[0] = jiecheng(c);
            count[1] = jiecheng(c);
            return count;
        } else {
            j = arr.length - 1;
            while (i < j && (arr[j] - arr[i + 1] == max)) { //如果连着相等
                ++count[1];
                i++;
            }
            count[1] = c * jiecheng(count[1]);
        }
        /**
         * 最小
         */

        i = 0;
        j = 1;
        c = 1;
        while (j < arr.length - 1 && arr[i] == arr[j]) {
            c++;
            j++;
        }

        int min = Math.abs(arr[1] - arr[0]);
        i = 1;
        j = 2;
        while (j < arr.length && (arr[j] - arr[i] == min)) {
            ++count[0];
            j++;
        }
        count[0] = c * jiecheng(count[0]);

        return count;

    }

    public static int jiecheng(int n) {
        if (n <= 1) {
            return 1;
        }

        int sum = 0;
        while (n > 0) {
            sum += (n - 1);
            n--;
        }
        return sum;
    }
}
