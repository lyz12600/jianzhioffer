package 今日头条;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = s.nextInt();
                arr[i][1] = s.nextInt();
            }
            print(arr);
        }
    }

    public static void print(int[][] arr) {
    }
}
