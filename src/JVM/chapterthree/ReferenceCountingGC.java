package JVM.chapterthree;

/**
 * Created by liyanzhen on 17/1/8.
 */
public class ReferenceCountingGC {
    public ReferenceCountingGC instance = null;
    private static final int _1M = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1M];

    public static void main(String args[]) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        try {
            objA.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        objA = null;
        objB = null;

        System.gc();
    }
}
