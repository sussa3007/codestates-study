package CodeStates.Section1.HomeWork.ElecBill.src;

import java.util.ArrayList;
import java.util.Scanner;

// 입력하는 값만큼 배열에 추가한다.
// 입력이 끝나면 전기료를 계산하는 명령어를 넣는다.
// 추가한 값을 하나씩 출력하면서,
// 그 값에 대한 전기요금을 차례로 나열하는 for문을 만든다.
// 값이 저장된 배열을 초기화하는 명령어를 만든다
// 문자열을 Integer로 형변환 하는 부분의 예외처리를 한다.
// 위 내용 출력
// 100kWh 이하는 kWh당 60.7원,
// 100kWh 초과는 125.9원
// 200kWh 초과는 187.9원
// 300kWh 초과는 280.6원
// 400kWh 초과는 417.7원
// 500kWh 초과는 670.6원

public class ElecBill { // 메인 메소드가 있는 클래스
    public static void main(String[] args) {
        Print a = new Print();
        a.print(); // 출력 인스턴스
    }
}

class Print { // 실행 클래스
    public void print() {
        System.out.println("=".repeat(25));
        System.out.println(" 주택용 전기요금(저압) 계산기 ");
        System.out.println("=".repeat(25));
        System.out.println("이번달 전력 사용량을 입력하세요");
        System.out.println("계산하려면 'q'를 입력하세요");
        System.out.println("초기화는 'd'를 입력하세요");

        ArrayList<String> valarr = new ArrayList<>(); // 입력 값을 저장할 객체 배열
        Scanner in = new Scanner(System.in);

        while (true) { // 명령어를 입력하기전까지 무한 루프
            try { // 문자열을 Integer 타입으로 형변환 하는 기능이 있어 예외 처리
                System.out.println(valarr); // 입력한 kWh를 배열에 저장
                System.out.print("사용량 : ");
                String val = in.nextLine().trim();
                valarr.add(val);

                if (val.equals("q")) { // q 명령어로 배열에 저장된 값들 계산
                    valarr.remove(valarr.size() - 1); // 명령어 q를 입력했을때 저장된 q를 지움

//                    for (int i = 0; i < valarr.size(); i++) {
//                        double a = Integer.parseInt(valarr.get(i));
//                        System.out.println(a + "kWh의 전기요금은 " + cul(a) + " 원 입니다");
//                    }
                    for (String s : valarr) {
                        double a = Integer.parseInt(s);
                        System.out.println(a + "kWh의 전기요금은 " + cul(a) + " 원 입니다");
                    }
                    break;
                } else if (val.equals("d")) { // d 명령어로 저장된 값을 초기화
//                    for (int i = valarr.size() - 1; i >= 0; i--)
//                        valarr.remove(i);
                    valarr.subList(0, valarr.size()).clear();
                    // 저장된 배열 초기화
                }
            } catch (Exception e) {
                System.out.println("숫자만 입력하세요!!");
            }
        }


    }

    public static double cul(double w) { // 요금 계산 메소드
        double a = (100 * 60.7);
        double b = (100 * 125.9);
        double c = (100 * 187.9);
        double d = (100 * 280.6);
        double e = (100 * 417.7);

        if (w <= 100) {
            return w * 60.7;
        } else if (w <= 200) {
            return a + ((w - 100) * 125.9);
        } else if (w <= 300) {
            return a + b + ((w - 200) * 187.9);
        } else if (w <= 400) {
            return a + b + c + ((w - 300) * 280.6);
        } else if (w <= 500) {
            return a + b + c + d + ((w - 400) * 417.7);
        } else return (a + b + c + d + e + ((w - 500) * 670.6));

    }
}



