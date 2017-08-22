package 腾讯;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/7/15.
 */
public class 游戏任务标记 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int first = s.nextInt();
            int second = s.nextInt();
            int[] arr = new int[32];
            setFirstFinished(first, arr);
            System.out.println(isFinished(second, arr));
        }
    }

    public static void setFirstFinished(int first, int[] arr) {
        if (first < 1 || first > 1024) {
            return;
        }
        int index = (int) Math.ceil(first / 32) - 1;
        int temp = 1 << index;
        arr[index] = temp | arr[index];
    }

    public static int isFinished(int second, int[] arr) {
        if (second < 1 || second > 1024) {
            return -1;
        }
        int index = (int) Math.ceil(second / 32) - 1;
        int temp = arr[index] >>> index;
        if ((temp & 0x1) == 1) {
            return 1;
        }
        return 0;
    }
}
