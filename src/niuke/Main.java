package niuke;

/**
 * Created by liyanzhen on 17/3/23.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextBigInteger()) {
            BigInteger a = in.nextBigInteger();
            BigInteger b = in.nextBigInteger();
            BigInteger c = in.nextBigInteger();
            int count = caculate(a, b, c);
            System.out.println(count);
        }
    }

    private static int caculate(BigInteger a, BigInteger b, BigInteger c) {
        int count = 0;
        BigInteger index = BigInteger.valueOf(0);
        BigInteger first = a.add(c);
        while (a.compareTo(first) <= 0) {
            if (a.remainder(c) == BigInteger.ZERO) {
                index = a;
                break;
            } else {
                a = a.add(c);
            }
            return -1;
        }


        while (index.compareTo(b) <= 0) {
            index = index.add(c);
            count++;
        }
        return count;
    }
}