package 剑指offer;

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
        TreeNode1 a = new TreeNode1(8);
        TreeNode1 b = new TreeNode1(6);
        TreeNode1 c = new TreeNode1(10);
        TreeNode1 d = new TreeNode1(5);
        TreeNode1 e = new TreeNode1(7);
        TreeNode1 f = new TreeNode1(9);
        TreeNode1 g = new TreeNode1(11);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        Mirror(a);
        System.out.println(c.val);
        System.out.println(c.left.val);
        System.out.println(c.right.val);
    }

    public static void Mirror(TreeNode1 root) {
        if (root == null) {
            return;
        }
        TreeNode1 temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}

