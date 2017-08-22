package niuke;

/**
 * Created by liyanzhen on 17/3/5.
 */

class Two {
    Byte x;
}

public class Pass0 {
    public static void main(String args[]) {
        Pass0 pass0 = new Pass0();
        pass0.start();
    }

    private void start() {
        Two two = new Two();
        System.out.println(two.x);
        Two two2 = fix(two);
        System.out.println(two.x + "***" + two2.x);
    }

    private Two fix(Two two) {
        two.x = 42;
        return two;
    }
}
