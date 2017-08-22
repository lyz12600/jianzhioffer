package xiaoxiang.动态规划;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.Scanner;

/**
 * 多次交易
 * 7 1 5 3 6 4
 * 7
 * 4 ＋ 3 ＝ 7
 * Created by liyanzhen on 17/6/22.
 */
public class 股票的最大收益II {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println(getMaxProfits(arr));
        }
    }

    public static int getMaxProfits(int[] arr) {
        return 0;
    }
}
