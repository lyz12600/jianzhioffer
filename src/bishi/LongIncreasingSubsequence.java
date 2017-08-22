package bishi;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/3/30.
 */
public class LongIncreasingSubsequence {
    public static void main(String args[]) {
        LongIncreasingSubsequence main = new LongIncreasingSubsequence();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] s = str.trim().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            main.getLIS(arr);
        }
    }

    public void getLIS(int[] arr) {
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = 1;
        }
        int nLis = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    a[i] = Integer.max(a[i], a[j] + 1);
                }
            }
            nLis = Integer.max(a[i], nLis);
        }
        System.out.println(nLis);
    }
}
