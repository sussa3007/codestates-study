package CodeStates.Section1.JavaOOPStudy.src;

class Example {
    int a;
    int b;
    Example() {}
    Example (int a, int b) {
        this.a = a;
        this.b = b;
    }


    int add (int a, int b) {
        System.out.println(a+b);
        return a+b;
    }
}
class ExampleChild extends Example {
    int c;
    ExampleChild(int a, int b, int c) {
        super(a,b); // 생성자 super
        this.c = c;
    }

    void add () {
        // 참조변수 super
        System.out.println(super.add(a,b)+c);
    }
}
public class ParantChildtest {
    public static void main(String[] args) {
        ExampleChild t = new ExampleChild(1,2,3);
        t.add();
    }
}






