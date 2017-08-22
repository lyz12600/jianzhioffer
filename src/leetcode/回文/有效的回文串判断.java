package leetcode.回文;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/7/17.
 */
public class 有效的回文串判断 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println(isPalindrome(str));
        }
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {//大写
                sb.append(s.charAt(i));
            }
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {//小写
                sb.append((char) (s.charAt(i) - 32));
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() <= 1) {
            return true;
        }

        String temp = sb.toString();
        return sb.reverse().toString().equals(temp);
    }
}
