package 剑指offer;

import 剑指offer.bean.ListNode;

/**
 * 两个链表的第一个公共结点
 * Created by liyanzhen on 17/6/5.
 */
public class 两个链表的第一个公共结点 {
    public static void main(String[] args) {
        ListNode e = new ListNode(null, 7);
        ListNode d = new ListNode(e, 6);
        ListNode c = new ListNode(d, 3);
        ListNode b = new ListNode(c, 2);
        ListNode a = new ListNode(b, 1);

        ListNode d1 = new ListNode(null, 7);
        ListNode c1 = new ListNode(d1, 6);
        ListNode b1 = new ListNode(c1, 5);
        ListNode a1 = new ListNode(b1, 4);

        ListNode l = FindFirstCommonNode1(a1, a);
        System.out.println(l.getData());
    }

    /**
     * 方法一:先减再找
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        int countA = getLengthOfList(pHead1);
        int countB = getLengthOfList(pHead2);
        int count = countA - countB;
        ListNode indexLong = pHead1;
        ListNode indexShort = pHead2;

        if (countB > countA) {
            indexLong = pHead2;
            indexShort = pHead1;
            count = countB - countA;
        }

        //长链表先走
        while (count > 0) {
            indexLong = indexLong.getNextNode();
            count--;
        }

        //两个链表同时走
        while (indexLong != null && indexShort != null && indexLong.getData() != indexShort.getData()) {
            indexLong = indexLong.getNextNode();
            indexShort = indexShort.getNextNode();
        }

        return indexLong;
    }

    public static int getLengthOfList(ListNode head) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.getNextNode();
        }
        return count;
    }


    /**
     * 方法二:判断是否存在环
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;

        return null;
    }
}
