package api.string;

/**
 * 每次循环会new出一个StringBuilder对象，然后进行append操作，
 * 最后通过toString方法返回String对象。也就是说这个循环执行完毕new出了10000个对象，
 * 试想一下，如果这些对象没有被回收，会造成多大的内存资源浪费
 */
public class String01 {
    public static void main(String[] args) {
        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += "hello";
        }
    }
}
