package 剑指offer;

import java.util.Scanner;

/**
 * 面试题:32
 * 从1到n整数中1出现的次数
 * Created by liyanzhen on 17/5/31.
 */
public class 从1到n整数中1出现的次数 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
//            System.out.println(NumberOf1Between1AndN_Solution1(n));
            System.out.println(NumberOf1Between1AndN_Solution2(n));
        }
    }

    /**
     * 暴力法
     *
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution1(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int temp = i;
            //如果temp的任意位为1则count++
            while (temp != 0) {
                if (temp % 10 == 1) {
                    count++;
                }
                temp /= 10;
            }
        }
        return count;
    }

    /**
     * 找规律
     *
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution2(int n) {
        if (n < 1)
            return 0;
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;
            int b = n % i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
        }
        return count;
    }
}
