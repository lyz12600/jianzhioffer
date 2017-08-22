package lingsan;

import java.io.*;

/**
 * Created by liyanzhen on 16/11/7.
 */
class Professor implements Serializable {
    String name;
    int age;

    Professor(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student implements Serializable {
    String name;// 常量对象。
    int age;
    Professor p;// 学生1和学生2的引用值都是一样的。

    Student(String name, int age, Professor p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }

//    public Object deepClone() throws IOException, OptionalDataException, ClassNotFoundException {//将对象写到流里
//        ByteArrayOutputStream bo = new ByteArrayOutputStream();
//        ObjectOutputStream oo = new ObjectOutputStream(bo);
//        oo.writeObject(this);//从流里读出来
//        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
//        ObjectInputStream oi = new ObjectInputStream(bi);
//        return (oi.readObject());
//    }
}

public class CloneDemo {
    public static void main(String[] args) {
        Professor p = new Professor("wangwu", 50);
        Student s1 = new Student("zhangsan", 18, p);
        Student s2 = null;
//        try {
//            s2 = (Student) s1.deepClone();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        s2.p.name = "lisi";
        s2.p.age = 30;
        System.out.println("name=" + s1.p.name + "," + "age=" + s1.p.age);
        System.out.println("name=" + s2.p.name + "," + "age=" + s2.p.age);
        //输出结果学生1和2的教授成为lisi,age为30。
    }
}
