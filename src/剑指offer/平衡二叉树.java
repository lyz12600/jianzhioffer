package 剑指offer;

import 剑指offer.bean.BTreeNode;

/**
 * 平衡二叉树
 * Created by liyanzhen on 17/6/6.
 */
public class 平衡二叉树 {

    public static void main(String[] args) {
        BTreeNode h = new BTreeNode(8, null, null);
        BTreeNode g = new BTreeNode(7, h, null);
        BTreeNode f = new BTreeNode(6, null, null);
        BTreeNode e = new BTreeNode(5, g, null);
        BTreeNode d = new BTreeNode(4, null, null);
        BTreeNode c = new BTreeNode(3, null, f);
        BTreeNode b = new BTreeNode(2, d, e);
        BTreeNode a = new BTreeNode(1, b, c);

        System.out.println(IsBalanced_Solution(a));
        System.out.println(IsBalanced_Solution1(a));
    }

    /**
     * 方法一：求子树的深度
     *
     * @param root
     * @return
     */
    public static boolean IsBalanced_Solution(BTreeNode root) {
        if (root == null)
            return true;
        int left = TreeDepth(root.getLeftNode());
        int right = TreeDepth(root.getRightNode());
        int diff = left - right;
        if (diff > 1 || diff < -1)
            return false;
        return IsBalanced_Solution(root.getLeftNode()) && IsBalanced_Solution(root.getRightNode());
    }

    public static int TreeDepth(BTreeNode root) {
        if (root == null)
            return 0;
        int left = TreeDepth(root.getLeftNode());
        int right = TreeDepth(root.getRightNode());
        return (left > right) ? left + 1 : right + 1;
    }

    /**
     * 方法二：
     * 后序遍历法求解
     * 每个结点只访问一次的解法
     */
    private static boolean isBalanced = true;

    public static boolean IsBalanced_Solution1(BTreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    public static int getDepth(BTreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.getLeftNode());
        int right = getDepth(root.getRightNode());

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return right > left ? right + 1 : left + 1;
    }
}
