package 京东;

import 阿里.Template;

import java.util.Scanner;

/**
 * aaa
 * abab
 * abracadabra
 * aba
 * aa
 */
public class 字符串重叠 {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
        Scanner s = Template.getScanner("./公司真题/src/京东/input.txt");
        while (s.hasNextLine()) {
            String str = s.nextLine().trim();
            solution(str);
        }
    }

    public static void solution(String str) {
        if (str == null || str.length() == 0) {
            return;
        }

        int[] next = getNext2(str.toCharArray());
        int max = 0x80000000;
        for (int i = 0; i < next.length; i++) {
            max = max > next[i] ? max : i;
        }
        System.out.println("max" + max);
        System.out.println(str + str.substring(next[max] + 1, str.length() - next[max]));
    }

    public static int[] getNext2(char[] b) {
        int len = b.length;
        int[] next = new int[len];
        int k = -1;
        int j = 0;
        next[0] = -1; // next数组中next[0]为-1
        while (j < len - 1) {
            if (k == -1 || b[j] == b[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
