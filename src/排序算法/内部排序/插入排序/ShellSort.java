package 排序算法.内部排序.插入排序;

/**
 * Created by liyanzhen on 17/3/19.
 * 希尔排序
 * O(n*n)
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = {50, 26, 38, 80, 70, 90, 8, 30, 40, 20};
        shellSort(arr, 5);
    }

    public static void shellSort(int[] arr, int n) {
        if (arr == null) {
            return;
        }

        while (n > 0) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length - n; j = j + n) {
                    if (arr[j] > arr[j + n]) {
                        int temp = arr[j + n];
                        arr[j + n] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            n /= 2;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
