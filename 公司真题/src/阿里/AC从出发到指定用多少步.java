package 阿里;

import java.util.Scanner;

public class AC从出发到指定用多少步 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int boxNumbers = in.nextInt();
            int startPos = in.nextInt() - 1;
            int time = in.nextInt();
            int targetPos = in.nextInt() - 1;
            if (targetPos > boxNumbers - 1 || startPos > boxNumbers - 1 || targetPos < 0 || startPos < 0 || boxNumbers <= 0 || time < 0) {
                System.out.println(0);
            } else {
                int[][][] dp = new int[boxNumbers][boxNumbers][time + 1];
                boolean[][][] flag = new boolean[boxNumbers][boxNumbers][time + 1];
                System.out.println(solve(boxNumbers, startPos, time, targetPos, dp, flag));
            }
        }
        in.close();
    }

    private static int solve(int boxNumbers, int startPos, int time, int targetPos, int[][][] dp, boolean[][][] flag) {
        //事件消耗完
        if (time < 0) {
            return 0;
        }
        if (flag[startPos][targetPos][time]) {
            return dp[startPos][targetPos][time];
        }
        //到达目的地
        if (startPos == targetPos && time == 0) {
            return 1;
        }
        if (startPos > 0) {
            dp[startPos][targetPos][time] += solve(boxNumbers, startPos - 1, time - 1, targetPos, dp, flag);
        }
        if (startPos < boxNumbers - 1) {
            dp[startPos][targetPos][time] += solve(boxNumbers, startPos + 1, time - 1, targetPos, dp, flag);
        }
        flag[startPos][targetPos][time] = true;
        return dp[startPos][targetPos][time];
    }
}