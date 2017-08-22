package 动态规划;

/**
 * 在总重量不超过W的前提下，总价值是否能达到V
 * $ kg
 * 4 12
 * 2 2
 * 2 1
 * 10 4
 * 1 1
 * Created by liyanzhen on 17/7/1.
 */
public class 背包问题 {
    public static void main(String[] args) {
        int weight[] = {2, 3, 4, 5, 9};
        int value[] = {3, 4, 5, 8, 10};
        int w = 20;
        int sum = packages1(weight, value, weight.length - 1, w);
        int sum1 = packages2(weight, value, w);
        System.out.println(sum);
        System.out.println(sum1);
    }

    /**
     * 方法一：递归
     * 时间复杂度：2的n次方
     *
     * @param weight
     * @param value
     * @param k
     * @param w
     * @return
     */
    public static int packages1(int[] weight, int[] value, int k, int w) {
        if (k <= -1 || w <= 0) {
            return 0;
        }
        if (weight[k] > w) { //如果当前重量大于还需要的重量
            return packages1(weight, value, k - 1, w);
        } else {
            return Integer.max(packages1(weight, value, k - 1, w), packages1(weight, value, k - 1, w - weight[k]) + value[k]);
        }
    }


    /**
     * 方法二：
     * 用空间保存中间变量
     *
     * @param weight
     * @param value
     * @param w
     * @return
     */
    public static int packages2(int[] weight, int[] value, int w) {
        int[][] arr = new int[weight.length + 1][w + 1];

        for (int i = 1; i <= weight.length; i++) { //前几种商品
            for (int j = 1; j <= w; j++) { //不同重量
                //够加
                if (j >= weight[i - 1]) {
                    arr[i][j] = Integer.max(arr[i - 1][j - weight[i - 1]] + value[i - 1],
                            arr[i - 1][j]);
                } else {
                    //加不了
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.format("%5d", arr[i][j]);
            }
            System.out.println();
        }

        return arr[weight.length][w];
    }
}
