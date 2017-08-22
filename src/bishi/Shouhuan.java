package bishi;

import java.util.Scanner;

public class Shouhuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String str = in.nextLine();
            String[] arr = str.split("\\s+");

            int n = Integer.valueOf(arr[0]);
            int k = Integer.valueOf(arr[1]);

            str = in.nextLine();
            arr = str.trim().split("\\s+");
            int[] array = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                array[i] = Integer.parseInt(arr[i]);
//                System.out.println(array[i]);
            }

            printHandCycler(n, k, array);
        }
    }

    public static void printHandCycler(int n, int k, int[] arr) {
        if (k == 0) {
            print(arr);
            return;
        }
        for (int i = 0; i < k; i++) {
            int temp = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j] + arr[j + 1];
                if (arr[j] > 100) {
                    arr[j] = arr[j] % 100;
                }
            }
            arr[n - 1] = arr[n - 1] + temp;
            if (arr[n - 1] > 100) {
                arr[n - 1] = arr[n - 1] % 100;
            }
        }
        print(arr);
        return;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.print(arr[i]);
            }
        }
    }
}