package 剑指offer;

import 剑指offer.bean.BTreeNode;


/**
 * 树的子结构
 * Created by liyanzhen on 17/5/17.
 */
public class 树的子结构 {
    public static void main(String[] args) {
        TreeNode1 a = new TreeNode1(8);
        TreeNode1 b = new TreeNode1(8);
        TreeNode1 c = new TreeNode1(7);
        TreeNode1 d = new TreeNode1(9);
        TreeNode1 e = new TreeNode1(2);
        TreeNode1 f = new TreeNode1(4);
        TreeNode1 g = new TreeNode1(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;
        System.out.println(HasSubtree(a, b));
    }

    public static boolean HasSubtree(TreeNode1 root1, TreeNode1 root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HasTree2(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public static boolean doesTree1HasTree2(TreeNode1 root1, TreeNode1 root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }
}

class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;
    }
}
