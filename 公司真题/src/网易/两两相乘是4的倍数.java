package 网易;

import 阿里.Template;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class 两两相乘是4的倍数 {
    public static void main(String[] args) {
        Scanner in = Template.getScanner("./公司真题/src/网易/input.txt");
//        Scanner in = getScanner("input.txt");
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int numbers[] = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextInt();
            }
            int counter2 = 0;
            int counter4 = 0;

            for (int i = 0; i < n; i++) {
                if (numbers[i] % 4 == 0) {
                    counter4++;
                } else if (numbers[i] % 2 == 0) {
                    counter2++;
                }
            }
            if (counter4 * 2 + counter2 >= n) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        in.close();
    }
}
