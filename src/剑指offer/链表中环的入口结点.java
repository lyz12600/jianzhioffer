package 剑指offer;


/**
 * Created by liyanzhen on 17/7/3.
 */

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class 链表中环的入口结点 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = c;

        System.out.println(EntryNodeOfLoop(a).val);
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;

        //得到环中相遇的结点
        ListNode meet = meetPointListNode(pHead);
        if (meet == null)
            return null;
        int count = 1;

        ListNode index = pHead;
        while (index != null && meet != null && index != meet) {
            index = index.next;
            meet = meet.next;
        }
        return meet;
//        ListNode slow = meet.next;
//        ListNode fast = slow.next;
//
//        while (slow != null && fast != null && slow != fast) {
//            count++;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        //继续循环得到环结点的值
//        slow = pHead;
//        fast = pHead;
//        while (count > 0) {
//            fast = fast.next;
//            count--;
//        }
//        //从头进行指针行走
//        while (slow != fast) {
//            slow = slow.next;
//            fast = fast.next;
//        }
//        meet = slow;
//        return meet;
    }

    /**
     * 判断是否存在环
     *
     * @param pHead
     * @return
     */
    public static ListNode meetPointListNode(ListNode pHead) {
        if (pHead == null)
            return null;

        ListNode slow = pHead.next;
        if (slow == null)
            return null;

        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (fast == slow)
                return fast;

            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
