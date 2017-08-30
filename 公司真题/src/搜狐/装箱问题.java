package 搜狐;

import 阿里.Template;

import java.util.Scanner;

public class 装箱问题 {
    public static void main(String[] args) {
        Scanner in = Template.getScanner("./公司真题/src/搜狐/input.txt");
        int count_1;
        int count_2;
        int count_3;
        int count_4;
        int count_5;
        int count_6;
        while (in.hasNext()) {
            count_1 = in.nextInt();
            count_2 = in.nextInt();
            count_3 = in.nextInt();
            count_4 = in.nextInt();
            count_5 = in.nextInt();
            count_6 = in.nextInt();
            solve(count_1, count_2, count_3, count_4, count_5, count_6);
        }
    }

    public static void solve(int count_1, int count_2, int count_3, int count_4, int count_5, int count_6) {
        int[] USE = {0, 5, 3, 1};
        if (count_1 == 0 && count_2 == 0 && count_3 == 0 && count_4 == 0 && count_5 == 0 && count_6 == 0) {
            return;
        }

        int n = count_6 + count_5 + count_4 + (count_3 + 3) / 4;//(c+3)/4 正好等于c 除以4 向上取整的结果
        //2*2的数量
        int x = count_4 * 5 + USE[count_3 % 4];

        if (count_2 > x) {
            n += (count_2 - x + 8) / 9;  //+8向上取整
        }

        //1*1的数量
        int y = 36 * n - 36 * count_6 - 25 * count_5 - 16 * count_4 - 9 * count_3 - 4 * count_2;
        if (count_1 > y) {
            n += (count_1 - y + 35) / 36;
        }
        System.out.println(n);
    }
}
