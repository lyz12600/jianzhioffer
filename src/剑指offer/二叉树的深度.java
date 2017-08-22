package 剑指offer;

import 剑指offer.bean.BTreeNode;

/**
 * 面试题39：
 * 二叉树的深度
 * Created by liyanzhen on 17/6/6.
 */
public class 二叉树的深度 {
    public static void main(String[] args) {
        BTreeNode g = new BTreeNode(7, null, null);
        BTreeNode f = new BTreeNode(6, null, null);
        BTreeNode e = new BTreeNode(5, g, null);
        BTreeNode d = new BTreeNode(4, null, null);
        BTreeNode c = new BTreeNode(3, null, f);
        BTreeNode b = new BTreeNode(2, d, e);
        BTreeNode a = new BTreeNode(1, b, c);

        System.out.println("树的深度为：" + TreeDepth(a));
    }

    public static int TreeDepth(BTreeNode root) {
        if (root == null)
            return 0;
        int left = TreeDepth(root.getLeftNode());
        int right = TreeDepth(root.getRightNode());
        return (left > right) ? left + 1 : right + 1;
    }
}
