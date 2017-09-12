package leetcode;

import java.util.ArrayList;

public class Binary_tree_postorder_traversal {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.right = c;
        ArrayList<Integer> list = postorderTraversal(a);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        postorderTraversal(root, list);
        return list;
    }

    public static void postorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if (root.left != null) {
            postorderTraversal(root.left, list);
        }
        if (root.right != null) {
            postorderTraversal(root.right, list);
        }
        list.add(root.val);
    }
}