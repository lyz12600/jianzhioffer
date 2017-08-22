package 剑指offer;

import 剑指offer.bean.RandomListNode;

/**
 * 复杂链表的复制
 * Created by liyanzhen on 17/5/23.
 */
public class 复杂链表的复制 {
    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(null);

        a.setRandom(c);
        b.setRandom(e);
        d.setRandom(b);

        RandomListNode node = clone(a);
        print(node);
    }

    //    public static RandomListNode clone(RandomListNode pHead) {
//        copyNode(pHead);
//        setRandomNode(pHead);
//        return adjustNode(pHead);
//    }
//
//    //复制节点
//    public static void copyNode(RandomListNode head) {
//        RandomListNode node = head;
//        while (node != null) {
//            RandomListNode newNode = new RandomListNode();
//            newNode.setNext(node.getNext());
//            newNode.setLabel(node.getLabel());
//
//            node.setNext(newNode);
//            node = node.getNext().getNext();
//        }
//    }
//
//    //设置随意节点
//    public static void setRandomNode(RandomListNode head) {
//        RandomListNode node = head;
//        while (node != null) {
//            if (node.getRandom() != null) {
//                node.getNext().setRandom(node.getRandom().getNext());
//            }
//            node = node.getNext().getNext();
//        }
//    }
//
//    //调整节点关系
//    public static RandomListNode adjustNode(RandomListNode head) {
//        RandomListNode node = head;
//        RandomListNode mHead = node.getNext();
//        RandomListNode newNode = node.getNext();
//
//        while (node.getNext().getNext() != null && newNode.getNext().getNext() != null) {
//            node.setNext(newNode.getNext());
//            newNode.setNext(newNode.getNext().getNext());
//            node = node.getNext();
//            newNode = newNode.getNext();
//        }
//        return mHead;
//    }
//
    public static void print(RandomListNode node) {
        while (node != null) {
            System.out.print(node.getLabel() + " ");
            if (node.getRandom() != null) {
                System.out.print("random" + node.getRandom().getLabel() + " ");
            }
            node = node.getNext();
        }
    }

    public static RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode head = new RandomListNode(pHead.getLabel());
        RandomListNode ans = head;
        if (pHead.getRandom() != null) {
            head.setRandom(new RandomListNode(pHead.getRandom().getLabel()));
        }
        while (pHead.getNext() != null) {
            pHead = pHead.getNext();
            head.setNext(new RandomListNode(pHead.getLabel()));
            if (pHead.getRandom() != null) {
                head.getNext().setRandom(new RandomListNode(pHead.getRandom().getLabel()));
            }
            head = head.getNext();
        }
        return ans;
    }
}
