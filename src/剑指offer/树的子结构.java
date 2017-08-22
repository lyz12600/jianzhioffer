package 剑指offer;

import 剑指offer.bean.BTreeNode;


/**
 * 树的子结构
 * Created by liyanzhen on 17/5/17.
 */
public class 树的子结构 {
    public static void main(String[] args) {
        BTreeNode g1 = new BTreeNode(7, null, null);
        BTreeNode f1 = new BTreeNode(4, null, null);
        BTreeNode e1 = new BTreeNode(2, f1, g1);
        BTreeNode d1 = new BTreeNode(9, null, null);
        BTreeNode c1 = new BTreeNode(7, null, null);
        BTreeNode b1 = new BTreeNode(8, d1, e1);
        BTreeNode a1 = new BTreeNode(8, b1, c1);

        BTreeNode c2 = new BTreeNode(2, null, null);
        BTreeNode b2 = new BTreeNode(9, null, null);
        BTreeNode a2 = new BTreeNode(8, b2, c2);

        System.out.println(HasSubtree(a1, a2));
    }

    public static boolean HasSubtree(BTreeNode root1, BTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.getData() == root2.getData())
                result = doesTree1HasTree2(root1, root2);

            if (!result)
                result = HasSubtree(root1.getLeftNode(), root2);

            if (!result)
                result = HasSubtree(root1.getRightNode(), root2);

        }
        return result;
    }

    public static boolean doesTree1HasTree2(BTreeNode root1, BTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.getData() != root2.getData()) {
            return false;
        }

        return doesTree1HasTree2(root1.getLeftNode(), root2.getLeftNode())
                && doesTree1HasTree2(root1.getRightNode(), root2.getRightNode());
    }
}
