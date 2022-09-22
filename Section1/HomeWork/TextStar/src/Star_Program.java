package CodeStates.Section1.HomeWork.TextStar.src;

import java.util.ArrayList;
import java.util.Scanner;

public class Star_Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("[안내] TRPG 스타크래프트 시작합니다.");
        System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");
        System.out.print("[시스템] 유닛 [이름] 을 입력해 주세요 : ");
        String name = input.nextLine();
        System.out.print("[시스템] 유닛 [공격력] 을 입력해 주세요 : (Ex 50) ");
        String ad = input.nextLine();
        System.out.print("[시스템] 유닛 [방어력] 을 입력해 주세요 : (Ex 1) ");
        String def = input.nextLine();
        System.out.print("[시스템] 유닛 [체력] 을 입력해 주세요 : (Ex 100) ");
        String hp = input.nextLine();
        System.out.println();
        System.out.println("[안내] 생성된 유닛 정보는 다음과 같습니다.");
        System.out.println("[안내] " + name + " 유닛이 게임에 참여하였습니다.");
        System.out.println("[공격력] : " + ad);
        System.out.println("[방어력] : " + def);
        System.out.println("[체력] : " + hp);
        System.out.println("===========================================");
        System.out.println("[안내] 상대 유닛 정보를 입력해 주세요.");
        System.out.print("[시스템] 유닛 [이름] 을 입력해 주세요 : ");
        String name1 = input.nextLine();
        System.out.print("[시스템] 유닛 [공격력] 을 입력해 주세요 : (Ex 50) ");
        String ad1 = input.nextLine();
        System.out.print("[시스템] 유닛 [방어력] 을 입력해 주세요 : (Ex 1) ");
        String def1 = input.nextLine();
        System.out.print("[시스템] 유닛 [체력] 을 입력해 주세요 : (Ex 100) ");
        String hp1 = input.nextLine();
        System.out.println();
        System.out.println("[안내] 생성된 유닛 정보는 다음과 같습니다.");
        System.out.println("[안내] " + name1 + " 유닛이 게임에 참여하였습니다.");
        System.out.println("[공격력] : " + ad1);
        System.out.println("[방어력] : " + def1);
        System.out.println("[체력] : " + hp1);
        System.out.println("======================================");
        Star_char unit = new Star_char(); // 나의 유닛 객체를 생성합니다.
        Star_char enemy = new Star_char(); // 상대 유닛 객체를 생성합니다
        unit.user_create(name, ad, def, hp); // 입력받은 값으로 객체의 유닛 생성 메소드를 호출합니다
        enemy.user_create(name1, ad1, def1, hp1);
        System.out.println("[시스템] 공격 하시겠습니까? (y or n)"); // 공격 여부를 물어봅니다
        System.out.println("[시스템] N 입력시 프로그램을 종료합니다.");
        System.out.print("[안내] 입력하세요 : ");
        String go = input.nextLine();
        if(go.equalsIgnoreCase("y")){ // 소대문자에 상관없이 처리합니다.
            unit.attack(unit.user_info_int(unit.user_info()),enemy.user_info_int(enemy.user_info()));
        } else { // y외 명령어를 입력하였을시에는 프로그램 종료합니다
            System.exit(0);
        }
    }
}
class Star_char {
    private String name;
    private String ad;
    private String def;
    private String hp;
    private ArrayList<String> info = new ArrayList<>();
    private ArrayList<Integer> info_in = new ArrayList<>();
    // 게임에 필요한 변수 타입을 사전 정의합니다.

    ArrayList<String> user_info() {
//        System.out.printf("유닛의 정보는 이름 : %s / 공격력 : %s / 방어력 : %s / 체력 : %s %n ",info.get(0),info.get(1),info.get(2),info.get(3));
        return info;
    }
    void user_create(String name, String ad, String def, String hp) { // 입력 정보 받아서 info에 추가
        this.name = name;
        this.ad = ad;
        this.def = def;
        this.hp = hp;
        info.add(this.name);
        info.add(this.ad);
        info.add(this.def);
        info.add(this.hp);
    }
    ArrayList<Integer> user_info_int(ArrayList<String> info) { // 숫자로 된 문자열만 따로 리스트 정의
        for(int i=1; i<info.size(); i++){
            info_in.add(Integer.valueOf(info.get(i)));
        }
        return info_in;
    }
    void attack(ArrayList<Integer> user_info_int, ArrayList<Integer> enemy) { // 공격 구현
        int enemyhp = enemy.get(2);
        while (true){
            try { Thread.sleep(1000); } catch (InterruptedException e){}
            enemyhp -= (user_info_int.get(0)/enemy.get(1)); // 상대 체력 -= 자신 공격력/ 상대 방어력
            System.out.printf("[안내] [%s]유닛이 [공격]을 시작하였습니다.%n",this.name);
            if(enemyhp<=0){ // 체력 0보다 작을때 공격 종료
                System.out.println("[안내] 상대 유닛의 남은 [체력]은 0 입니다.");
                System.out.println("[안내] 더이상 공격할수 없습니다.");
                System.out.println("======================================");
                break;
            } else if(enemyhp>0){
                System.out.printf("[안내] 상대 유닛의 남은 [체력]은 %d 입니다.%n",hp);
                System.out.println("======================================");
            }
        }
        System.out.println("[안내] 상대 유닛이 제거되었습니다.");
    }
}