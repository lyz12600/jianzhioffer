package bishi;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/4/7.
 */
public class GaiLv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String str = sc.next();
            GaiLv main = new GaiLv();
            main.calculate(n, str);
        }
    }

    public void calculate(int n, String str) {
        String[] strings = str.split("\\s");
        int[] arr = new int[strings.length - 1];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        int num = (int) Math.ceil(n * 0.6);
        double res = 0.0;
        for (int i = num; i <= n; i++) {
            res = res + cCalculate(n,i);
        }


    }

    public int cCalculate(int n, int num) {
        int sum = 1, temp = n;
        for (int i = 1; i <= num; i++) {
            sum = sum * temp;
            temp = temp - 1;
        }

        for (int i = 1; i <= num; i++) {
            sum = sum / num;
        }
        return sum;
    }

}
