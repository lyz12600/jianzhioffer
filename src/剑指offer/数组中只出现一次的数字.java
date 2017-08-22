package 剑指offer;

/**
 * 数组中只出现一次的数字
 * 面试题：40
 * 一个整型数组中除了两个数字外，其他的数字都出现了两次
 * 时间复杂度：O(1)
 * Created by liyanzhen on 17/6/12.
 */
public class 数组中只出现一次的数字 {
    public static void main(String args[]) {
        int[] arr = {1, 1, 3, 5, 2, 2};
        int[] a = new int[6];
        int[] b = new int[6];
        FindNumsAppearOnce(arr, a, b);
    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 1)
            return;
        int resultOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultOR ^= array[i];
        }

        int index = findFirstIndex(resultOR);

        num1[0] = num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (IsBitl(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

        System.out.println(num1[0] + " " + num2[0]);
    }

    public static int findFirstIndex(int resultOR) {
        int index = 0;
        while ((resultOR & 1) == 0) {
            resultOR = resultOR >> 1;
            index++;
        }
        return index;
    }

    public static boolean IsBitl(int num, int index) {
        num = num >> index;
        if ((num & 1) == 1)
            return true;
        return false;
    }
}
