package bishi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/6/16.
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int k = s.nextInt();
            System.out.println(escape(n, k));
        }
    }

    public static int escape(int n, int k) {
        if (n < 0 || k < 0 || n < k)
            return 0;
        if (n == k)
            return 1;
        return 0;
    }

    public static ArrayList<Integer> maxSum(int n, int k) {
        return null;
    }
}
