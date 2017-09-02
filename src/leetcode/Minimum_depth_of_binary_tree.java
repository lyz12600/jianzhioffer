package leetcode;

public class Minimum_depth_of_binary_tree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        d.left = g;
        e.right = h;

        System.out.println(run(a));
    }

    public static int run(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = run(root.left);
        int right = run(root.right);
        if (left == 0 || right == 0) {
            return left + 1 + right;
        }
        return Math.min(left, right) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}