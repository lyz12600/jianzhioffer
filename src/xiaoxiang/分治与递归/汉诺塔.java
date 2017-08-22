package xiaoxiang.分治与递归;

import java.util.Scanner;

/**
 * A n个不同大小的盘子
 * B 过渡盘子
 * C 最终的盘子
 * <p>
 * Created by liyanzhen on 17/6/29.
 */
public class 汉诺塔 {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    private static int count;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            count = 0;
            int n = s.nextInt();
            move(A, C, B, n);
            System.out.println(count);
            System.out.println(getCount(n));
        }
    }


    /**
     * 方法一：
     * 递归做法
     *
     * @param from
     * @param to
     * @param aux
     * @param n
     */
    public static void move(int from, int to, int aux, int n) {
        if (n == 1) {
            moveOne(from, to);
            return;
        }

        move(from, aux, to, n - 1);//A移动到B
        moveOne(from, to);//A移动到C
        move(aux, to, from, n - 1);//B移动到C
    }

    public static int moveOne(int from, int to) {
        count++;
        System.out.println("from--->" + from + "======" + "to--->" + to);
        return count;
    }

    /**
     * 方法二：
     * 直接计算移动次数
     *
     * @param n
     * @return
     */
    public static int getCount(int n) {
//        return (int) Math.pow(2, n) - 1;
        return (1 << n) - 1;
    }
}
