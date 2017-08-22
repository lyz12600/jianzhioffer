package 面试.回调;

/**
 * Created by liyanzhen on 17/7/11.
 */
public class Wang implements Callback {
    Li li;

    public Wang(Li li) {
        this.li = li;
    }

    public void askQuestion(String question) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.execuse(Wang.this, question);
            }
        }).start();
    }

    @Override
    public void solve(String result) {
        System.out.println("小王得到答案是" + result);
    }
}
