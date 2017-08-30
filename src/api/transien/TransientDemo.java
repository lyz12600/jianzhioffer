package api.transien;

import java.io.*;

/**
 * Created by liyanzhen on 17/6/15.
 * 当对象被序列化时（写入字节序列到目标文件）时，
 * transient阻止实例中那些用此关键字声明的变量持久化；
 * 当对象被反序列化时（从源文件读取字节序列进行重构），
 * 这样的实例变量值不会被持久化和恢复。
 * 例如，当反序列化对象——数据流（例如，文件）可能不存在时，
 * 原因是你的对象中存在类型为java.io.InputStream的变量，
 * 序列化时这些变量引用的输入流无法被打开。
 */
public class TransientDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("lyz");
        user.setPassword("abcdef");

        System.out.println("read before Serializable:");
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/Users/liyanzhen/user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //这说明反序列化后类中static型变量username的值为当前JVM中对应static变量的值，
            //为修改后llh，而不是序列化时的值lyz。
            user.setUsername("llh");
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("/Users/liyanzhen/user.txt"));
            user = (User) is.readObject();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("=============================");
        System.out.println("read after Serializable:");
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
    }
}

class User implements Serializable {
    private static String username;
    private transient String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}