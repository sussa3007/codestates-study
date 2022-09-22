package CodeStates.Section1.JavaOOPStudy.src;

public class ParameterStudy {

    public static void changeValue(String testVal) {
        testVal = "Change me";
        System.out.println("메소드 실행중 데이터 : " + testVal);
    }

    public static void main(String[] args) {
        String testVal = "test";

        System.out.println("메소드 호출 전 데이터 : " + testVal);
        //메소드 호출
        changeValue(testVal);

        System.out.println("메소드 호출 후 데이터 : " + testVal);
    }
}


class Data { int x; }


//            public static void main(String[] args) {
//                Data d = new Data();
//                d.x = 10;
//
//                Data d2 = copy(d);
//                System.out.println("d.x = "+d.x);        // d.x = 10
//                System.out.println("d2.x = "+d2.x);     // d2.x = 10
//
//            }
//                static Data copy(Data d) {  // 리턴 타입도 Data로 설정해야 한다.
//                    Data tmp = new Data();
//                    tmp.x = d.x;
//                    return tmp;
//                }
//}
