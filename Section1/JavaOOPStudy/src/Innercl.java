package CodeStates.Section1.JavaOOPStudy.src;

class Outer1 { //외부 클래스
    private int num = 1; //외부 클래스 인스턴스 변수
    private static int sNum = 2; // 외부 클래스 정적 변수

    private InClass inClass; // 내부 클래스 자료형 변수 선언
    private  Outer Good;
    public Outer1() {
        inClass = new InClass();
    }

    class InClass { //인스턴스 내부 클래스
        int inNum = 10; //내부 클래스의   인스턴스 변수

        void Test() {
            System.out.println("Outer num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("Outer sNum = " + sNum + "(외부 클래스의 정적 변수)");
        }
    }

    public void testClass() {
        inClass.Test();
    }
}

public class Innercl {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        System.out.println("외부 클래스 사용하여 내부 클래스 기능 호출");
        outer.testClass(); // 내부 클래스 기능 호출
    }
}

// 출력값

//    외부 클래스 사용하여 내부 클래스 기능 호출
//        Outer num = 1(외부 클래스의 인스턴스 변수)
//        Outer sNum = 2(외부 클래스의 정적 변수)