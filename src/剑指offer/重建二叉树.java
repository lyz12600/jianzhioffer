package 剑指offer;

import 剑指offer.bean.BTreeNode;

/**
 * Created by liyanzhen on 17/3/10.
 * 重建二叉树
 */

public class 重建二叉树 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 3, 5, 6, 8};//前序遍历
        int[] brr = {4, 7, 2, 1, 5, 3, 8, 6};//中序遍历
        BTreeNode node = reConstructBinaryTree(arr, brr);
        System.out.println(node.getRightNode());
    }

    public static BTreeNode reConstructBinaryTree(int[] pre, int[] in) {
        BTreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static BTreeNode reConstructBinaryTree(int[] pre, int a0, int a1, int[] in, int b0, int b1) {

        if (a0 > a1 || b0 > b1)
            return null;
        BTreeNode root = new BTreeNode(pre[a0]);

        for (int i = b0; i <= b1; i++) {
            if (in[i] == pre[a0]) {
                root.setLeftNode(reConstructBinaryTree(pre, a0 + 1, a0 + i - b0, in, b0, i - 1));
                root.setRightNode(reConstructBinaryTree(pre, i - b0 + a0 + 1, a1, in, i + 1, b1));
            }
        }
        return root;
    }
}