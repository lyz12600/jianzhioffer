package 剑指offer;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/6/27.
 */
public class 构建乘积数组 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < A.length; i++) {
                A[i] = s.nextInt();
            }
            int[] B = multiply(A);
            for (int i = 0; i < B.length; i++) {
                System.out.print(B[i] + " ");
            }
            System.out.println("");
        }
    }

    public static int[] multiply(int[] A) {
        if (A == null || A.length < 1)
            return null;
        int len = A.length;
        int[] B = new int[len];

        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = A[i - 1] * B[i - 1];
        }

        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}
