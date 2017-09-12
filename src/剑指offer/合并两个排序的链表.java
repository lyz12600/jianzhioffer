package 剑指offer;

import 剑指offer.bean.ListNode;

/**
 * 合并两个排序的链表
 * Created by liyanzhen on 17/5/17.
 */
public class 合并两个排序的链表 {
    public static void main(String[] args) {
        ListNode a4 = new ListNode(null, 6);
        ListNode a3 = new ListNode(a4, 4);
        ListNode a2 = new ListNode(a3, 2);
        ListNode a1 = new ListNode(a2, 0);

        ListNode b4 = new ListNode(null, 7);
        ListNode b3 = new ListNode(b4, 5);
        ListNode b2 = new ListNode(b3, 3);
        ListNode b1 = new ListNode(b2, 1);

        System.out.println(merge(a1, b1).getData());
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list2 == null ? list1 : list2;
        }

        ListNode mergeHead;
        if (list1.getData() < list2.getData()) {
            mergeHead = list1;
            mergeHead.setNextNode(merge(list1.getNextNode(), list2));
        } else {
            mergeHead = list2;
            mergeHead.setNextNode(merge(list1, list2.getNextNode()));
        }

        return mergeHead;
    }
}
