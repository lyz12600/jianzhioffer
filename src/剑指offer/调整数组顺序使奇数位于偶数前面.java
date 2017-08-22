package 剑指offer;

import java.util.Scanner;

/**
 * 调整数组顺序使奇数位于偶数前面
 * Created by liyanzhen on 17/5/16.
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().trim().split("\\s+");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void reOrderArray(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        /**
         *  利用快排 先后相对顺序改变
         */
//        int low = 0;
//        int high = array.length - 1;
//
//        while (low < high) {
//            while (((array[low] & 0x1) != 0) && (low < high)) {//左边不是偶数
//                low++;
//            }
//            while ((array[high] & 0x1) == 0 && low < high) {
//                high--;
//            }
//
//            if (isEven(array[low])) {
//                swap(array, low, high);
//                high--;
//            } else if (isEven(array[high])) {
//                swap(array, high, low);
//                low++;
//            }
//        }

        /**
         * 冒泡，先后相对顺序不变
         */
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (isEven(array[j]) && !isEven(array[j + 1])) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 抽出来根据需求修改
     * 减少耦合度
     *
     * @param n
     * @return
     */
    public static boolean isEven(int n) {
        return (n & 0x1) == 0;
    }

    //交换位置
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
