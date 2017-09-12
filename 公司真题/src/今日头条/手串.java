package 今日头条;

import 阿里.Template;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 手串 {
    public static void main(String[] args) {
//        Scanner in = getScanner(System.in);
        Scanner in = Template.getScanner("./公司真题/src/今日头条/input.txt");
        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            int len = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(in.nextInt());
            }
            res.add(list);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < res.size(); i++) {
            ArrayList<Integer> list = res.get(i);
            for (int j = 0; j < m - 1; j++) {
                ArrayList<Integer> temp = res.get((i - j - 1 + n) % n);
                for (Integer val : temp) {
                    if (list.contains(val)) {
                        set.add(val);
                    }
                }
            }
            for (int j = 0; j < m - 1; j++) {
                ArrayList<Integer> temp = res.get((i + j + 1 + n) % n);
                for (Integer val : temp) {
                    if (list.contains(val)) {
                        set.add(val);
                    }
                }
            }
        }
        System.out.println(set.size());
    }
}
