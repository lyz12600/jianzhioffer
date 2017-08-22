package trainning.copy;

/**
 * Created by liyanzhen on 17/4/24.
 */
public class CopyDemo02 {
    public static void main(String[] args) {
        Professor p = new Professor("zzj", 45);
        Student s = new Student("lyz", 12, p);
        Student s1 = null;

//        try {
//            s1 = (Student) s.clone();
////            s1.setP(new Professor(s.getP().name, s.getP().age));
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
        s1 = s;

        s1.name = "bb";
        s1.p.name = "aa";
        s1.p.age = 16;

        System.out.println(s + "**" + s.name + "**" + s.p.name);
        System.out.println(s1 + "**" + s1.name + "**" + s1.p.name);
    }
}
