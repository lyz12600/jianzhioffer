package bishi;

import aaa.Template;

import java.util.Scanner;

/**
 * 现在给出一个整数n,表示已给的提示的长度。请计算出长度为n的合法的提示的个数。
 * 例如 n = 5:
 * 合法的提示有:
 * YNNNN YNNNY YNYNN YNYNY YYNNN YYNNY
 * YYNYN YYNYY YYYNN YYYNY YYYYN YYYYY
 * 所以输出12
 * Created by liyanzhen on 17/3/25.
 */

public class Main {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/bishi/input.txt");
//        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            System.out.println(maxLength(n));
        }
    }

    public static long maxLength(int n) {

        return 1;
    }
}
