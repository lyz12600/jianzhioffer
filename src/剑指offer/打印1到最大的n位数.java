package 剑指offer;

import java.util.Scanner;

/**
 * 打印1到最大的n位数
 * Created by liyanzhen on 17/5/13.
 */
public class 打印1到最大的n位数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int target = scanner.nextInt();
            printMaxNumber(target);
        }
    }

    /**
     * 最笨的方法，不考虑溢出
     */
//    public static void printMaxNumber(int target) {
//        int number = 1;
//        for (int i = 0; i < target; i++) {
//            number *= 10;
//        }
//        for (int i = 0; i < number; i++) {
//            System.out.println(i);
//        }
//    }

    /**
     * 用字符数组处理
     */
//    public static void printMaxNumber(int n) {
//        if (n <= 0) {
//            return;
//        }
//        StringBuffer number = new StringBuffer();
//
//        for (int i = 0; i < n; i++) {
//            number.append('0');
//
//        }
//
//        while (!Increment(number)) {
//            PrintNumber(number);
//        }
//    }
//
//    public static boolean Increment(StringBuffer s) {
//        boolean isOverflow = false;
//        int nTakeOver = 0;
//        int nLength = s.length();
//        for (int i = nLength - 1; i >= 0; i--) {
//            int nSum = s.charAt(i) - '0' + nTakeOver;
//            if (i == nLength - 1) {
//                nSum++;
//            }
//            if (nSum >= 10) {
//                if (i == 0) {
//                    isOverflow = true;
//
//                } else {
//                    nSum -= 10;
//                    nTakeOver = 1;
//                    s.setCharAt(i, (char) ('0' + nSum));
//                }
//
//            } else {
//                s.setCharAt(i, (char) ('0' + nSum));
//                break;
//            }
//        }
//        return isOverflow;
//    }
//
//    public static void PrintNumber(StringBuffer s) {
//        boolean isBeginning0 = true;
//        for (int i = 0; i < s.length(); i++) {
//            if (isBeginning0 && s.charAt(i) != '0') {
//                isBeginning0 = false;
//            }
//            if (!isBeginning0) {
//                System.out.print(s.charAt(i));
//            }
//        }
//
//        System.out.println();
//    }

    /**
     * 数字排列的方法
     */
    public static void printMaxNumber(int n) {
        if (n < 0) {
            return;
        }
        StringBuffer s = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            s.append('0');
        }
        for (int i = 0; i < 10; i++) {
            s.setCharAt(0, (char) (i + '0'));
            Print1ToMaxOfNDigits_3_Recursely(s, n, 0);
        }

    }

    public static void Print1ToMaxOfNDigits_3_Recursely(StringBuffer s, int n, int index) {
        if (index == n - 1) {
            PrintNumber(s);
            return;
        }

        for (int i = 0; i < 10; i++) {
            s.setCharAt(index + 1, (char) (i + '0'));
            Print1ToMaxOfNDigits_3_Recursely(s, n, index + 1);
        }
    }

    public static void PrintNumber(StringBuffer s) {
        boolean isBeginning0 = true;
        for (int i = 0; i < s.length(); i++) {
            if (isBeginning0 && s.charAt(i) != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(s.charAt(i));
            }
        }
        System.out.println();
    }
}
