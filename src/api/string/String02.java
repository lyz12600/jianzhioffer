package api.string;

/**
 * new操作只进行了一次，也就是说只生成了一个对象，
 * append操作是在原有对象的基础上进行的。
 * 因此在循环了10000次之后，这段代码所占的资源要比上面小得多。
 */
public class String02 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("hello");
        }
    }
}
