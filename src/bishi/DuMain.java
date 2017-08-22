package bishi;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liyanzhen on 17/4/27.
 */
public class DuMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int len = scanner.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(findOrderNumber(len, arr));
        }
    }

    private static int findOrderNumber(int n, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        Integer[] array = set.toArray(new Integer[] {});//关键语句
        if (array.length<=1){
            return -1;
        }
        long tmp[] = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        int i = 0;
        int a = arr.length;
        //分三种情况来看
        for (int num : array) {
            if (num < tmp[1] && num > tmp[0]) {
                tmp[0] = num;
            } else if (num < tmp[2] && num > tmp[1]) {
                tmp[0] = tmp[1];
                tmp[1] = num;
            } else if (num > tmp[2]) {
                tmp[0] = tmp[1];
                tmp[1] = tmp[2];
                tmp[2] = num;
            }
        }
        if (tmp[0] == Long.MIN_VALUE) {
            return (int) tmp[2];
        }
        return (int) tmp[0];
    }
}
