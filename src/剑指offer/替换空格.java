package 剑指offer;

/**
 * Created by liyanzhen on 17/3/5.
 * 替换空格
 */
public class 替换空格 {
    public static void main(String[] args) {
        StringBuffer string = new StringBuffer("   1 34 5");
        System.out.println(replaceSpace(string));
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null || str.length() < 1) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
