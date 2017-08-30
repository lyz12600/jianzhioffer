package 排序算法.内部排序.交换排序;


/**
 * Created by liyanzhen on 17/3/20.
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 1};
        QuickSort entity = new QuickSort();
        entity.quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int arr[], int low, int high) {
        if (low < high) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            int piovt = partition(arr, low, high);
            quickSort(arr, low, piovt - 1);
            quickSort(arr, piovt + 1, high);
        }
    }

    /**
     * 第一种分治算法
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] arr, int low, int high) {
        int piovt = arr[low];
        int location = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < piovt) {
                int temp = arr[i];
                arr[i] = arr[++location];
                arr[location] = temp;
            }
        }
        int temp = arr[location];
        arr[location] = arr[low];
        arr[low] = temp;

        return location;
    }
    /**
     * 第二种分治算法
     */
//    public static int partition(int arr[], int low, int high) {
//        int temp = arr[low];
//        while (low < high) {
//            while (low < high && arr[high] > temp) {
//                high--;
//            }
//            arr[low] = arr[high];
//            while (low < high && arr[low] < temp) {
//                low++;
//            }
//            arr[high] = arr[low];
//        }
//            arr[high] = temp;
//            return high;
//    }
}