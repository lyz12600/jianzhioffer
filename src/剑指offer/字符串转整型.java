package 剑指offer;

/**
 * 字符串转整型
 * Created by liyanzhen on 17/3/7.
 */
public class 字符串转整型 {
    public static void main(String[] args) {
        String string = "-24587451";
        System.out.println(convertInt(string));
    }

    public static long convertInt(String string) {
        boolean flage = true;
        if (string == null || string.length() == 0) {
            return -1;
        }
        long sum = 0;
        if (string.charAt(0) == '-') {
            flage = false;
        }
        int i = 0;
        if (string.charAt(0) == '-' || string.charAt(0) == '+') {
            i = 1;
        }
        for (; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c <= '9' && c >= '0') {
                sum = c - '0' + sum * 10;
            } else {
                return 0;
            }
        }
        return flage ? sum : -1 * sum;
    }
}
