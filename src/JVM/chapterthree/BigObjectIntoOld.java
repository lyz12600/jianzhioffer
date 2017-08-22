package JVM.chapterthree;

/**
 * Created by liyanzhen on 17/1/9.
 * 大对象直接进入老年代
 * <p>
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728  //该参数对Parallel Scavenge收集器没用
 */
public class BigObjectIntoOld {
    private static final int _1MB = 1024 * 1024;

    public static void main(String args[]) {
        byte[] allocation;
        allocation = new byte[7 * _1MB];
    }
}
