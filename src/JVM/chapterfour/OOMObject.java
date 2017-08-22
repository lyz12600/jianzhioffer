package JVM.chapterfour;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyanzhen on 17/6/9.
 */
public class OOMObject {
    static class OOM {
        public byte[] placeHolder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOM> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOM());
        }
    }

    public static void main(String[] args) {
        try {
            fillHeap(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
    }
}

