package 剑指offer;

import 剑指offer.bean.ListNode;

/**
 * Created by liyanzhen on 17/3/10.
 * 从尾到头打印链表
 */

public class 从尾到头打印链表 {

    public static void main(String[] args) {
        ListNode f = new ListNode(null, 1);
        ListNode e = new ListNode(f, 2);
        ListNode d = new ListNode(e, 3);
        ListNode c = new ListNode(d, 4);
        ListNode b = new ListNode(c, 5);
        ListNode a = new ListNode(b, 6);

        printFinalListNode(a);
    }

    public static void printFinalListNode(ListNode listNode) {
        if (listNode.getNextNode() != null) {
            printFinalListNode(listNode.getNextNode());
        }
        System.out.println(listNode.getData());
    }
}
