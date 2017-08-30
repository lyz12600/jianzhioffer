package 滴滴;

import 华为.ScannerHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 数组和最大 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Scanner in = ScannerHelper.getScanner("./公司真题/src/滴滴/input.txt");
        while (in.hasNextLine()) {
            List<Integer> data = new ArrayList<Integer>();
            String input = in.nextLine();
            String[] ss = input.split(" ");
            for (String s : ss) {
                data.add(Integer.valueOf(s));
            }
            System.out.println(helper(data));
        }
    }

    private static int helper(List<Integer> input) {
        if (input == null || input.size() == 0) return 0;
        int max = 0, curMax = 0;
        max = curMax = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            curMax = Math.max(input.get(i), input.get(i) + curMax);
            max = Math.max(curMax, max);
        }
        return max;
    }
}
