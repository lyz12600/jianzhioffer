package 剑指offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * Created by liyanzhen on 17/6/13.
 */
public class 和为s的两个数字 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int sum = s.nextInt();
            s.nextLine();
            String[] str = s.nextLine().trim().split("\\s+");
            int[] arr = new int[str.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            ArrayList<Integer> list = FindNumbersWithSum(arr, sum);
            for (Integer i : list) {
                System.out.print(i + " ");
            }
        }
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 1)
            return list;
        int low = 0, high = array.length - 1;
        while (low < high) {
            if (array[low] + array[high] > sum) {
                high--;
            } else if (array[low] + array[high] < sum) {
                low++;
            } else {
                list = minMulti(list, array[low], array[high]);
                low++;
                high--;
            }
        }
        return list;
    }

    /**
     * 计算乘积最小
     */
    public static ArrayList<Integer> minMulti(ArrayList<Integer> list, int a, int b) {
        if (list == null || list.size() < 1 || (list.get(0) * list.get(1) > a * b)) {
            list.add(a);
            list.add(b);
            return list;
        }
        return list;
    }
}
