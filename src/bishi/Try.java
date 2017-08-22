package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liyanzhen on 17/3/27.
 */

public class Try {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (s.hasNext()) {
            list.set(i,s.nextInt());
            i++;
            for (Integer g : list) {
                System.out.print(g);
            }
        }
    }
}







