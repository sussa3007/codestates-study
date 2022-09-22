package CodeStates.Section1.JavaOOPStudy.src;

class Animal00 { // 생성자 this
    String mam;
    String birds;
    String Pisces;
//   Animal00() { // 기본 생성자
//        //기본 생성자의 디폴드 값
//        mam = "Dog";
//        birds = "Sparrow";
//        Pisces = "shark";
//    } // 아래 생성자와 스타일이 비슷하므로 중복 코드로서 개선필요
    Animal00(){ // 기본 생성자
        // 기본생성자의 디폴드값
        this("Dog","Sparrow","shark");
        // this는 아래 생성자1을 가르킴
        // 같은 클래스의 다른 생성자를 호출할 때 사용한다
    }
    Animal00(String a, String b, String c) { // 생성자 1
        mam = a;
        birds = b;
        Pisces = c;
    }
}


public class thisStudy {
    public static void main(String[] args) {
        Animal00 a1 = new Animal00();
        String a = a1.mam;
        String b = a1.birds;
        String c = a1.Pisces;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        Animal00 a2 = new Animal00("Cat","Pigeon","Mackerel" );
        String e = a2.mam;
        String f = a2.birds;
        String g = a2.Pisces;

        System.out.println(e);
        System.out.println(f);
        System.out.println(g);

    }
}
