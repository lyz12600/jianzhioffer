package 排序算法;

import aaa.Template;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/排序算法/input.txt");
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }

            int[] res = sort(arr);
            for (int i = 0; i < res.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }

        int num0 = 0;
        int num1 = 0;
        int num2 = arr.length - 1;
        while (num1 <= num2) {
            switch (arr[num1]) {
                case 0:
                    swap(arr, num0, num1);
                    num0++;
                    num1++;
                    break;

                case 1:
                    num1++;
                    break;

                case 2:
                    swap(arr, num1, num2);
                    num2--;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
