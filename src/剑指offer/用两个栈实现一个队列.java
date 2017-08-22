package 剑指offer;

import java.util.Stack;

/**
 * Created by liyanzhen on 17/3/15.
 * 用两个栈实现一个队列
 */
public class 用两个栈实现一个队列 {
    static Stack a = new Stack();
    static Stack b = new Stack();

    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        delete();
        delete();
        insert(4);
        delete();
        insert(5);
        insert(6);
        insert(7);
    }

    public static void insert(int data) {
        while (!b.empty()) {
            a.push(b.pop());
        }
        a.push(data);
    }

    public static void delete() {
        while (!a.empty()) {
            b.push(a.pop());
        }
        b.pop();
    }
}
