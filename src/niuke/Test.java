package niuke;

/**
 * Created by liyanzhen on 17/7/11.
 */
class A extends Object {
    private int a;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this;
    }
}

public class Test {
    public static void main(String[] args) {
        try {
            A a = new A();
            A b = (A) a.clone();
            System.out.println(a);
            System.out.println(b);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

