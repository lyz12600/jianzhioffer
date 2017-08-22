package xiaoxiang.分治与递归;

import java.util.Scanner;

/**
 * AAA
 * 最小的位于第一个位置
 * 次大的位于第二个位置
 * 最大的位于第三个位置
 * <p>
 * 解释：
 * 将前n－1个盘子移动到aux上 -->2的n－1次方—1
 * 将最大的盘子移动到to上 --> 1次
 * 将前n－1个盘子移动到to上 -->2的n－1次方－1
 * <p>
 * Created by liyanzhen on 17/6/29.
 */
public class 汉诺塔状态 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            char[] arr = s.nextLine().toCharArray();
            System.out.println(isState(arr, arr.length, 'A', 'C', 'B'));
        }
    }

    public static int isState(char[] str, int size, char from, char to, char aux) {
        if (size == 0) {// 做完了，0个盘子
            return 0;
        }
        if (str[size - 1] == aux) {//最大的盘子位于辅助柱子上
            return -1;
        }

        if (str[size - 1] == to) { //最大的位于目标位置
            int n = isState(str, size - 1, aux, to, from);//后
            if (n == -1)
                return -1;
            //(1 << n - 1)---->2的n次方减1
            //前半段2的n－1次方－1
            //中间段1次
            //所以是2的n－1次方
            return ((1 << (size - 1)) + n); //前＋中＋后
        }
        return isState(str, size - 1, from, aux, to);
    }
}
