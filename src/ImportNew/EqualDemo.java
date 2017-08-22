package ImportNew;

import java.lang.reflect.Field;

/**
 * Created by liyanzhen on 16/12/22.
 * 小数据范围用缓存，进行内存优化
 * －128～127
 * 可以使用相同的底层对象，实现设置，进行内存优化
 * 对Integer对象，JVM会自动缓存-128~127范围内的值，
 * 所以所有在这个范围内的值相等的Integer对象都会共用一块内存，而不会开辟多个；
 * 超出这个范围内的值对应的Integer对象有多少个就开辟多少个内存。
 */
public class EqualDemo {
    public static void main(String args[]) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);

        Integer c = 100;
        Integer d = 100;
        System.out.println(c == d);

        int e = 1000;
        int f = 1000;
        System.out.println(e == f);

        int g = 100;
        int h = 100;
        System.out.println(g == h);

//        Class cache = Integer.class.getDeclaredClasses()[0];
//        Field myCache = cache.getDeclaredField("cache");
//        myCache.setAccessible(true);
//
//        Integer[] newCache = (Integer[]) myCache.get(cache);
//        newCache[132] = newCache[133];
//
//        int a = 2 ;
//        int b = a + a;
//        System.out.printf("%d + %d ＝%d" ,a,a,b);
    }
}
