package 腾讯;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/7/19.
 * 例A=GGATCGA，B=GAATTCAGTTA，LCS(A,B)=6
 * 他们的匹配为：
 * 　　　　A：GGA_TC_G__A
 * 　　　　B：GAATTCAGTTA
 */
public class 公共最大子串 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String s1 = s.nextLine();
            String s2 = s.nextLine();
            System.out.println(getLongestSubString(s1, s2));
        }
    }

    public static int getLongestSubString(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }

        int[][] arr = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        return arr[str1.length()][str2.length()];
    }
}
