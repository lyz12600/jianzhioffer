package bishi;

import aaa.Template;

import java.util.Scanner;

/**
 * 输入包括一个字符串s,字符串长度length(2 ≤ length ≤ 200),保证s是一个偶串且由小写字母构成
 * 输出一个整数,表示删除之后能得到的最长偶串长度是多少。保证测试数据有非零解
 * abaababaab
 * 6
 * Created by liyanzhen on 17/3/25.
 */

public class 偶串 {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/bishi/input.txt");
//        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println(maxLength(str));
        }
    }

    public static int maxLength(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int index = str.length();
        if (index % 2 == 1) {
            index--;
        } else {
            index -= 2;
        }

        for (int i = index; i >= 0; i -= 2) {
            int j = 0;
            for (; j < i / 2; j++) {
                if (str.charAt(j) != str.charAt(j + i / 2)) {
                    break;
                }
            }
            if (j == i / 2) {
                return i;
            }
        }
        return 0;
    }
}