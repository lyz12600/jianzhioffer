package 剑指offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/6/19.
 */
public class 圆圈中最后剩下的数字 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int m = s.nextInt();
            System.out.println(LastRemaining_Solution1(n, m));
            System.out.println(LastRemaining_Solution2(n, m));
        }
    }

    //方法一：重复遍历
    public static int LastRemaining_Solution1(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (list.size() > 1) {
            for (int i = 1; i < m; i++) {
                idx = (idx + 1) % list.size();
            }
            list.remove(idx);
        }
        return list.get(0);
    }


    //方法二：归纳
    public static int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int last = 0;

        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
