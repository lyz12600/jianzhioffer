package 华为;

import java.util.HashSet;
import java.util.Scanner;

public class 消除重复的数取最大值 {
    static long max = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLong()) {
            max = 0;
            long n = s.nextLong();
            solve(n);
        }
    }

    public static void solve(long num) {
        if (num < 1) {
            return;
        }
        String str = String.valueOf(num); //用字符串保存数据
        HashSet<Character> set = new HashSet<>();//用于计算返回数据的size，同时用于保存当前数据是否重复
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        char[] chars = new char[set.size()];//用于存储组合的数据
        int n = set.size();

        set.clear();//set改变用途
        combine(str, n, 0, chars, 0, set);
        System.out.println(max);
    }

    public static void combine(String str, int n, int begin, char[] chars, int index, HashSet<Character> set) {
        if (n == 0) {
            long temp = 0;
            for (int i = 0; i < index; i++) {
                temp = temp * 10 + (chars[i] - '0');
            }
            max = max > temp ? max : temp;
            return;
        }

        for (int i = begin; i < str.length(); i++) {
            if (set.add(str.charAt(i))) {//如果不重复才可添加
                chars[index] = str.charAt(i);
                combine(str, n - 1, i + 1, chars, index + 1, set);
                set.remove(chars[index]);//移除当前的数据
            }
        }
    }
}
