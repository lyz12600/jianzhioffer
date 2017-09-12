package 剑指offer;


/**
 * 链表中倒数第k个结点
 * Created by liyanzhen on 17/5/17.
 */
public class 链表中倒数第k个结点 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        if (FindKthToTail(a, 2) == null) {
            System.out.println("");
        } else {
            System.out.println((FindKthToTail(a, 2)).val);
        }
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        ListNode node = head;
        while (k > 1 && node.next != null) {
            node = node.next;
            k--;
        }

        if (k != 1) {
            return null;
        }

        while (node.next != null && head.next != null) {
            node = node.next;
            head = head.next;
        }
        return head;
    }
}

