package 三六零;

import 华为.ScannerHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 交换数使两个数组总和之差最小 {
    public static void main(String[] args) {
        Scanner in = ScannerHelper.getScanner("./公司真题/src/三六零/input.txt");
        while (in.hasNextInt()) {
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<Integer> brr = new ArrayList<>();
            int a = in.nextInt();
            for (int i = 0; i < a; i++) {
                arr.add(in.nextInt());
            }
            int b = in.nextInt();
            for (int i = 0; i < b; i++) {
                brr.add(in.nextInt());
            }
            System.out.println(solve(arr, a, brr, b));
        }
    }

    public static int solve(List<Integer> arr, int a, List<Integer> brr, int b) {
        if (arr == null || brr == null || a < 1 || b < 1 || arr.size() < 1 || brr.size() < 1) {
            return -1;
        }
        return -1;
    }
}
