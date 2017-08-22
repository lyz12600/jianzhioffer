package 剑指offer;

import java.util.Scanner;

/**
 * I am a student.
 * student. a am I
 * <p>
 * Created by liyanzhen on 17/6/14.
 */
public class 翻转单词顺序 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println(ReverseSentence(str));
        }
    }

    public static String ReverseSentence(String str) {
        if (str == null || str.length() < 1)
            return str;
        char[] chars = str.toCharArray();
        int begin = 0, end = chars.length - 1;
        chars = Reverse(chars, begin, end);//翻转整个句子

        begin = end = 0;
        while (end < chars.length && chars[begin] != '\0') {
            if (chars[begin] == ' ') {
                begin++;
                end++;
            } else if (end == chars.length - 1) {
                Reverse(chars, begin, end);
                return String.valueOf(chars);
            } else if (chars[end] == ' ' || chars[end] == '\0') {
                Reverse(chars, begin, --end);
                begin = ++end;
            } else {
                end++;
            }
        }
        return String.valueOf(chars);
    }

    public static char[] Reverse(char[] chars, int begin, int end) {
        if (begin < 0 || end <= 0)
            return chars;
        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;

            begin++;
            end--;
        }
        return chars;
    }
}
