package leetcode;

public class Sort_list {
    public static void main(String[] args) {
        ListNode a = new ListNode(6);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(8);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode head = sortList(a);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        ListNode list1 = null;
        ListNode list2 = null;
        if (head != head2) {
            list1 = sortList(head);
            list2 = sortList(head2);
        }

        return merge(list1, list2);
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                p.next = head1;
                p = p.next;
                head1 = head1.next;
            } else {
                p.next = head2;
                p = p.next;
                head2 = head2.next;
            }
        }

        if (head1 != null) {
            p.next = head1;
        }
        if (head2 != null) {
            p.next = head2;
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}