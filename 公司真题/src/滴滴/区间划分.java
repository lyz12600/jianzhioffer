package 滴滴;

import 阿里.Template;

import java.util.Arrays;
import java.util.Scanner;

public class 区间划分 {
    public static void main(String[] args) {
        Scanner in = Template.getScanner("./公司真题/src/滴滴/input.txt");
//        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(solution(n, arr));
        }
    }

    public static int solution(int n, int[] arr) {
        int[] cnt = new int[100000 * 4];
        int count = 0;
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            temp ^= arr[i];
            if (temp == 0 || cnt[temp] != 0) {
                temp = 0;
                count++;
                Arrays.fill(cnt, 0);
            } else {
                cnt[temp]++;
            }
        }
        return count;
    }
}
