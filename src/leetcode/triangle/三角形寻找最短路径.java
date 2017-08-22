package leetcode.triangle;

import aaa.Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * [
 * [-1],
 * [2,3],
 * [1,-1,-3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Created by liyanzhen on 17/7/24.
 */
public class 三角形寻找最短路径 {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/leetcode/triangle/input.txt");
        List<List<Integer>> lists = new ArrayList<>();
        while (s.hasNextInt()) {
            lists.clear();
            int n = s.nextInt();
            int index = 1;
            for (int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < index; j++) {
                    temp.add(s.nextInt());
                }
                index++;
                lists.add(temp);
            }

            System.out.println(minimumTotal(lists));
        }
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) {
            return 0;
        }
        int[] arr = new int[triangle.get(triangle.size() - 1).size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                arr[j] = triangle.get(i).get(j) + Math.min(arr[j + 1], arr[j]);
            }
        }
        return arr[0];
    }
}
