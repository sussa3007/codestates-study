package CodeStates.Section1.JavaOOPStudy.src.InstanceOfStudy;

class Parentstest {
    void t1 () {
        System.out.println("Parents");
    }
}
class Childtest extends Parentstest {
    void t2 () {
        System.out.println("test1");
    }
}
class Childtest2 extends Parentstest {
    void t3 () {
        System.out.println("test2");
    }
}

public class InstanceOfStudy {
    public static void main(String[] args) {
        Parentstest a = new Parentstest();
        if (a instanceof Childtest) { // 부모 클래스 객체를 자식 클래스타입으로 형변환 불가
            Childtest b = (Childtest) a;
            b.t2();
        } else {
            System.out.println("Error!");
        }

        Childtest c = new Childtest();
        if (c instanceof Parentstest) { // 자식 클래스 객체를 부모 클래스 타입으로 형변환 가능
            Parentstest x = (Parentstest) c;
            x.t1();
        } else {
            System.out.println("Error!");
        }

        Parentstest t = (Parentstest) c;
        if (t instanceof Childtest2) { // 자식 클래스 객체를 부모 클래스 타입으로 형변환 후 그 참조변수를
            Childtest2 d = (Childtest2) t; // 다른 자식 클래스 객체로 형변환 불가
            d.t3();                         // = 같은 계층의 자식 클래스간 형변환 불가
        } else {
            System.out.println("Error!");
        }
    }
}