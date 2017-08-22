package 交替打印.synchronize;

/**
 * Created by liyanzhen on 17/6/22.
 */
public class SyncObj {
    private char letter = 'A';

    public void nextLetter() {
        switch (letter) {
            case 'A':
                letter = 'B';
                break;
            case 'B':
                letter = 'C';
                break;
            case 'C':
                letter = 'A';
                break;
            default:
                break;
        }
    }

    public char getLetter() {
        return letter;
    }
}
