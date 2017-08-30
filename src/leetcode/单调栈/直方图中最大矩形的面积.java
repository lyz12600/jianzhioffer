package leetcode.单调栈;

import aaa.Template;

import java.util.Arrays;
import java.util.Scanner;

public class 直方图中最大矩形的面积 {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("./src/aaa/input.txt");
        while (s.hasNextLine()) {
            String[] str = s.nextLine().trim().split(",");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int res[] = largestRectangleArea(arr);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }

    public static int[] largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return null;
        }

        int[] res = new int[heights.length];
        Arrays.fill(res, -1);

        return res;
    }
}
