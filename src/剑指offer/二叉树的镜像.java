package 剑指offer;

import 剑指offer.bean.BTreeNode;

/**
 * 二叉树的镜像
 * 8                8
 * 6  10          10  6
 * 5 7  9 11     11 9 7 5
 * <p>
 * Created by liyanzhen on 17/5/18.
 */
public class 二叉树的镜像 {
    public static void main(String[] args) {
        BTreeNode g1 = new BTreeNode(7, null, null);
        BTreeNode f1 = new BTreeNode(4, null, null);
        BTreeNode e1 = new BTreeNode(2, f1, g1);
        BTreeNode d1 = new BTreeNode(9, null, null);
        BTreeNode c1 = new BTreeNode(7, null, null);
        BTreeNode b1 = new BTreeNode(8, d1, e1);
        BTreeNode a1 = new BTreeNode(8, b1, c1);

        mirrorRecursively(a1);
        System.out.println(b1.getLeftNode().getData());
    }

    public static void mirrorRecursively(BTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeftNode() == null && node.getRightNode() == null) {
            return;
        }

        BTreeNode temp = node.getLeftNode();
        node.setLeftNode(node.getRightNode());
        node.setRightNode(temp);
        mirrorRecursively(node.getLeftNode());
        mirrorRecursively(node.getRightNode());
    }
}
