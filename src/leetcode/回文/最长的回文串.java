package leetcode.回文;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 不要求顺序，只求最长
 * Input:"abccccdd"
 * Output:7
 * Explanation:One longest palindrome that can be built is "dccaccd",
 * whose length is 7.
 * Created by liyanzhen on 17/7/17.
 */
public class 最长的回文串 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String string = s.nextLine().trim();
            System.out.println(longestPalindrome(string));
        }
    }

    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(i));
            }
        }

        if (set.size() == 0) {
            return s.length();
        }

        return s.length() - set.size() + 1;
    }
}
