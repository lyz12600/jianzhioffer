package 排列组合.排列;

import java.util.TreeSet;

public class 全排列可重复取 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permutation(arr);
    }

    public static void permutation(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        TreeSet<String> set = new TreeSet<>();
        int[] brr = new int[arr.length];
        permutation(arr, 0, set, brr);
        for (String s : set) {
            System.out.println(s);
        }
    }

    public static void permutation(int[] arr, int index, TreeSet<String> set, int[] brr) {
        if (index == arr.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(brr[i] + " ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            brr[index] = arr[i];
            permutation(arr, index + 1, set, brr);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}
