package 剑指offer;

import java.util.*;

/**
 * Created by liyanzhen on 17/7/5.
 */
public class 把二叉树打印成多行 {
    public static void main(String[] args) {
        BTreeNode a = new BTreeNode(8);
        BTreeNode b = new BTreeNode(6);
        BTreeNode c = new BTreeNode(10);
        BTreeNode d = new BTreeNode(5);
        BTreeNode e = new BTreeNode(7);
        BTreeNode f = new BTreeNode(9);
        BTreeNode g = new BTreeNode(11);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        ArrayList<ArrayList<Integer>> res = print(a);
        for (ArrayList<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> print(BTreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<BTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                BTreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }

        for (int i = 1; i < res.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }
}
