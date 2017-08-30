package aaa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner s = Template.getScanner("./src/aaa/input.txt");
//        while (s.hasNextLong()) {
//            long n = s.nextLong();
//            System.out.println(solve(n));
//        }
        short a = 2017;
        System.out.println(Integer.toBinaryString(a));
        a = (short) (a << 5);
        a = (short) (a >> 5);
        System.out.println(a);
    }

    public static long solve(long n) {
        return 0;
    }
}