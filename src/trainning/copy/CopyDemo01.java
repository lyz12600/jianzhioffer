package trainning.copy;

import java.io.*;

/**
 * Created by liyanzhen on 17/4/24.
 */

class Professor{
    String name;
    int age;


    public Professor(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student implements Cloneable {
    String name;
    int age;
    Professor p;

    Student(String name, int age, Professor p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Professor getP() {
        return p;
    }

    public void setP(Professor p) {
        this.p = p;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student s = (Student) super.clone();
        return s;
    }

//    //深拷贝
//    public Object deepClone() throws IOException, OptionalDataException, ClassNotFoundException {//将对象写到流里
//        ByteArrayOutputStream bo = new ByteArrayOutputStream();
//        ObjectOutputStream oo = new ObjectOutputStream(bo);
//        oo.writeObject(this);//从流里读出来
//        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
//        ObjectInputStream oi = new ObjectInputStream(bi);
//        return (oi.readObject());
//    }
}

public class CopyDemo01 {
    public static void main(String[] args) {
        Professor p = new Professor("wyr", 45);
        Student s = new Student("lyz", 12, p);
        Student s1 = null;
//
//        try {
//            s1 = (Student) s.deepClone();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        s1.p.name = "zzj";
        s1.p.age = 16;


        System.out.println(s + "**" + s.p.name);
        System.out.println(s1 + "**" + s1.p.name);
    }
}
