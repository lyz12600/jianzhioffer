package bishi;

/**
 * Created by liyanzhen on 17/4/16.
 */
public class Sushu {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        long sqrtNum = (long) Math.sqrt(num); //得到该数字的二次根
        for (int i = 2; i <= sqrtNum; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
