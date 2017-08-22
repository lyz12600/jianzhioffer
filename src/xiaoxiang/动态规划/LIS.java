package xiaoxiang.动态规划;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 最长递增子序列LIS
 * 不连续、求长度
 * Created by liyanzhen on 17/6/20.
 */
public class LIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        while (count > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(LIS2(arr));
            count--;
        }
    }

    /**
     * 时间复杂度：O(n*n)
     * q
     *
     * @param arr
     * @return
     */
    public static int LIS1(int[] arr) {
        if (arr == null || arr.length < 1)
            return 0;
        int[] count = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[i] = 1;
        }

        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    count[i] = Integer.max(count[j] + 1, count[i]);
                }
            }
            max = Integer.max(count[i], max);
        }
        return max;
    }

    /**
     * 方法二：
     * 时间复杂度： O(nlogn)
     *
     * @return
     */
    public static int LIS2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (list.get(list.size() - 1) < arr[i]) {
                list.add(arr[i]);
            } else {
                list = insert(list, arr[i]);
            }
        }
        return list.size();
    }

    /**
     * 二分插入法
     *
     * @param list
     * @param a
     * @return
     */
    public static ArrayList<Integer> insert(ArrayList<Integer> list, int a) {
        int low = 0;
        int high = list.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (a < list.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        list.set(low, a);
        return list;
    }

    /**
     * 求最长递增子序列本身,不是求长度,是求具体值
     *
     * @param arr
     */
    public static ArrayList<ArrayList<Integer>> LISself(int[] arr) {

        return null;
    }
}
