package 剑指offer;

/**
 * abcdefg 2
 * cdefgab
 * Created by liyanzhen on 17/6/14.
 */
public class 左旋转字符串 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 3;
        System.out.println(LeftRotateString(s, n));
    }

    public static String LeftRotateString(String str, int n) {
        if (str == null || str.length() < 1)
            return str;
        char[] chars = str.toCharArray();

        int start = 0, end = chars.length - n - 1;
        reverse(chars, 0, chars.length - 1);
        reverse(chars, start, end);
        start = end + 1;
        end = chars.length - 1;
        reverse(chars, start, end);
        return String.valueOf(chars);
    }

    public static char[] reverse(char[] chars, int start, int end) {
        if (start < 0 || end <= 0)
            return chars;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return chars;
    }
}
