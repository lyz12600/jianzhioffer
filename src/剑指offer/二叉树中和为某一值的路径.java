package 剑指offer;

import 剑指offer.bean.BTreeNode;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * Created by liyanzhen on 17/5/22.
 */
public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        BTreeNode e = new BTreeNode(7, null, null);
        BTreeNode d = new BTreeNode(4, null, null);
        BTreeNode c = new BTreeNode(12, null, null);
        BTreeNode b = new BTreeNode(5, d, e);
        BTreeNode a = new BTreeNode(10, b, c);

        ArrayList<ArrayList<Integer>> array = findPath(a, 22);
        for (ArrayList<Integer> list : array) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> findPath(BTreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        findPath(root, target, res, list, 0);
        return res;
    }

    public static void findPath(BTreeNode root, int target, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> list, int sum) {
        if (root == null) {
            return;
        }
        sum += root.getData();
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            if (sum == target) {
                list.add(root.getData());
                arr.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(root.getData());
        findPath(root.getLeftNode(), target, arr, list, sum);
        findPath(root.getRightNode(), target, arr, list, sum);
        list.remove(list.size() - 1);
    }
}
