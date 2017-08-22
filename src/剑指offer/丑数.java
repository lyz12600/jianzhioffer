package 剑指offer;

import java.util.Scanner;

/**
 * 丑数
 * Created by liyanzhen on 17/6/3.
 */
public class 丑数 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int index = s.nextInt();
            System.out.println(GetUglyNumber_Solution1(index));
            System.out.println(GetUglyNumber_Solution2(index));
        }
    }

    /**
     * 暴力法
     *
     * @param index
     * @return
     */
    public static int GetUglyNumber_Solution1(int index) {
        if (index <= 0)
            return 0;
        int count = 0;
        int i = 0;
        while (count < index) {//第七个丑数，不是到n的丑数
            ++i;
            if (isUglyNumber(i)) {
                count++;
            }
        }
        return i;
    }

    public static boolean isUglyNumber(int i) {
        while (i % 2 == 0)
            i /= 2;
        while (i % 3 == 0)
            i /= 3;
        while (i % 5 == 0)
            i /= 5;

        return i == 1 ? true : false;
    }

    /**
     * 优化法
     */
    public static int GetUglyNumber_Solution2(int index) {
        if (index <= 0)
            return 0;
        int[] result = new int[index];
        int count = 0;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        result[0] = 1;
        int tmp;
        while (count < index - 1) {
            tmp = min(result[i2] * 2, min(result[i3] * 3, result[i5] * 5));
            if (tmp == result[i2] * 2) i2++;//三条if防止值是一样的，不要改成else的
            if (tmp == result[i3] * 3) i3++;
            if (tmp == result[i5] * 5) i5++;
            result[++count] = tmp;
        }
        return result[index - 1];
    }

    private static int min(int a, int b) {
        return (a > b) ? b : a;
    }
}
