package 排序算法.内部排序.插入排序;

/**
 * Created by liyanzhen on 17/3/19.
 * 直接插入排序
 * O(n*n)
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {8, 10, 13, 4, 6, 7, 22, 2, 3};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    //交换数据
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        for (int a = 0; a < arr.length; a++) {
            System.out.print(arr[a] + " ");
        }
    }
}
