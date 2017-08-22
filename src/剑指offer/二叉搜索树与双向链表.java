package 剑指offer;

import 剑指offer.bean.BTreeNode;

/**
 * 二叉搜索树与双向链表
 * Created by liyanzhen on 17/5/23.
 */
public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        BTreeNode g = new BTreeNode(16, null, null);
        BTreeNode f = new BTreeNode(12, null, null);
        BTreeNode e = new BTreeNode(8, null, null);

        BTreeNode d = new BTreeNode(4, null, null);
        BTreeNode c = new BTreeNode(14, f, g);
        BTreeNode b = new BTreeNode(6, d, e);
        BTreeNode a = new BTreeNode(10, b, c);
        System.out.println(convert(a).getRightNode().getRightNode().getRightNode().getData());
    }

    public static BTreeNode convert(BTreeNode root) {
        if (root == null)
            return null;
        if (root.getLeftNode() == null && root.getRightNode() == null)//子结点
            return root;

        BTreeNode left = convert(root.getLeftNode());
        BTreeNode p = left;

        while (p != null && p.getRightNode() != null) {
            p = p.getRightNode();
        }

        if (left != null) {
            p.setRightNode(root);
            root.setLeftNode(p);
        }

        BTreeNode right = convert(root.getRightNode());
        if (right != null) {
            root.setRightNode(right);
            right.setLeftNode(root);
        }
        return left != null ? left : root;
    }
}
