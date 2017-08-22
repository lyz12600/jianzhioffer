package 剑指offer;

/**
 * 第k小的数
 * Created by liyanzhen on 17/5/25.
 */
public class 第k小的数 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 8, 9, 3, 2};
        System.out.println(kth_elem(arr, 0, arr.length - 1, 5));
    }

    public static int kth_elem(int[] arr, int low, int high, int k) {
        if (arr == null || low < 0 || high > arr.length - 1 || k <= 0 || k > arr.length)
            throw new IllegalArgumentException("参数有误");

        int pivot = arr[low];
        int low_temp = low;
        int high_temp = high;

        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;

        int i = low - low_temp + 1;
        if (i == k) {
            return arr[low];
        } else if (i > k) {
            return kth_elem(arr, low_temp, low - 1, k);
        } else {
            return kth_elem(arr, low + 1, high_temp, k - i);
        }
    }
}
