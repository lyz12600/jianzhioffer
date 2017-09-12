package 京东;

import java.util.Scanner;

public class 括号匹配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            char[] s = sc.nextLine().trim().toCharArray();
            int ans = 1, cnt = 0;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '(') {
                    cnt++;
                } else {
                    ans *= cnt;
                    cnt--;
                }
            }
            System.out.println(ans);
        }
    }
}
