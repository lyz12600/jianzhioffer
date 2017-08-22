package 美团;

import java.util.Scanner;

public class 最长公共连续子串 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String s1 = s.nextLine();
//            s.nextLine();
            String s2 = s.nextLine();
            System.out.println(getMaxLength(s1, s2));
        }
    }

    public static int getMaxLength(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < str1.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < str1.length(); j++) {
                sb.append(str1.charAt(j));
                String target = sb.toString();
                if (str2.contains(target)) {
                    max = target.length() > max ? target.length() : max;
                }
            }
        }
        return max;
    }
}
