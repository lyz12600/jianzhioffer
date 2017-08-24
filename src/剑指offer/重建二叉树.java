package 剑指offer;

/**
 * Created by liyanzhen on 17/3/10.
 * 重建二叉树
 */

public class 重建二叉树 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        BTreeNode01 root = reConstructBinaryTree(pre, in);
        print(root);
    }

    public static void print(BTreeNode01 node) {
        if (node == null) {
            return;
        }
        BTreeNode01 root = node;
        if (root.left != null) {
            print(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            print(root.right);
        }
    }

    public static BTreeNode01 reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length < 1 || in == null || in.length < 1 || in.length != pre.length) {
            return null;
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static BTreeNode01 reConstructBinaryTree(int[] pre, int start0, int end0, int[] in, int start1, int end1) {
        if (start0 > end0 || start1 > end1) {
            return null;
        }
        BTreeNode01 root = new BTreeNode01(pre[start0]);
        for (int i = start1; i <= end1; i++) {
            if (pre[start0] == in[i]) {
                root.left = reConstructBinaryTree(pre, start0 + 1, i + start0 - start1, in, start1, i - 1);
                root.right = reConstructBinaryTree(pre, i + 1 - start1 + start0, end0, in, i + 1, end1);
            }
        }
        return root;
    }
}

