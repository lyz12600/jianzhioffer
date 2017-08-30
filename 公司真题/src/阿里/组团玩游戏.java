package 阿里;

import java.util.*;

/**
 * 输入：
 * 4
 * 1 1 1 1
 * 1 1 0 1
 * 1 0 1 1
 * 1 1 1 1
 * 3
 * 1 1 0
 * 1 1 0
 * 0 0 1
 * <p>
 * 输出：
 * 1
 * 2
 */

public class 组团玩游戏 {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("/Users/liyanzhen/IdeaProjects/crazy/公司真题/src/阿里/input.txt");
//        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.nextInt();
                }
            }
            System.out.println(solve(n, arr));
        }
    }

    public static int solve(int n, int[][] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        List<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            HashSet set = new HashSet();
            for (int j = i + 1; j < n; j++) {
                if (arr[i][j] == 1) {
                    set.add(i);
                    set.add(j);
                }
            }
            list.add(set);
        }

        if (list.size() < 1) {
            return 0;
        }

        HashSet set = list.get(0);
        int count = list.size();
        boolean flag = false;
        for (int i = 1; i < list.size(); i++) {
            for (Integer val : list.get(i)) {
                if (set.contains(val)) {
                    flag = true;
                }
            }
            if (flag) {
                count--;
            }
        }
        return count;
    }
}
