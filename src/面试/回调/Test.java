package 面试.回调;

/**
 * Created by liyanzhen on 17/7/11.
 */
public class Test {
    public static void main(String[] args) {
        Wang wang = new Wang(new Li());
        wang.askQuestion("1+1=");
    }
}
