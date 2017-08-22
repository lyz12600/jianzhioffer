package bishi;

import java.util.Scanner;

public class 杨辉三角 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[][] arr = getYangHuiSanJiao(n);
            int index = 2;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < index; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                index++;
                System.out.println();
            }
        }
    }

    private static int[][] getYangHuiSanJiao(int n) {
        if (n < 2) {
            return null;
        }

        int[][] arr = new int[n - 1][n];
        arr[0][0] = 1;
        arr[0][1] = 1;
        for (int i = 0; i < n - 1; i++) {
            arr[i][0] = 1;
        }

        int k = 3;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < k; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
            k++;
        }
        return arr;
    }
}
