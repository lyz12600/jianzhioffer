package 剑指offer;

/**
 * 二叉搜索树的后序遍历序列
 * Created by liyanzhen on 17/5/20.
 */
public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(verifySquenceOfBST(arr));
    }

    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length < 1)
            return false;
        return isBST(sequence, 0, sequence.length - 1);
    }

    public static boolean isBST(int[] arr, int start, int end) {
        if (start >= end)
            return true;
        int i = start;
        for (; i < end; i++) {
            if (arr[i] > arr[end])
                break;
        }
        for (int j = i; j < end; j++) {
            if (arr[j] < arr[end])
                return false;
        }
        return isBST(arr, start, i - 1) && isBST(arr, i, end - 1);
    }
}
