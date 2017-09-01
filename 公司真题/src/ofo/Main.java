package ofo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/7/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = getScanner("./公司真题/src/ofo/input.txt");
//        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int A1 = s.nextInt();
            int A2 = s.nextInt();
            int A3 = s.nextInt();
            int n = s.nextInt();
            System.out.println(solve(A1, A2, A3, n));
        }
    }

    public static long solve(int A1, int A2, int A3, int n) {
        if (n < 1) {
            return -1;
        }

//        if (n == 1) {
//            return A1;
//        } else if (n == 2) {
//            return A2;
//        } else if (n == 3) {
//            return A3;
//        } else {
//            return (solve(A1, A2, A3, n - 1) + solve(A1, A2, A3, n - 2) + solve(A1, A2, A3, n - 3)) % 10000;
//        }
        long[] arr = new long[n];
        arr[0] = A1;
        arr[1] = A2;
        arr[2] = A3;
        for (int i = 3; i <= n - 1; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]);
        }
        return arr[n - 1] % 10000;
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
