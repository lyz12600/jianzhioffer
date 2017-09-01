package leetcode.单调栈;

import aaa.Template;

import java.util.Scanner;
import java.util.Stack;

public class 直方图中最大矩形的面积 {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("./src/aaa/input.txt");
        while (s.hasNextLine()) {
            String[] str = s.nextLine().trim().split(",");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(largestRectangleArea(arr));
        }
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            //用于存储当前值，最后加一个0,用于全部出栈
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
