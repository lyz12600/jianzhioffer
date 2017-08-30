package 排序算法.内部排序.选择排序;

public class 简单选择排序 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 3, 6, 8, 4, 7};
        int[] res = selectSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] selectSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, i, min);
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
