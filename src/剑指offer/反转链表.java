package 剑指offer;

import 剑指offer.bean.ListNode;

/**
 * 反转链表
 * Created by liyanzhen on 17/5/17.
 */
public class 反转链表 {
    public static void main(String[] args) {
        ListNode g = new ListNode(null, 2);
        ListNode f = new ListNode(g, 3);
        ListNode e = new ListNode(f, 4);
        ListNode d = new ListNode(e, 5);
        ListNode c = new ListNode(d, 6);
        ListNode b = new ListNode(c, 7);
        ListNode a = new ListNode(b, 8);
        System.out.println(ReverseList(a).getData());
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode node = head;
        ListNode pre = null;

        while (node != null) {
            ListNode next = node.getNextNode();
            if (next == null) {
                reverseHead = node;
            }
            node.setNextNode(pre);
            pre = node;
            node = next;
        }
        return reverseHead;
    }
}
