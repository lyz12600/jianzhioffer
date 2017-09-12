package aaa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner in = getScanner(System.in);
        Scanner in = getScanner("./src/aaa/input.txt");
        while (in.hasNext()) {
            String line = in.next();
            int[] comLen = getNext(line);
            int mostCommonLen = comLen[line.length() - 1] + 1;
            if (comLen.length - 2 * mostCommonLen <= 0) {
                System.out.println(line);
            } else {
                System.out.println(line + line.substring(mostCommonLen));
            }
        }
        in.close();
    }

    private static int[] getNext(String s) {
        int[] next = new int[s.length()];
        int len = s.length();
        next[0] = -1;
        for (int i = 0, k = -1; i < len - 1; ) {
            if (k == -1 || s.charAt(i) == s.charAt(k)) {
                i++;
                k++;
                next[i] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    //从输入流读取输入数据
    public static Scanner getScanner(InputStream is) {
        return new Scanner(is);
    }

    //从文件读取输入数据
    public static Scanner getScanner(String fileName) {
        try {
            return getScanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
