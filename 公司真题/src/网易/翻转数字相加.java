package 网易;

import 阿里.Template;

import java.util.Scanner;

public class 翻转数字相加 {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("./公司真题/src/网易/input.txt");
        while (s.hasNextInt()) {
            int n = s.nextInt();

            System.out.println(solution(n));
        }
    }

    public static int solution(int n) {
        if (n < 1) {
            return -1;
        }

        int a = n, r = 0;
        while (a > 0) {
            r = r * 10 + a % 10;
            a = a / 10;
        }
        return r + n;
    }
}
