package 剑指offer;

import 剑指offer.bean.ListNode;

/**
 * Created by liyanzhen on 17/5/14.
 * 在O(1)时间删除链表结点
 */
public class 在O1时间删除链表结点 {
    public static void main(String[] args) {
        ListNode e = new ListNode(null, 5);
        ListNode d = new ListNode(e, 4);
        ListNode c = new ListNode(d, 3);
        ListNode b = new ListNode(c, 2);
        ListNode a = new ListNode(b, 1);

        ListNode node = deleteNode(a, e);
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNextNode();
        }
    }

    public static ListNode deleteNode(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return null;
        }

        //链表只有一个结点，删除头结点，也是尾结点
        if (head == node) {
            head = null;
            node = null;
            return null;
        }// 要删除的结点不是尾结点
        else if (node.getNextNode() != null) {
            node.setData(node.getNextNode().getData());
            node.setNextNode(node.getNextNode().getNextNode());
        }//链表中有多个结点，删除尾结点
        else {
            ListNode index = head;
            while (index.getNextNode() != node) {
                index = index.getNextNode();
            }
            index.setNextNode(node.getNextNode());
        }
        return head;
    }
}
