package 剑指offer;

import 剑指offer.bean.ScannerHelper;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 面试题：54
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * Created by liyanzhen on 17/7/3.
 */
public class 表示数值的字符串 {
    public static void main(String[] args) {
        Scanner s = ScannerHelper.getScanner("src/剑指offer/表示数值的字符串.txt");
        while (s.hasNextLine()) {
            char[] str = s.nextLine().trim().toCharArray();
            System.out.println(isNumeric(str));
        }
    }

    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }

        Pattern p = Pattern.compile("^[-+]?[0-9]*(\\.[0-9]+)?([eE][+-]?[0-9]+)?$");
        Matcher matcher = p.matcher(String.valueOf(str));
        return matcher.matches();
        /**
         * 投机取巧法
         * 忽略了123d（d代表double的情况）
         */
//        try {
//            Double.valueOf(str);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
    }
}
