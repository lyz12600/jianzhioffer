package 排列组合.组合;

import java.util.ArrayList;

public class 求将m分解成任意个正整数相加之和的所有组合 {
    public static void main(String[] args) {
        combine(6);
    }

    public static void combine(int m) {
        if (m < 1)
            return;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        getCombination(m, arr);
    }

    public static void getCombination(int m, ArrayList<Integer> arr) {
        if (m == 0 && arr.size() > 1) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for (Integer i = 1; i <= m; i++) {

            if (!arr.isEmpty() && i < arr.get(arr.size() - 1))//使集合内元素递增，防止重复
                continue;
            arr.add(i);
            getCombination(m - i, arr);
            arr.remove(i);

        }
    }
}
