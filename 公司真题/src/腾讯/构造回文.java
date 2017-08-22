package 腾讯;

import java.util.Scanner;

/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数。
 * <p>
 * 输入：
 * abcda
 * google
 * <p>
 * 输出：
 * 2
 * 2
 * Created by liyanzhen on 17/7/16.
 */
public class 构造回文 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String s1 = s.nextLine();
            String s2 = new StringBuilder(s1).reverse().toString();
            System.out.println(needDelete(s1, s2));
        }
    }

    public static int needDelete(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 0;
        }

        int[][] arr = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        return s1.length() - arr[s1.length()][s2.length()];
    }
}