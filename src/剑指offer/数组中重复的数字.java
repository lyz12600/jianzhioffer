package 剑指offer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 数组中重复的数字
 * 面试题51
 * Created by liyanzhen on 17/6/27.
 */
public class 数组中重复的数字 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            int[] duplication = new int[1];
            System.out.println(duplicate(arr, n, duplication) + "====" + duplication[0]);
        }
    }

    //    public static boolean duplicate(int numbers[], int length, int[] duplication) {
//        if (numbers == null || length < 1)
//            return false;
//        for (int i = 0; i < length; i++) {
//            if (numbers[i] < 0 || numbers[i] > length - 1)
//                return false;
//            while (numbers[i] != i) {
//                if (numbers[i] == numbers[numbers[i]]) {
//                    duplication[0] = numbers[i];
//                    return true;
//                }
//                swap(numbers, numbers[i], numbers[numbers[i]]);
//            }
//        }
//        return false;
//    }
//
//    public static int[] swap(int numbers[], int a, int b) {
//        int temp = numbers[a];
//        numbers[a] = numbers[b];
//        numbers[b] = temp;
//        return numbers;
//    }
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length < 1)
            return false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!set.add(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
