package 剑指offer;

import 剑指offer.bean.BTreeNode;

import java.util.ArrayList;

/**
 * 从上往下打印二叉树
 * Created by liyanzhen on 17/5/20.
 */
public class 从上往下打印二叉树 {
    public static void main(String[] args) {
        BTreeNode g = new BTreeNode(11, null, null);
        BTreeNode f = new BTreeNode(9, null, null);
        BTreeNode e = new BTreeNode(7, null, null);
        BTreeNode d = new BTreeNode(5, null, null);
        BTreeNode c = new BTreeNode(10, f, g);
        BTreeNode b = new BTreeNode(6, d, e);
        BTreeNode a = new BTreeNode(8, b, c);

        ArrayList<Integer> list = PrintFromTopToBottom(a);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> PrintFromTopToBottom(BTreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<BTreeNode> temp = new ArrayList<>();

        list.add(root.getData());
        temp.add(root);
        while (temp != null && temp.size() > 0) {
            BTreeNode index = temp.get(0);
            if (index.getLeftNode() != null) {
                temp.add(index.getLeftNode());
                list.add(index.getLeftNode().getData());
            }
            if (index.getRightNode() != null) {
                temp.add(index.getRightNode());
                list.add(index.getRightNode().getData());
            }
            temp.remove(index);
        }
        return list;
    }
}
