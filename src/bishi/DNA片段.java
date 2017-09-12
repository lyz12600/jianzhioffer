package bishi;

import aaa.Template;

import java.util.Scanner;

/**
 * DNA片段
 * s = "ABCBOATER"中包含最长的DNA片段是"AT",所以最长的长度是2
 * Created by liyanzhen on 17/7/26.
 */
public class DNA片段 {
    public static void main(String[] args) {
//        Scanner s = Template.getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/bishi/input.txt");
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println(maxLength(str));
        }
    }

    public static int maxLength(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int max = 0;
        int temp;
        int i = 0;
        while (i < str.length()) {
            temp = 0;
            if (str.charAt(i) == 'A' || str.charAt(i) == 'T' || str.charAt(i) == 'C' || str.charAt(i) == 'G') {
                temp++;
                int j = i + 1;
                while ((j < str.length()) && (str.charAt(j) == 'A' || str.charAt(j) == 'T' || str.charAt(j) == 'C' || str.charAt(j) == 'G')) {
                    j++;
                    temp++;
                }
            }
            if (temp > max) {
                max = temp;
            }
            i++;
        }
        return max;
    }
}