package CodeStates.Section1.HomeWork.ChangeSub.src;

import java.util.Arrays;
import java.util.Scanner;

public class ChangeSub {
    static final String ID = "aaaa"; // 나중에 Map로 데이터 받아서 회원가입까지 해보자
    static final String PW = "1234";
    static String sub = "";
    static String[] word = {"킹", "시발", "꺼져", "미친", "개새끼","새끼","죽어"};
    static String[] reword = {"꽃", "출발", "잘가", "멋진", "강아지","아기", "잘살아"};
    static Scanner input = new Scanner(System.in);


    static void login() { // 로그인 메소드
        while (true){
            System.out.print("[시스템] 아이디를 입력하세요 : ");
            String id = input.nextLine();
            System.out.print("[시스템] 비밀번호를 입력하세요 : ");
            String pw = input.nextLine();
            if (id.equals(ID) && pw.equals(PW)){ // 정상 로그인 후 자막입력 란 출력
                System.out.printf("[안내] 안녕하세요 %s 님.%n",ID);
                System.out.println("[안내] 유튜브 영상의 자막을 생성해 주세요.");
                System.out.print(" 자막 입력 : ");
                sub = input.nextLine();
                System.out.println("========================================");
                print(sub);
                break;
            } else { // 아이디 비밀번호가 틀리다면 출력
                System.out.println("아이디와 비밀번호가 틀렸습니다, 다시 입력해주세요.");
            }
        }
    }

    static void print (String sub) { // 출력부
        System.out.println("[알림] 프로그램의 금칙어 리스트입니다.");
        System.out.println(Arrays.toString(word));
        System.out.println("========================================");
        System.out.println("[알림] 자막 순화 프로그램 결과입니다.");
        System.out.println();
        System.out.print(">>>>  ");
        for(int i=0; i<word.length; i++){ // 입력 받은 자막을 수정해서 출력
            sub = sub.replaceAll(word[i],reword[i]);
        }
        System.out.println(sub);
        System.out.println();
        System.out.println("[안내] 프로그램을 종료합니다.");
    }

    public static void main(String[] args) {
        login();
    }
}



