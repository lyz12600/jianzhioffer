package 剑指offer.bean;

/**
 * Created by liyanzhen on 17/3/10.
 */
public class BTreeNode {
    int data;
    BTreeNode leftNode;
    BTreeNode rightNode;

    public BTreeNode(int data) {
        this.data = data;

    }

    public BTreeNode(int data, BTreeNode leftNode, BTreeNode rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
