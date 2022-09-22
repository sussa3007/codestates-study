package CodeStates.Section1.HomeWork.GuguDanApp.src;

import java.util.Scanner;

public class Gugudan {
    static final int LOW = 2;
    static final int HIGH = 9;
    static int val = 0;
    public static void main(String[] args) {
//        [안내]희망하는 구구단을 숫자로 입력해 주세요 (2 ~ 9) : 10
//        10 단 이 입력되었습니다.
//        [경고]구구단은 2단 ~ 9단 까지만 선택할 수 있습니다.
//        프로그램을 종료합니다
        inputval(val);
    }
    static void inputval (int val) { // 입력부
        Scanner input = new Scanner(System.in);

        while (true){ // 작동부
            System.out.print("[안내]희망하는 구구단을 숫자로 입력해 주세요 (2 ~ 9) : ");
            try { // int 타입 여부로 예외처리
                val = input.nextInt();
                System.out.println(val + "단이 입력 되었습니다.");
            } catch (Exception e) {
                System.out.println("숫자를 입력해 주세요!!");
                continue; // int 타입 외 데이터가 Input 되면 다시 입력하도록 설
            }
            if ((LOW <= val) && (val <= HIGH)) {dan(val); break;} // 범위 내 int 입력시 실행 후 프로그램 종료
            else { // 범위 외 int 입력시 재 입력
                System.out.println("[경고]구구단은 2단 ~ 9단 까지만 선택할 수 있습니다.");
                System.out.println("다시 입력해 주세요.");
            }
        }
    }
    static void dan (int val) { // 출력부
        int a;
        System.out.println(val+" x 1 = "+val); // val * 1 은 모든 단 동일 값 항상 출력
        for(int i = LOW; i<=HIGH; i++) { // 2~9까지 곱하여 구구단 출
            a= val * i;
            System.out.println(val+" x "+i+" = 력"+a);
        }
    }
}
