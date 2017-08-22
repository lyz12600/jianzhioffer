package aaa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/7/24.
 */
public class Template {
    public static void main(String[] args) {
        Scanner s = getScanner("/Users/liyanzhen/IdeaProjects/crazy/src/aaa/input.txt");
//        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
        }
    }

    public static Scanner getScanner(String file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scanner;
    }

    public static Scanner getScanner(InputStream is) {
        return new Scanner(is);
    }
}
