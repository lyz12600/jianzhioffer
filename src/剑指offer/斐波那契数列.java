package 剑指offer;


/**
 * Created by liyanzhen on 17/5/10.
 * 斐波那契数列
 */
public class 斐波那契数列 {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        int sum1 = originFibonacci(30);
        System.out.println(System.currentTimeMillis() - time1 + "***originFibonacci***" + sum1);

        long time2 = System.currentTimeMillis();
        int sum2 = optiFibonacci(30);
        System.out.println(System.currentTimeMillis() - time2 + "***optiFibonacci***" + sum2);
    }

    /**
     * 原始的斐波那契
     *
     * @param n
     * @return
     */
    public static int originFibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        switch (n) {
            case 1:
                return 1;
            default:
                return originFibonacci(n - 1) + originFibonacci(n - 2);
        }
    }

    /**
     * 优化后的斐波那契
     *
     * @param n
     */
    public static int optiFibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        int sum = 0;
        int fisrt = 1;
        int second = 0;
        switch (n) {
            case 1:
                return 1;
            default:
                for (int i = 2; i <= n; i++) {
                    sum = fisrt + second;
                    second = fisrt;
                    fisrt = sum;
                }
                return sum;
        }
    }
}
