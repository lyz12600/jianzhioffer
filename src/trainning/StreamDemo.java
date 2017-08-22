package trainning;

import java.io.*;

/**
 * Created by liyanzhen on 17/4/9.
 */
public class StreamDemo {
    public static void main(String[] args) {
        StreamDemo streamDemo = new StreamDemo();
//        streamDemo.testOutputStream();
//        streamDemo.testInputStream();
        streamDemo.testWriter();
        streamDemo.testReader();
    }

    public void testOutputStream() {
        String str = "hello";
        byte[] b = str.getBytes();
        //使用file类找到一个文件
        File f = new File(File.separator + "Users" + File.separator + "liyanzhen" + File.separator + "test.txt");
        OutputStream out = null;
        //通过子类实例化
        try {
            out = new FileOutputStream(f);
            out.write(b);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testInputStream() {
        File f = new File(File.separator + "Users" + File.separator + "liyanzhen" + File.separator + "test.txt");
        InputStream in = null;
        byte[] b = new byte[1024];
        int temp = 0, len = 0;
        try {
            in = new FileInputStream(f);
            while ((temp = in.read()) != -1) {
                b[len] = (byte) temp;
                len++;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(b, 0, len));
    }

    public void testWriter() {
        String str = "lyz";
        //使用file类找到一个文件
        File f = new File(File.separator + "Users" + File.separator + "liyanzhen" + File.separator + "test.txt");
        Writer w = null;
        //通过子类实例化
        try {
            w = new FileWriter(f);
            w.write(str);
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testReader() {
        File f = new File(File.separator + "Users" + File.separator + "liyanzhen" + File.separator + "test.txt");
        Reader r = null;
        char[] c = new char[1024];
        int temp = 0, len = 0;
        try {
            r = new FileReader(f);
            while ((temp = r.read()) != -1) {
                c[len] = (char) temp;
                len++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(c,0,len));
    }
}
