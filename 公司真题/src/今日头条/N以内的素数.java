package 今日头条;

import java.util.Arrays;
import java.util.Scanner;

public class N以内的素数 {
    public static void main(String[] args) {
//        Scanner s = Template.getScanner("./src/aaa/input.txt");
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            solve(n);
        }

    }

    private static void solve(int n) {
        if (n <= 1) {
            return;
        }
        int temp;
        int k;
        byte[] isSushu = new byte[n + 1];
        Arrays.fill(isSushu, (byte) 1);//素数表示1

        for (int i = 2; i <= n; i++) {
            temp = i;
            k = 2;
            while (temp * k <= n) {
                isSushu[temp * k] = 0;
                k++;
            }
        }


        for (int i = 2; i < n + 1; i++) {
            if (isSushu[i] == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
