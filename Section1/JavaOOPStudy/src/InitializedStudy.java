package CodeStates.Section1.JavaOOPStudy.src;

class Init {
    int a =7;
    String b;
    { b="init"; }
    boolean c;
    Init (){
        c = true;
    }
    char d;
    static int w = 1;
    static {x = "init";}
    static String x;

    static boolean y;
    static char z;
}

public class InitializedStudy {
    public static void main(String[] args) {
        System.out.println(Init.w);
        System.out.println(Init.x);
        System.out.println(Init.y);
        System.out.println(Init.z);

        Init in = new Init();
        in.d = 'B';
        System.out.println(in.a);
        System.out.println(in.b);
        System.out.println(in.c);
        System.out.println(in.d);
    }
}
