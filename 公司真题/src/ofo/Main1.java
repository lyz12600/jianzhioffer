package ofo;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner s = Main.getScanner("./公司真题/src/ofo/input.txt");
//        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            System.out.println(max(n));
        }
    }

    public static int max(int n) {
        if (n < 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            while (n != i) {
                if (n % i != 0) {
                    break;//不能整除肯定不是因数，能够整除在这里一定是质数。因为所有的2，3,5,7
                    //都被除完之后。剩下的因数只能是奇数，且是质数。
                }
                list.add(Integer.valueOf(i));
                n = n / i;
            }
        }
        list.add(Integer.valueOf(n));
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
