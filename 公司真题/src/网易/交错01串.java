package 网易;

import java.util.Scanner;

public class 交错01串 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println(solve(str));
        }
    }

    public static int solve(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int max = 0;
        int len = 1;
        int index = Integer.parseInt(String.valueOf(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (1 - index == Integer.parseInt(String.valueOf(str.charAt(i)))) {
                len++;
            } else {
                len = 1;
            }
            max = max > len ? max : len;
            index = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return max;
    }
}
