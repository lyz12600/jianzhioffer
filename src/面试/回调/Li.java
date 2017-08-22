package 面试.回调;

/**
 * Created by liyanzhen on 17/7/11.
 */
public class Li {
    public void execuse(Callback callback, String question) {
        System.out.println("小王问的问题：" + question);

        for (int i = 0; i < 110000; i++) {

        }

        String result = "2";
        callback.solve(result);
    }
}
