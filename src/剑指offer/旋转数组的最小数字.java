package 剑指offer;

/**
 * Created by liyanzhen on 17/5/9.
 * 旋转数组的最小数字
 */
public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        if (arr == null || arr.length <= 0)
            return -1;
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (arr[low] >= arr[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }

            mid = (low + high) / 2;

            if (arr[low] == arr[high] && arr[mid] == arr[low])
                return MinInOrder(arr, low, high);

            if (arr[mid] >= arr[low]) {
                low = mid;
            } else if (arr[mid] <= arr[high]) {
                high = mid;
            }
        }
        return arr[mid];
    }

    private static int MinInOrder(int[] arr, int low, int high) {
        int result = arr[low];
        for (int i = low + 1; i <= high; i++) {
            if (result > arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }
}
