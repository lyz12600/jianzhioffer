package leetcode;

import java.util.ArrayList;

public class Binary_tree_preorder_traversal {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;
        ArrayList<Integer> list = preorderTraversal(a);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        preorderTraversal(root, list);
        return list;
    }

    public static void preorderTraversal(TreeNode root, ArrayList<Integer> list) {
        list.add(root.val);

        if (root.left != null) {
            preorderTraversal(root.left, list);
        }
        if (root.right != null) {
            preorderTraversal(root.right, list);
        }
    }
}
