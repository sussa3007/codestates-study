package CodeStates.Section1.JavaOOPStudy.src;

final class MyMath {
    int a, b ;
    static int add(int a, int b) {
        return a+b;
    }
    int multiply(int a, int b) {
        return a*b;
    }
    final int c = 2;
    int DIVISION(int a,int b, int c) {
        return (a+b)/c;
    }
}
class MyMath2 /* extends MyMath */{ // final 클래스로서 상속이 불가능
    final void add2() {
        System.out.println("hi");
    }
}

abstract class MyMath3 extends MyMath2{
    abstract void division ();
//    void add2 () { final 제어자 메소드는 자식 클래스에서 재 정의 불가
//
//    }
}

public class ModifireStudy {
    public static void main(String[] args) {
        MyMath t = new MyMath();
        t.a = 3;
        t.b = 9;
//        t.c = 5; 상수로서 재 정의 불가능
//        MyMath3 p = new MyMath3(); // 추상화 클래스는 객체화 할수없다
    }
}
