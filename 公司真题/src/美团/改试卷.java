package 美团;

import java.util.Arrays;
import java.util.Scanner;

public class 改试卷 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (sc.hasNext()) {
            int size = sc.nextInt();
            int[] temp = new int[size];
            for (int i = 0; i < size; i++) {
                temp[i] = sc.nextInt();
                sum += temp[i];
            }
/**
 * 证明：
 * 当把所有的组从大到小排序后，如果最大的组比剩下的所有的组的和都还要大，
 * 即所有的剩余组分配完成后，最大的组还剩，那么一定不行，否则，当最大组
 * 在其余组分配完成后一定可以循环下去，且最后最大的那组不会收到属于自己组的。
 */
            Arrays.sort(temp);
            int max = temp[temp.length - 1];
            if (max - sum + max > 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}

