package 排列组合.排列;

import java.util.TreeSet;

/**
 * a = {1,2,3}
 * 输出123,132,213,231,312,321
 */
public class 全排列不重复递归 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2,};
        permutation(arr);
    }

    public static void permutation(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        TreeSet<String> res = new TreeSet<>();
        permutation(arr, 0, res);
        for (String e : res) {
            System.out.println(e);
        }
    }

    /**
     * @param arr
     * @param index 用于控制2加上13的所有全排列
     */
    public static void permutation(int[] arr, int index, TreeSet<String> set) {
        if (index == arr.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            set.add(sb.toString());
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permutation(arr, index + 1, set);
            swap(arr, index, i);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
