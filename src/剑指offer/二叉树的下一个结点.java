package 剑指offer;

/**
 * Created by liyanzhen on 17/7/5.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class 二叉树的下一个结点 {
    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);
        TreeLinkNode d = new TreeLinkNode(4);
        TreeLinkNode e = new TreeLinkNode(5);
        TreeLinkNode f = new TreeLinkNode(6);
        TreeLinkNode g = new TreeLinkNode(7);
        TreeLinkNode h = new TreeLinkNode(8);
        TreeLinkNode i = new TreeLinkNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = h;
        e.right = i;
        c.left = f;
        c.right = g;
        System.out.println(GetNext(b).val);
    }

    public static TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {  //有右子树时，返回该右子树的左子结点
            node = node.right;
            while (node.left != null) {
                node = node.left;

            }
            return node;
        }
        while (node.next != null) {
            if (node.next.left == node) { //该结点是其父结点的左子树
                return node.next;
            }
            node = node.next;
        }
        return null;
    }
}
