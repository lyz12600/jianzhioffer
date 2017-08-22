package 剑指offer;

import 剑指offer.bean.ListNode;

/**
 * 链表中倒数第k个结点
 * Created by liyanzhen on 17/5/17.
 */
public class 链表中倒数第k个结点 {
    public static void main(String[] args) {
        ListNode g = new ListNode(null, 7);
        ListNode f = new ListNode(g, 6);
        ListNode e = new ListNode(f, 5);
        ListNode d = new ListNode(e, 4);
        ListNode c = new ListNode(d, 3);
        ListNode b = new ListNode(c, 2);
        ListNode a = new ListNode(b, 1);
        System.out.println(FindKthToTail(a, 6).getData());
    }

    /**
     * 解题思路：第一个指针走到k-1个位置，第二个指针指向head，
     * 一起走，然后第一个指针到最后的时候，第二个指针在指定位置
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < k - 1; i++) {
            if (first.getNextNode() != null) {
                first = first.getNextNode();
            } else {
                return null;
            }
        }

        while (first.getNextNode() != null) {
            first = first.getNextNode();
            second = second.getNextNode();
        }

        return second;
    }
}
