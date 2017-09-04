package 剑指offer;

import java.util.*;

/**
 * Created by liyanzhen on 17/6/3.
 * 第一个只出现一次的字符
 * 输入：abaccdeff
 * 输出：b
 */
public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine().trim();
            System.out.println(FirstNotRepeatingChar(str));
        }
    }

    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] res = new int['z' + 1];
        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i)]++;
        }

        for (int j = 0; j < str.length(); j++) {
            if (res[str.charAt(j)] == 1) {
                return str.indexOf(str.charAt(j));
            }
        }
        return -1;
    }
}
