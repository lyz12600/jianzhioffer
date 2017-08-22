package 华为;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/6/28.
 */
public class 字符串分类 {

    private static int LETTER = 0;
    private static int DIGIT = 1;
    private static int OTHER = 2;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            getCount(str);
        }
    }

    public static void getCount(String s) {
        if (s == null || s.length() < 1)
            return;
        int[] arr = new int[3];
        int beforeType = getType(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (getType(s.charAt(i)) != beforeType) {
                arr[beforeType]++;
                beforeType = getType(s.charAt(i));
            }
        }
        arr[getType(s.charAt(s.length() - 1))]++;
        System.out.println(arr[LETTER] + "," + arr[DIGIT] + "," + arr[OTHER]);
    }

    public static int getType(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return LETTER;
        } else if (c >= '0' && c <= '9') {
            return DIGIT;
        } else {
            return OTHER;
        }
    }
}
