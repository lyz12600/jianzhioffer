package bishi;

import aaa.Template;

import java.util.Scanner;

/**
 * 彩色瓷砖
 * Created by liyanzhen on 17/3/25.
 */

public class 彩色瓷砖 {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/bishi/input.txt");
//        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println(maxLength(str));
        }
    }

    public static int maxLength(String str) {
        if (str == null || str.length() < 1 || str.length() > 10) {
            return -1;
        }

        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
        }
        return count;
    }
}