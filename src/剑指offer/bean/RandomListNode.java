package 剑指offer.bean;

/**
 * Created by liyanzhen on 17/5/23.
 */
public class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode() {
    }

    public RandomListNode(int label) {
        this.label = label;
    }

    public RandomListNode(int label, RandomListNode next, RandomListNode random) {
        this.label = label;
        this.next = next;
        this.random = random;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public RandomListNode getNext() {
        return next;
    }

    public void setNext(RandomListNode next) {
        this.next = next;
    }

    public RandomListNode getRandom() {
        return random;
    }

    public void setRandom(RandomListNode random) {
        this.random = random;
    }
}
