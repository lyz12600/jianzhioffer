package 剑指offer;

/**
 * 面试题：63
 * 二叉搜索树的第k个结点
 * Created by liyanzhen on 17/7/7.
 */
public class 二叉搜索树的第k个结点 {
    private static int num;

    public static BTreeNode KthNode(BTreeNode root, int k) {
        if (root == null || k == 0) {
            return null;
        }
        num = k;
        return KthNode1(root);
    }

    public static BTreeNode KthNode1(BTreeNode root) {
        BTreeNode target = null;
        if (root.left != null) { //当前结点是否存在左孩子
            target = KthNode1(root.left);
        }

        if (target == null && num == 1) {//没有左孩子返回该当前结点
            target = root;
        } else {
            num--;
        }

        if (target == null && root.right != null) {
            target = KthNode1(root.right);
        }

        return target;
    }

    public static void main(String[] args) {
        BTreeNode a = new BTreeNode(5);
        BTreeNode b = new BTreeNode(3);
        BTreeNode c = new BTreeNode(7);
        BTreeNode d = new BTreeNode(2);
        BTreeNode e = new BTreeNode(4);
        BTreeNode f = new BTreeNode(6);
        BTreeNode g = new BTreeNode(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(KthNode(a, 4).val);
    }
}
