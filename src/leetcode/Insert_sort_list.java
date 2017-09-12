package leetcode;

public class Insert_sort_list {
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

        ListNode node = insertionSortList(a);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = new ListNode(0);
        ListNode node = head;
        pre.next = node;

        ListNode index = head.next;
        ListNode p;
        ListNode temp;

        while (index != null) {
            temp = index.next;
            if (index.val >= node.val) {
                node.next = index;
                node = node.next;
            } else {
                p = pre;
                while (p != null && p.next != null && p.next.val < index.val) {
                    p = p.next;
                }
                index.next = p.next;
                p.next = index;
            }
            index = temp;
        }
        node.next = null;
        return pre.next;
    }
}

