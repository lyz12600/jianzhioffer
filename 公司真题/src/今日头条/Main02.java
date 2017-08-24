package 今日头条;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println(max(arr));
        }
    }

    public static int max(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int max = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            temp = arr[i] * arr[i];
            max = max > temp ? max : temp;
        }


        for (int i = 2; i <= arr.length; i++) {//几个数
            for (int j = 0; j < arr.length; j++) {

            }
        }

        return max;
    }
}
