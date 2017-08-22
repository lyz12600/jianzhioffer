package bishi;

import aaa.Template;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/3/25.
 */

public class 制造回文 {
    public static void main(String[] args) {
        Scanner s = Template.getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/bishi/input.txt");
//        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println(maxLength(str));
        }
    }

    public static int maxLength(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == null) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }

        int count = 0;
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer) entry.getValue() % 2 == 1) {//大于1的奇数
                count++;
            }
        }
        if (count <= 1) {
            return 1;
        }
        return count;
    }
}