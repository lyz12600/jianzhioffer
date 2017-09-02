package leetcode;


import aaa.Template;

import java.util.Scanner;
import java.util.Stack;

/**
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Evaluate_reverse_polish_notation {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/leetcode/triangle/input.txt");
        while (s.hasNextLine()) {
            String[] str = s.nextLine().trim().split(",");
            System.out.println(evalRPN(str));
        }
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int left, right;

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    right = stack.pop();
                    left = stack.pop();
                    stack.add(right + left);
                    break;
                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    stack.add(left - right);
                    break;
                case "*":
                    right = stack.pop();
                    left = stack.pop();
                    stack.add(left * right);
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.add(left / right);
                    break;
                default:
                    stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
