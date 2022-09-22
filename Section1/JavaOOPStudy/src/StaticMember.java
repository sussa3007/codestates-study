package CodeStates.Section1.JavaOOPStudy.src;

class TestData {
    String iv; // 인스턴스 변수
    static String cv; // 클래스 변수

    static void funcClass(TestData var) {
        var.iv = "Instasce Var Change by Method";
    }

    void functInstance(TestData var) {
        var.cv = "Class Var Change by Method";

    }

    void localVal() {
        int localv;
//        System.out.println(localv); 변수를 초기화 하지 않고 호출하게 되면 에러발생
        return;
    }
}
    public class StaticMember {
        public static void main(String[] args) {
//            TestData me = null; // 객체 선언 Stack 메모리 할당
//            System.out.println(me);  // null 출력
//            me = new TestData();
//            System.out.println(me); // Heap 메모리 주소 출력

            TestData x = new TestData();
            TestData p = new TestData();
            test_0 t = new test_0();
            t.setY();
            System.out.println(p.cv);


        }
    }
class test_0 {
    public void setY() {
        TestData y = new TestData();
        y.cv = "a";
    }
}

//        TestData you = new TestData(); // 객체 2 선언
//
//        System.out.println(me.iv); // 인스턴스 변수 출력
//        me.iv = "Change me!!"; // 인스턴스 변수 초기화
//        System.out.println("Main val = "+me.iv); // 변경된 인스턴스 변수 출력
//
//        me.funcClass(me); // 클래스 메소드를 통한 인스턴스 변수 다시 초기화 와 출력
//
//        System.out.println(me.cv); // 변경전 클래스 변수 출력
//        me.functInstance(me);// 인스턴스 메소드를 통한 클래스 변수 초기화 와 출력
//
//        System.out.println("Method After val = "+me.iv); // 변경된 인스턴스 변수 출력
//
//        System.out.println("===== 새로운 객체 Test =====");
//        System.out.println(you.iv); // 인스턴스 변수 출력
//        System.out.println(you.cv); // 클래스 변수 출력
//
//        me.iv = "One more time IV Change me!!"; // me 객체의 참조변수로 인스턴스 변수 초기화
//        you.cv = "One more time CV Change me!!"; // 클래스 변수 초기화
//
//        System.out.println(you.iv); // you 객체의 변경된 인스턴스 변수 출력
//
//        System.out.println(you.cv); // you 객체에서 호출된 클래스 변수 출력
//        System.out.println(me.cv); // me 객체의 참조변수로 호출된 클래스 변수 출력







