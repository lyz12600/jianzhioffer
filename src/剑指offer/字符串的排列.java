package 剑指offer;

import java.util.*;

/**
 * 字符串的排列
 * Created by liyanzhen on 17/5/24.
 */
public class 字符串的排列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            ArrayList<String> list = Permutation(str);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() < 1)
            return list;
        char[] chars = str.toCharArray();
        TreeSet<String> temp = new TreeSet<>();
        permutation(chars, 0, temp);
        list.addAll(temp);
        return list;
    }

    public static void permutation(char[] chars, int begin, TreeSet<String> result) {
        if (begin == chars.length - 1) {
            result.add(String.valueOf(chars));
            return;
        }
        for (int i = begin; i < chars.length; i++) {
            swap(chars, begin, i);
            permutation(chars, begin + 1, result);
            swap(chars, begin, i);
        }

    }

    private static void swap(char[] chars, int begin, int i) {
        char t = chars[begin];
        chars[begin] = chars[i];
        chars[i] = t;
    }
}
