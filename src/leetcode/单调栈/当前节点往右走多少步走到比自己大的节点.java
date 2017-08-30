package leetcode.单调栈;

import java.util.Arrays;
import java.util.Stack;

public class 当前节点往右走多少步走到比自己大的节点 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) { //构造单调递减栈
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}