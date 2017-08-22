package api.transien;

import java.io.*;

/**
 * Created by liyanzhen on 17/6/15.
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