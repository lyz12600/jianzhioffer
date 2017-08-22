package 剑指offer;

/**
 * Created by liyanzhen on 17/6/4.
 * 计数排序
 * 时间复杂度o(n)
 * 空间复杂度o(n)
 * 不是基于比较的排序算法
 */
public class 计数排序 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        int n = 5;
        int[] res = calculate(arr, n);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] calculate(int[] arr, int n) {
        int[] count = new int[n + 1];
        // 计算出现次数
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        //前n项和相加
        for (int i = 1; i < n + 1; i++) {
            count[i] += count[i - 1];
        }

        int[] a = new int[arr.length];
        //排序赋值
        for (int i = arr.length - 1; i >= 0; i--) {
            a[--count[arr[i]]] = arr[i];
        }
        return a;
    }
}
