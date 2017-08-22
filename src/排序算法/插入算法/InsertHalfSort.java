package 排序算法.插入算法;

/**
 * Created by liyanzhen on 17/3/19.
 */
public class InsertHalfSort {
    public static void main(String[] args) {
        int[] arr = {8, 10, 13, 4, 6, 7, 22, 2, 3};
        insert(arr);
    }

    public static void insert(int[] arr) {
        int temp;
        int low, high, middle;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                middle = (low + high) / 2;
                if (arr[middle] > temp) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }

            for (int j = i - 1; j >= high + 1; j--) {
                arr[j + 1] = arr[j];
            }
            arr[high + 1] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
