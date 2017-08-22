package niuke;

import java.util.Scanner;

/**
 * Created by liyanzhen on 17/3/14.
 */
public class FindSortAddDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int l = in.nextInt();
            boolean flag = false;
            for (int i = l; i <= 100; i++) {
                if ((2 * n - i * i + i) % (2 * i) == 0) {
                    flag = true;
                    int a1 = (2 * n + i - i * i) / (2 * i);
                    for (int j = 0; j < i - 1; j++) {
                        int a = j + a1;
                        System.out.print(a + " ");
                    }
                    System.out.println(a1 + i - 1);
                    break;
                }
            }
            if (flag == false){
                System.out.println("No");
            }
        }
    }
}
