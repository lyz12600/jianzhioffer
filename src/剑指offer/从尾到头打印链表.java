package 剑指offer;


import java.util.ArrayList;

/**
 * Created by liyanzhen on 17/3/10.
 * 从尾到头打印链表
 */

public class 从尾到头打印链表 {
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        ListNode d = new ListNode(6);
        ListNode c = new ListNode(5);
        ListNode b = new ListNode(4);
        ListNode a = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        ArrayList<Integer> list = printListFromTailToHead(a);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return list;
        }
        if (listNode.next != null) {
            printListFromTailToHead(listNode.next);
        }
        list.add(listNode.val);
        return list;
    }
}
