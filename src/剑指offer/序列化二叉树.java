package 剑指offer;

/**
 * 面试题62:
 * 序列化二叉树
 * Created by liyanzhen on 17/7/5.
 */
public class 序列化二叉树 {
    private static int index = -1;

    public static String Serialize(BTreeNode root) {
        if (root == null) {
            return "$,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return String.valueOf(sb);
    }

    public static BTreeNode Deserialize(String str) {
        if (str == null) {
            return null;
        }

        String[] strings = str.split(",");
        return Deserialize2(strings);
    }

    public static BTreeNode Deserialize2(String[] str) {
        index++;
        if (!str[index].equals("$")) {
            BTreeNode root = new BTreeNode(0);
            root.val = Integer.parseInt(str[index]);
            root.left = Deserialize2(str);
            root.right = Deserialize2(str);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        BTreeNode a = new BTreeNode(1);
        BTreeNode b = new BTreeNode(2);
        BTreeNode c = new BTreeNode(3);
        BTreeNode d = new BTreeNode(4);
        BTreeNode e = new BTreeNode(5);
        BTreeNode f = new BTreeNode(6);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;

        System.out.println(Serialize(a));

        String str = "1,2,4,$,$,$,3,5,$,$,6,$,$";
        BTreeNode index = Deserialize(str);
        System.out.println(index.val + "---left--->" + index.left.val + "---right--->" + index.right.val);
    }
}
