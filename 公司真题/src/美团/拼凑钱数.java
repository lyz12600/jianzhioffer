package 美团;

import java.util.Scanner;

public class 拼凑钱数 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            System.out.println(sumMethod(n));
        }
    }

    public static long sumMethod(int n) {
        if (n < 1 || n > 10000) {
            return 0;
        }

        int[] arr = {0, 1, 5, 10, 20, 50, 100};
        long[][] count = new long[n + 1][arr.length];

        for (int i = 0; i < n + 1; i++) {
            count[i][1] = 1;
        }


        //count[50][3]---用1、5、10元组合50的方法数
        for (int i = 1; i < n + 1; i++) {//拼凑该面值的方法数
            for (int j = 2; j < arr.length; j++) { //加钱币类型进来
                for (int k = 0; k <= i / arr[j]; k++) {
                    count[i][j] += count[i - k * arr[j]][j - 1];
                }
            }
        }
        return count[n][arr.length - 1];
    }
}
