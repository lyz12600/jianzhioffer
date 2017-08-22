package 腾讯;

import java.util.Scanner;

/**
 * 以上面为例A=GGATCGA，B=GAATTCAGTTA，LD(A,B)=5
 * 　　他们的匹配为：
 * 　　　　A：GGA_TC_G__A
 * 　　　　B：GAATTCAGTTA
 * <p>
 * Created by liyanzhen on 17/7/19.
 */
public class 文本距离比较算法 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str1 = s.nextLine();
            String str2 = s.nextLine();
            System.out.println(distance(str1, str2));
        }
    }

    public static int distance(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return 0;
        }
        if (str1 == null) {
            return str2.length();
        }
        if (str2 == null) {
            return str1.length();
        }

        int[][] arr = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str2.length(); i++) {
            arr[0][i] = i;
        }
        for (int i = 0; i <= str1.length(); i++) {
            arr[i][0] = i;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    arr[i][j] = Math.min(arr[i - 1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1])) + 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1];
                }
            }
        }
        return arr[str1.length()][str2.length()];
    }
}
