package 腾讯;

import java.util.Scanner;

public class 生成格雷码 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            String[] str = getGray(n);
            for (int i = 0; i < str.length; i++) {
                System.out.println(str[i]);
            }
        }

    }

    public static String[] getGray(int n) {
        String[] str = new String[(int) Math.pow(2, n)];

        if (n < 1) {
            System.out.println("你输入的格雷码位数有误！");
        }

        if (1 == n) {
            str[0] = "0";
            str[1] = "1";
            return str;
        }

        //n-1 位格雷码的生成方式
        String[] pre = getGray(n - 1);

        for (int i = 0; i < pre.length; i++) {
            str[i] = "0" + pre[i];
            str[str.length - 1 - i] = "1" + pre[i];
        }

        return str;
    }
}
