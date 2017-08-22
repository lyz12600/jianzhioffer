package leetcode.回文;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/7/24.
 */
public class 回文子串 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            List<List<String>> list = partition(str);
            for (List<String> res : list) {
                for (String string : res) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return list;
        }

        return list;

    }


}
