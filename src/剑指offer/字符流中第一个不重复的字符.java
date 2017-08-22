package 剑指offer;

import 剑指offer.bean.ScannerHelper;

import java.util.Scanner;

/**
 * 字符流中第一个不重复的字符
 * Created by liyanzhen on 17/7/3.
 */
public class 字符流中第一个不重复的字符 {
    private static char[] chars;
    private static int[] arr = new int[256];
    private static int index = 1;

    public static void main(String[] args) {
        Insert('g');
        Insert('o');
        Insert('o');
        Insert('g');
        Insert('l');
        Insert('e');
        System.out.println(FirstAppearingOnce());
    }

    public static void Insert(char ch) {
//        if (arr[ch] == 0) {
//            arr[ch] = index++;
//        } else {
//            arr[ch] = -1;
//        }

        if (arr[ch] == 0) {
            arr[ch] = index++;
        } else {
            arr[ch] = -1;
        }
    }

    public static char FirstAppearingOnce() {
        int temp = Integer.MAX_VALUE;
        char c = '#';
//        for (int i = 0; i < 256; i++) {
//            if (arr[i] != 0 && arr[i] != -1 && arr[i] < temp) {
//                temp = arr[i];
//                c = (char) i;
//            }
//        }
        for (int i = 0; i < 256; i++) {
            if (arr[i] > 0 && arr[i] < temp) {
                temp = arr[i];
                c = (char) i;
            }
        }
        return c;
    }
}
