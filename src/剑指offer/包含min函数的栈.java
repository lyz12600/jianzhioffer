package 剑指offer;

import java.util.Stack;

/**
 * 包含min函数的栈
 * Created by liyanzhen on 17/5/20.
 */
public class 包含min函数的栈 {
    public static void main(String[] args) {
        Zhan zhan = new Zhan();
        zhan.push(3);
        zhan.min();
        zhan.push(4);
        zhan.min();
        zhan.push(2);
        zhan.min();
        zhan.push(3);
        zhan.min();
        zhan.pop();
        zhan.min();
        zhan.pop();
        zhan.min();
        zhan.pop();
        zhan.min();
        zhan.push(0);
        zhan.min();
    }
}

class Zhan {
    Stack one = new Stack();
    Stack two = new Stack();

    public void push(int node) {
        one.push(node);
        if (two.empty()) {
            two.push(node);
        } else if (node < (int) two.peek()) {
            two.push(node);
        } else {
            two.push(two.peek());
        }
    }

    public void pop() {
        one.pop();
        two.pop();
    }

    public int top() {
        return (int) one.peek();
    }

    public int min() {
        if (two.empty()) {
            return -1;
        } else {
            System.out.println((int) two.peek());
            return (int) two.peek();
        }
    }
}