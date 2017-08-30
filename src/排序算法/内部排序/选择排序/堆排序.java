package 排序算法.内部排序.选择排序;

/**
 * Created by liyanzhen on 17/7/10.
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = {1,9,8,7,5,4,12,14};
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            maxHeapAdjust(arr, i, arr.length - 1);
        }

        int[] seq = heapSort(arr, arr.length - 1);

        for (int i = 0; i < seq.length; i++) {
            System.out.print(seq[i] + "  ");
        }
    }

    public static int[] heapSort(int[] arr, int maxSeq) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        for (int i = maxSeq; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapAdjust(arr, 0, i - 1);
        }
        return arr;
    }

    public static void maxHeapAdjust(int[] arr, int seq, int maxSeq) {
        int i, j;
        int temp = arr[seq];
        i = seq;
        for (j = 2 * i + 1; j <= maxSeq; j = j * 2 + 1) {
            if (j < maxSeq && arr[j] < arr[j + 1]) {
                j += 1;
            }
            if (temp > arr[j]) {
                break;
            }
            arr[i] = arr[j];
            i = j;
        }
        arr[i] = temp;
    }
}
