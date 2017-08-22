package 剑指offer.bean;


/**
 * Created by liyanzhen on 17/3/10.
 */
public class ListNode {
    ListNode nextNode;
    int data;

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode(ListNode nextNode, int data) {
        this.nextNode = nextNode;
        this.data = data;
    }

    public ListNode(int data) {
        this.data = data;
    }
}
