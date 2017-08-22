package trainning;

/**
 * Created by liyanzhen on 17/3/26.
 */
public class Solution {
    public static void main(String[] args) {
        TreeLinkNode t5 = new TreeLinkNode(5, null, null);
        TreeLinkNode t4 = new TreeLinkNode(4, null, null);
        TreeLinkNode t3 = new TreeLinkNode(3, null, t5);
        TreeLinkNode t2 = new TreeLinkNode(2, t4, null);
        TreeLinkNode t1 = new TreeLinkNode(1, t2, t3);
        TreeLinkNode root = t4;
        connect(t1);
        while (root != null) {
            System.out.print(root.val);
            if (root.next == null) {
                System.out.print("#");
            } else {
                System.out.print(root.next.val);
            }
            root = root.next;
        }
    }

    public static void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode lastHead = root;//prevous level's head
        TreeLinkNode lastCurrent = null;//previous level's pointer
        TreeLinkNode currentHead = null;//currnet level's head
        TreeLinkNode current = null;//current level's pointer

        while (lastHead != null) {
            lastCurrent = lastHead;

            while (lastCurrent != null) {
                //left child is not null
                if (lastCurrent.left != null) {
                    if (currentHead == null) {
                        currentHead = lastCurrent.left;
                        current = lastCurrent.left;
                    } else {
                        current.next = lastCurrent.left;
                        current = current.next;
                    }
                }

                //right child is not null
                if (lastCurrent.right != null) {
                    if (currentHead == null) {
                        currentHead = lastCurrent.right;
                        current = lastCurrent.right;
                    } else {
                        current.next = lastCurrent.right;
                        current = current.next;
                    }
                }

                lastCurrent = lastCurrent.next;
            }

            //update last head
            lastHead = currentHead;
            currentHead = null;
        }
    }
}


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }

    public TreeLinkNode(int val, TreeLinkNode left, TreeLinkNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}