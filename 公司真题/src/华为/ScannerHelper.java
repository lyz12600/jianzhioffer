package 华为;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerHelper {
    public static Scanner getScanner(String fileFath) {
        try {
            return getScanner(new FileInputStream(fileFath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Scanner getScanner(InputStream is) {
        return new Scanner(is);
    }
}
