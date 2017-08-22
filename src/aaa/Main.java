package aaa;

import java.util.Scanner;

import static aaa.Template.getScanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/aaa/input.txt");
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println(replaceSpace(new StringBuffer(str)));
        }
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null || str.length() < 1) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
