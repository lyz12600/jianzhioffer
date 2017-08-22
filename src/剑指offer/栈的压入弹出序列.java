package 剑指offer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * Created by liyanzhen on 17/5/20.
 */
public class 栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 1, 2};
        System.out.println(isPopOrder(pushA, popA));
    }

    public static boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length < 1 || popA.length < 1 || pushA.length != popA.length) {
            return false;
        }
        int a = 0;
        int b = 0;
        int len = popA.length;

        Stack stack = new Stack();
        stack.push(pushA[a++]);

        while (b < len) {
            while ((popA[b] != (int) stack.peek())) {
                if (a == len) {
                    return false;
                }
                stack.push(pushA[a++]);
            }
            stack.pop();
            b++;
        }
        return true;
    }
}
