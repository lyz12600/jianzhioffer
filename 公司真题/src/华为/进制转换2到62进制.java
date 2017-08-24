package 华为;

import java.util.ArrayList;
import java.util.Scanner;

public class 进制转换2到62进制 {
    static char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
        Scanner s = ScannerHelper.getScanner("./公司真题/src/华为/input.txt");
        while (s.hasNext()) {
            int from = s.nextInt();
            int to = s.nextInt();
            String str = s.nextLine();
            System.out.println(conversion(from, to, str));
        }
    }

    public static String conversion(int from, int to, String str) {
        //考虑正负数
        boolean nagative = false;
        int i = 0;
        if (str.charAt(0) == '-') {
            nagative = true;
            i = 1;
        }
        //把from进制的数据转化为10进制
        int relVal = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                relVal += (Math.pow(from, str.length() - i - 1) * (str.charAt(i) - '0'));
            } else if (str.charAt(i) <= 'z' && str.charAt(i) >= 'a') {
                relVal += (Math.pow(from, str.length() - i - 1) * (str.charAt(i) - 87));
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int temp = relVal;
        while (temp != 0) {
            list.add(temp % to);
            temp = temp / to;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = list.size() - 1; j >= 0; j--) {
            sb.append(arr[list.get(j)]);
        }
        return nagative ? sb.toString() : "-" + sb;
    }
}
