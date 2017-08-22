package 网易;

import java.util.HashSet;
import java.util.Scanner;

public class 彩色的砖块 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println(solve(str));
        }
    }

    public static int solve(String str) {
        if (str == null || str.length() == 1) {
            return 0;
        }
        HashSet set = new HashSet();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        if (set.size() == 2) {
            return 2;
        } else if (set.size() == 1) {
            return 1;
        }
        return 0;
    }
}
