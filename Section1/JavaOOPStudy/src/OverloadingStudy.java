package CodeStates.Section1.JavaOOPStudy.src;

class OverloadTest{
    public void print() {
        System.out.println("success-1");
    }

    void print(String a) {
        System.out.println("success-2");
        System.out.println(a);
    }

    String print(Integer a) {
        System.out.println("success-3");
        return a.toString();
    }

    String print(Integer a, Integer b) {
        System.out.println("success-4");
        return a.toString() ;
    }
    String print(Integer a, String b) {
        System.out.println("success-5");
        return a.toString() ;
    }

}


public class OverloadingStudy {
    public static void main(String[] args) {
        OverloadTest ot = new OverloadTest();
        ot.print();
        ot.print("String a");
        System.out.println(ot.print(6));
        System.out.println(ot.print(7,6));
        System.out.println(ot.print(7,"7"));
    }
}