package 剑指offer;

import java.util.*;

/**
 * Created by liyanzhen on 17/5/31.
 */
public class 把数组排成最小的数 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String[] string = s.nextLine().trim().split("\\s+");
            int[] arr = new int[string.length];
            for (int i = 0; i < string.length; i++) {
                arr[i] = Integer.parseInt(string[i]);
            }
            System.out.println(PrintMinNumber(arr));
        }
    }

    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length < 1)
            return "";

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                System.out.println(o1 + "****" + o2 + "****" + s1.compareTo(s2));
                return s1.compareTo(s2);
            }
        });

        for (Integer i : list) {
            System.out.println("======" + i);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }
}
