package niuke;

/**
 * Created by liyanzhen on 16/11/5.
 */
public class Inc {
    public static void main(String[] args) {
        Inc inc = new Inc();
        int i = 0;
        inc.fermin(i);
        i = i++;
        //i = ++i;
        System.out.println(i);
    }

    private int fermin(int i) {
        i++;
        return i;
    }
}
