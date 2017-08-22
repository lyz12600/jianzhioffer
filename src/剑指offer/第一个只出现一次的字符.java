package 剑指offer;

import java.util.*;

/**
 * Created by liyanzhen on 17/6/3.
 * 第一个只出现一次的字符
 * 输入：abaccdeff
 * 输出：b
 */
public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String str = s.nextLine().trim();
            System.out.println(FirstNotRepeatingChar(str));
        }
    }

    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() < 1)
            return -1;

        TreeSet<Character> set = new TreeSet<>();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (set.add(str.charAt(i))) {//set添加成功
                list.add(str.charAt(i));
            } else if (list.contains(str.charAt(i))) {
                list.remove(list.indexOf(str.charAt(i)));
            }
        }
        if (set.size() > 0 && list.size() > 0) {
            return str.indexOf(list.get(0));
        }
        return -1;
    }
}
