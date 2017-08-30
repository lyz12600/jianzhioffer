package 三六零;

import 华为.ScannerHelper;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 前面比自己大的数有几个 {
    public static void main(String[] args) {
        Scanner in = ScannerHelper.getScanner("./公司真题/src/三六零/input.txt");
        while (in.hasNextInt()) {
            int n = in.nextInt();//数据个数
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int[] res = solve(arr);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
        }
    }

    public static int[] solve(int[] arr) {
        int[] res = new int[arr.length];
        if (arr.length < 1) {
            return res;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            //保持一个递增栈
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                stack.pop();
            }
            stack.push(arr[i]);
            res[i] = stack.size() - 1;
        }
        return res;
    }
}

