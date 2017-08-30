package 排序算法.内部排序;

public class 归并排序 {
    private static final int MAX = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        int[] temp = new int[arr.length];
        int[] res = mergeSort(arr, 0, arr.length - 1, temp);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] mergeSort(int[] arr, int start, int end, int[] temp) {
        int[] res = new int[arr.length];
        if (start >= end) {
            return res;
        }
        int mid = (start + end) >> 1;
        mergeSort(arr, start, mid, temp);
        mergeSort(arr, mid + 1, end, temp);
        merge(arr, start, end, temp, res);
        return res;
    }

    private static void merge(int[] arr, int start, int end, int[] temp, int[] res) {
        int left = start;
        int mid = (start + end) >> 1;
        int right = mid + 1;
        int index = start;
        int counter = 0;
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp[index++] = arr[left++];
                counter += right - mid - 1;
                counter %= MAX;
            } else {
                temp[index++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = arr[left++];
            counter += right - mid - 1;
            counter %= Math.pow(10, 9) + 7;
        }
        while (right <= end) {
            temp[index++] = arr[right++];
        }

        for (int i = 0; i < index; i++) {
            arr[i] = temp[i];
        }
        res[index - 1] = counter;
    }
}
