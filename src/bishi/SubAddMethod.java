package bishi;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/4/12.
 */
public class SubAddMethod {
    static int maxSum(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> ll = new LinkedList<>();
        while (in.hasNext()) {
            int element = in.nextInt();
            ll.add(element);
        }
        Integer[] arr = ll.toArray(new Integer[0]);
        int res;
        res = maxSum(arr);
        System.out.println(res);
    }
}