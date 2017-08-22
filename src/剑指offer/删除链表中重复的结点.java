package 剑指offer;

/**
 * 面试题：57
 * 删除链表中重复的结点
 * Created by liyanzhen on 17/7/4.
 */
public class 删除链表中重复的结点 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(1);
        ListNode f = new ListNode(1);
        ListNode g = new ListNode(1);
        ListNode h = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        ListNode head = deleteDuplication(a);
        while (head != null) {
            System.out.print(head.val + "--->");
            head = head.next;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode head = new ListNode(0);//头结点

        ListNode pre = head;
        ListNode index = pHead;
        ListNode next = pHead.next;

        if (next != null && index.val != next.val) {
            pre.next = index;
            pre = index;
            index = next;
            next = index.next;
        }

        while (next != null) {
            if (index.val != next.val) {
                pre.next = index;
                pre = index;
                index = next;
                next = index.next;
            } else {
                while (index.val == next.val) {
                    next = next.next;
                    if (next == null) {//判断是否结束
                        pre.next = null;
                        return head.next;
                    }
                }
                index = next;
                next = index.next;
            }
        }

        pre.next = index;
        return head.next;
    }
}
