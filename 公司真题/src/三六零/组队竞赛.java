package 三六零;

import 阿里.Template;

import java.util.Arrays;
import java.util.Scanner;

public class 组队竞赛 {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("./公司真题/src/三六零/input.txt");
        long[] arr;
        while (s.hasNext()) {
            int n = s.nextInt();
            arr = new long[n * 3];
            for (int i = 0; i < (3 * n); i++) {
                arr[i] = s.nextLong();
            }
            System.out.println(solution(n, arr));
        }
    }

    public static long solution(long n, long[] arr) {
        if (n < 1 || arr.length == 0) {
            return -1;
        }

        Arrays.sort(arr);
        if (arr[0] == arr[arr.length - 1]) {
            return arr[0] * n;
        }
        long sum = 0;
        for (int i = arr.length - 2; i >= n; i -= 2) {
            sum += arr[i];
        }
        return sum;
    }
}
