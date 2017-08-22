package xiaoxiang.动态规划;

import java.util.Scanner;

/**
 * 求到最后的资金数量
 * Created by liyanzhen on 17/6/22.
 */
public class 股票的最大收益牛客 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            System.out.printf("%.2f\n", maxProfits(arr));
        }
    }

    public static double maxProfits(double[] arr) {
        if (arr == null || arr.length < 1)
            return 0;

        double sum = 10000;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                sum = sum / arr[i - 1] * arr[i];
            }
        }
        return sum;
    }
}
