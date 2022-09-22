package CodeStates.Section1.JavaOOPStudy.src;

class InnerEx {
    class InsInner {}
    static class StaticInner {}

    InsInner ic = new InsInner(); // 인스턴스 클래스 내부에서 접근가능
    StaticInner sc= new StaticInner(); // Static 클래스도 접근가능

    static void staticMethod() {
//        InsInner ic1= new InsInner();  Error Static 멤버 내에서 인스턴스 멤버 접근 불가
        StaticInner sc1 = new StaticInner(); // Static 내부 클래스 멤버 접근 가능
    }
    void insMethod() {
        StaticInner sc2 = new StaticInner();  // 인스턴스 멤버에서 접근가능
        InsInner ic2 = new InsInner(); // 인스턴스 멤버에서 접근 가능
//        LocalInner lc1 = new LocalInner(); Error 지역 내부 클래스는 메소드 밖에서 접근 불가
    }
    void localMethod() {
        class LocalInner {} // 해당 메소드 내에서만 사용가능.
        LocalInner lc = new LocalInner();
    }
}
class Outer {
    private int outI = 0;
    private static int outC = 0;

    class InsInner { // 내부클래스는 같은 클래스 명 가능
        int t = outI;
        int t1 = outC;
    }
    static class StaticInner {
//        int c = outI; 인스턴스 변수 접근 불가능
        int c1 = outC;
    }
    void insMethod (){
        int lv = 0;
        final int lv1 = 1;
        class LocalInner {
            int lv2 = outI;
            int lv3 = outC;
            int lvset = lv;
            int lvset1 = lv1; // final 생략
        }
    }
}
class Anonymous {
    Object a = new Object();
    int method (int a) {
        System.out.println("Call A");
        return 1;
    }
}
public class InnerClassStudy {
    public static void main(String[] args) {
        Anonymous a = new Anonymous();
        a.method(5);
    }
}
