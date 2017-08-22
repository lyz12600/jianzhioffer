package bishi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by liyanzhen on 17/6/16.
 * 序列交换
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
//            ArrayListDemo02<String> list = Permutation(str);
//            for (String s : list) {
//                System.out.println(s);
//            }
            System.out.println(Permutation(str));
        }
    }

    public static int Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() < 1)
            return list.size();
        String[] strings = str.trim().split("\\s+");
        TreeSet<String> temp = new TreeSet<>();
        permutation(strings, 0, temp);
        list.addAll(temp);
        return list.size();
    }

    public static void permutation(String[] strings, int begin, TreeSet<String> result) {
        if (strings == null || strings.length == 0 || begin < 0 || begin > strings.length - 1)
            return;
        if (begin == strings.length - 1) {
//            result.add(String.join(" ", strings));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                if (i == strings.length - 1) {
                    sb.append(strings[i]);
                } else {
                    sb.append(strings[i] + " ");
                }
            }
            String str = sb.toString();
            result.add(str);
        } else {
            for (int i = begin; i < strings.length; i++) {
                swap(strings, begin, i);
                permutation(strings, begin + 1, result);
                swap(strings, begin, i);
            }
        }
    }

    private static void swap(String[] strings, int begin, int i) {
        String t = strings[begin];
        strings[begin] = strings[i];
        strings[i] = t;
    }
}
