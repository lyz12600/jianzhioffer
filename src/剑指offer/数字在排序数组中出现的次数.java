package 剑指offer;

/**
 * Created by liyanzhen on 17/6/6.
 */
public class 数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 2, 4, 5, 6, 8};
        System.out.println(GetNumberOfK(arr, 2));
    }

    public static int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length < 1)
            return -1;

        if (!isExist(array, k))
            return 0;

        int first = getFirstNumberOfK(array, k, 0, array.length - 1);
        int end = getEndNumberOfK(array, k, 0, array.length - 1);
        int number = 0;
        if (first > -1 && end > -1)
            number = end - first + 1;
        return number;
    }

    public static int getFirstNumberOfK(int[] arr, int k, int start, int end) {
        if (start > end)
            return -1;
        int middleIndex = (start + end) / 2;
        int middleData = arr[middleIndex];
        if (middleData == k) {
            if ((middleIndex > 0 && arr[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstNumberOfK(arr, k, start, end);
    }

    public static int getEndNumberOfK(int[] arr, int k, int start, int end) {
        if (start > end)
            return -1;
        int middleIndex = (start + end) / 2;
        int middleData = arr[middleIndex];
        if (middleData == k) {
            if ((middleIndex < arr.length - 1 && arr[middleIndex + 1] != k) || middleIndex == arr.length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }
        return getEndNumberOfK(arr, k, start, end);
    }

    public static boolean isExist(int[] arr, int index) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == index)
                return true;
        }
        return false;
    }
}
