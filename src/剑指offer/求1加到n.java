package 剑指offer;

import java.util.Scanner;

/**
 * 求1+2+...＋n，
 * 要求不能用乘除法、for、while、if、
 * else、switch、case等关键字及条件判断语句（A?B:C）
 * Created by liyanzhen on 17/6/25.
 */
public class 求1加到n {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            System.out.println(Sum_Solution(n));
        }
    }

    public static int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
