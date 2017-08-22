package 腾讯;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/7/15.
 */
public class 素数对 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int num = s.nextInt();
            System.out.println(calcute(num));
        }
    }

    public static int calcute(int num) {
        if (num > 1000 || num < 0) {
            return -1;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < (num >>> 1); i++) {
            for (int j = 2; j <= (num >>> 1); j++) {
                if (isPrime(j) && isPrime(num - j)) {
                    set.add(j);
                }
            }
        }

        return set.size();
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
