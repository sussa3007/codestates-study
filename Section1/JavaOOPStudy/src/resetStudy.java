package CodeStates.Section1.JavaOOPStudy.src;

class Test00{
    static int t1 = 1; // Class 변수

    int t2; // Instance 변수

    static { // Class 변수의 초기화
       t1 = 15;
    }
    Test00(int t2) { // Instance 변수 생성자 초기화
        this.t2 = t2;
    }
    // 1. 클래스 생성과 동시에 로딩됨
    // 2. 클래스 변수가 디폴드 값으로 초기화됨 =0
    // 3. 클래스 변수가 연산자로 인하여 초기화 됨 =1
    // 4. static{} 으로 클래스 변수가 초기화 됨 =15
    // 클래스 로딩후 한번만 초기화 됨 이후에 객체를 재생성해도 초기화는 자동 되어있음
    // 객체 생성후
    // 5. 인스턴스 변수가 디폴드 값으로 초기화됨 = 0
    // 6. 인스턴스 변수가 생성자에 의해 초기화 됨 = t2
    //     여기서 t2는 객체생성 후 매개변수에 의해 초기화됨
}

public class resetStudy {
    public static void main(String[] args) {
        Test00 a1 = new Test00(25);
        System.out.println(a1.t2);
    }
}
// ===== 출력값 =====
//  25
