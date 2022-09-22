package CodeStates.Section1.JavaOOPStudy.src.InterfaceStudy;

interface Calculable { // 클래스의 형태를 규정
    static final double PI = 3.14; // 변수를 정의할수 있다. static과 final은 생략가능
    static void method () { // static 메소드는 가능하다
        System.out.println("Success!!");
    }
    default void method2 () { // default 메소드는 가능하다
        System.out.println("Success!!");
    }
    public abstract int sum(int v1, int v2);// public abstract 생략가능
}
interface Printable {
    void print();
}
class RealCal implements Calculable, Printable{
    // 하나의 클래스는 여러개의 인터패이스를 사용할수 있다.
    @Override
    public int sum(int v1, int v2) { // 메소드는 구체적인 구현을 해야됨.
        return v1+v2;
    }
    @Override
    public void print() {
        System.out.println("This is RealCal!!");
    }
}
class MyCal extends RealCal{
    public int multi(int v1, int v2){
        return v1*v2;
    }
}
abstract class toy {
    abstract void call();
    void call2 () {

    }
}
public class InterfaceStudy {
    public static void main(String[] args) {
        Calculable a = new RealCal();// a는 Calculable로서만 동작 - 인터페이스의 다형성
//        a.print(); 애러
        Printable b = new RealCal();// b는 Printable로서만 동작
//        b.sum(); 애러

        RealCal c = new RealCal();
        System.out.println(c.sum(2,1));
        c.print();
        System.out.println(c.PI); // 인터페이스를 구현한 객체는 인터페이스의 상수도 호출할수 있다.
        c.method2(); // 인터페이스의 default 메소드도 호출할수 있다.

        Calculable d = new MyCal();
        // 인터페이스를 구현한 클래스를 상속받은 클래스도 인터페이스 타입의 객체를 생성할수 있다.
        // Calculable의 멤버만 호출 가능하다.
//        d.print(); 애러
//        d.multi(2,6); //애러
    }
}
