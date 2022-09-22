package CodeStates.Section1.JavaOOPStudy.src;

class Animal2 { // 참조변수 this
    String mam; // 진짜 이름 this.mam
    String birds;// this.birds
    String pisces; // this.pisces
    Animal2(String mam, String birds, String pisces){
        // 참조변수 역할을 하는 this
        // this는 Animal2 클래스를 가르키고있음
        this.mam = mam;
        this.birds = birds;
        this.pisces = pisces;
        // 매개변수와 인스턴스 변수 이름이 다를때는 this 생략 가능
    }
}
public class thisVarStudy {
    public static void main(String[] args) {
        Animal2 a1 = new Animal2("Dog","Sparrow","shark");
        String a = a1.mam;
        String b = a1.birds;
        String c = a1.pisces;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
