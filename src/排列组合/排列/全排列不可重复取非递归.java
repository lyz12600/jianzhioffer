package 排列组合.排列;

import java.util.Arrays;

/**
 * 全排列非递归做法
 * 如a={1,2,3}。输出123,132,213,231,312,321
 */
public class 全排列不可重复取非递归 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3,};
        permutation(arr);
    }

    public static void permutation(int[] arr) {
        Arrays.sort(arr);//对数组排序

        while (true) {

            printArray(arr);//输出一个排列

            int i;//从后向前，记录一对顺序值中的小值下标
            int j;//从后向前，记录比i大的第一个数

            for (i = arr.length - 2; i >= 0; i--) {

                if (arr[i] < arr[i + 1])//如果找到i跳出
                    break;
                else if (i == 0)//说明是最大逆序数退出函数
                    return;
            }

            for (j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[i])//找到j跳出
                    break;
            }
            swap(arr, i, j);//交换i，j
            reverse(arr, i + 1, arr.length - 1);//翻转
        }
    }

    public static void reverse(int[] a, int i, int j) {
        while (i < j)
            swap(a, i++, j--);
    }

    public static void printArray(int[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
