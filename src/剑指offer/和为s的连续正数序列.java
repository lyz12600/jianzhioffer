package 剑指offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输出所有和为S的连续正数序列
 * 序列内按照从小至大的顺序
 * 序列间按照开始数字从小到大的顺序
 * Created by liyanzhen on 17/6/14.
 */
public class 和为s的连续正数序列 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int sum = s.nextInt();
            ArrayList<ArrayList<Integer>> res = FindContinuousSequence(sum);
            ArrayList<ArrayList<Integer>> r = FindContinuousSequence1(sum);
            for (ArrayList<Integer> list : res) {
                for (Integer i : list) {
                    System.out.print(i + "  ");
                }
                System.out.println();
            }
            for (ArrayList<Integer> list : r) {
                for (Integer i : list) {
                    System.out.print(i + "  ");
                }
                System.out.println();
            }
        }
    }

    /**
     * 方法一：未优化
     *
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        long start = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3)
            return res;

        int low = 1, high = 2;
        while (low < high) {
            if ((low + high) * (high - low + 1) / 2 == sum) {
                ArrayList<Integer> list = addList(low, high);
                res.add(list);
                low++;
            } else if ((low + high) * (high - low + 1) / 2 < sum) {     //小于sum
                high++;
            } else {    //大于sum
                low++;
            }
        }
        System.out.println("我的方法：" + (System.currentTimeMillis() - start));
        return res;
    }

    /**
     * 剑指offer方法
     *
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        long start = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3)
            return res;

        int low = 1, high = 2;
        int mid = (1 + sum) / 2;
        int curSum = low + high;
        while (low < mid) {
            if (curSum == sum) {
                ArrayList<Integer> list = addList(low, high);
                res.add(list);
            }
            while (curSum > sum && low < mid) {
                curSum -= low;
                low++;

                if (curSum == sum) {
                    ArrayList<Integer> list = addList(low, high);
                    res.add(list);
                }
            }
            high++;
            curSum += high;
        }
        System.out.println("offer的方法：" + (System.currentTimeMillis() - start));
        return res;
    }


    public static ArrayList<Integer> addList(int a, int b) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            list.add(i);
        }
        return list;
    }
}
