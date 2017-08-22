package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 面试题：65
 * 滑动窗口的最大值
 * <p>
 * Created by liyanzhen on 17/7/8.
 */
public class 滑动窗口的最大值 {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || size == 0 || size > num.length) {
            return list;
        }

        LinkedList<Integer> index = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            if (!index.isEmpty() && num[i] > num[index.getLast()]) {
                index.removeLast();
            }
            index.addLast(i);
        }

        for (int i = size - 1; i < num.length; i++) {
            while (!index.isEmpty() && num[i] > num[index.getLast()]) {
                index.removeLast();
            }
            index.addLast(i);

            if (i - index.getFirst() + 1 > size) {
                index.removeFirst();
            }

            list.add(num[index.getFirst()]);
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
//        int[] arr = {16, 14, 12, 10, 8, 6, 4};
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        ArrayList<Integer> list = maxInWindows(arr, 3);
        for (Integer i : list) {
            System.out.print(i + "  ");
        }
    }
}
