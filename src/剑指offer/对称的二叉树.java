package 剑指offer;

/**
 * Created by liyanzhen on 17/7/5.
 */

class BTreeNode {
    int val = 0;
    BTreeNode left = null;
    BTreeNode right = null;

    public BTreeNode(int val) {
        this.val = val;
    }
}

public class 对称的二叉树 {
    public static void main(String[] args) {
        BTreeNode a = new BTreeNode(8);
        BTreeNode b = new BTreeNode(6);
        BTreeNode c = new BTreeNode(6);
        BTreeNode d = new BTreeNode(5);
        BTreeNode e = new BTreeNode(7);
        BTreeNode f = new BTreeNode(7);
        BTreeNode g = new BTreeNode(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(isSymmetrical(a));
    }

    public static boolean isSymmetrical(BTreeNode a) {
        return isSymmetrical(a, a);
    }

    public static boolean isSymmetrical(BTreeNode root1, BTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}
