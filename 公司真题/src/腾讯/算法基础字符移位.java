package 腾讯;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/7/16.
 */
public class 算法基础字符移位 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println(moveToTail(str));
        }
    }

    private static String moveToTail(String str) {
        if (str == null || str.length() < 1 || str.length() > 1000) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                sb.append(str.charAt(i));
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sB.append(str.charAt(i));
            } else {
                return null;
            }
        }
        return String.valueOf(sb.append(sB));
    }
}
