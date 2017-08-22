package xiaoxiang.动态规划;

import java.util.Scanner;

/**
 * 6
 * 7 1 5 4 3 6
 * 5
 * Created by liyanzhen on 17/6/21.
 */
public class 股票的最大收益 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        while (count > 0) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println(maxProfits(arr));
            count--;
        }
    }

    public static int maxProfits(int[] arr) {
        if (arr == null || arr.length < 1)
            return 0;
        int p = 0;//差值
        int min = arr[0];//最小值
        for (int i = 1; i < arr.length; i++) {
            min = Integer.min(min, arr[i - 1]);
            p = Integer.max(p, arr[i] - min);
        }
        return p;
    }

}
