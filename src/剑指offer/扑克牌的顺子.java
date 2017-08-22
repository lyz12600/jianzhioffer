package 剑指offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 面试题：44
 * 扑克牌的顺子
 * Created by liyanzhen on 17/6/19.
 */
public class 扑克牌的顺子 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String[] str = s.nextLine().trim().split("\\s+");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                switch (str[i]) {
                    case "A":
                        arr[i] = 1;
                        break;
                    case "J":
                        arr[i] = 11;
                        break;
                    case "Q":
                        arr[i] = 12;
                        break;
                    case "K":
                        arr[i] = 13;
                        break;
                    default:
                        arr[i] = Integer.parseInt(str[i]);
                        break;
                }
            }
            System.out.println(isContinuous(arr));
        }
    }

    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 1)
            return false;
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int numberOfGap = 0;

        //统计0的数量
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++)
            numberOfZero++;

        //统计间隔数目
        int small = numberOfZero;
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big])//两个数相等，有对子，不可能是顺子
                return false;
            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            ++big;
        }
        return numberOfGap > numberOfZero ? false : true;
    }
}
