package 剑指offer;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/6/25.
 */
public class 不用加减乘除做加法 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println(Add(a, b));
        }
    }

    public static int Add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }
}
