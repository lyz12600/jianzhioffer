package 剑指offer;

import java.util.Scanner;

/**
 * 二进制中1的个数
 * Created by liyanzhen on 17/5/13.
 */
public class 二进制中1的个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int target = scanner.nextInt();
            System.out.println(calculateNumberOne(target));
        }
    }

    public static int calculateNumberOne(int target) {
        int count = 0;
        while (target != 0) {
            target = target & (target - 1);
            ++count;
        }
        return count;
    }
}
