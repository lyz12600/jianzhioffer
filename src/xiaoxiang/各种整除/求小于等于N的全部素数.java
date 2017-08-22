package xiaoxiang.各种整除;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 求小于等于N的全部素数
 * Created by liyanzhen on 17/6/29.
 */
public class 求小于等于N的全部素数 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            byte[] arr = getAllPrime(n + 1);
            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (arr[i] == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static byte[] getAllPrime(int n) {
        if (n < 2 || n > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("输入的参数有误！");
        }
        byte[] arr = new byte[n + 1];
        arr[0] = arr[1] = -1;//0和1既不是合数也不是素数

        //最小的素数从2开始
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
        }
        return arr;
    }
}
