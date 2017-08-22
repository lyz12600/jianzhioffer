package leetcode.回文;

/**
 * Created by liyanzhen on 17/7/17.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class 回文链表 {
    private static ListNode index;
    private static boolean res = true;

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(3);
        ListNode g = new ListNode(2);
        ListNode h = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        System.out.println(isPalindrome(a));
    }

    /**
     * 方法一：
     * 递归
     *
     * @param head
     * @return
     */
//    public static boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//        index = head;
//        return findTail(head);
//    }
//
//    public static boolean findTail(ListNode head) {
//        boolean temp;
//        if (head.next != null) {
//            findTail(head.next);
//        }
//        if (head.val == index.val) {
//            temp = true;
//        } else {
//            temp = false;
//        }
//        index = index.next;
//        res &= temp;
//        return res;
//    }

    /**
     * 方法二：
     * 找到中间结点，截断翻转然后比较
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);

        ListNode p1 = head, p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2 == null;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    private static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
