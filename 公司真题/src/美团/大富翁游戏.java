package 美团;

import java.util.Scanner;

public class 大富翁游戏 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            System.out.println(sumMethod(n));
        }
    }

    public static int sumMethod(int n) {
        if (n < 1) {
            return 0;
        }

        return (int) Math.pow(2, n - 1);
    }
}
