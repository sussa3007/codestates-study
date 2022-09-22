package CodeStates.Section1.HomeWork.TextStar.src.Star_char1;

import java.util.ArrayList;
import java.util.Scanner;

public class Star_char1 {
    Scanner input = new Scanner(System.in);

    private String name;
    private String ad;
    private String def;
    private String hp;
    private ArrayList<String> info = new ArrayList<>();
    private ArrayList<Integer> info_in = new ArrayList<>();
    // 게임에 필요한 변수 타입을 사전 정의합니다.

    public void user_info() {
        System.out.println("[안내] 생성된 유닛 정보는 다음과 같습니다.");
        System.out.println("[안내] " + this.name + " 유닛이 게임에 참여하였습니다.");
        System.out.println("[공격력] : " + this.ad);
        System.out.println("[방어력] : " + this.def);
        System.out.println("[체력] : " + this.hp);
        System.out.println("===========================================");

    }

    public void attackNexit(Star_char1 unit, Star_char1 enemy) {
        System.out.println("[시스템] 공격 하시겠습니까? (y or n)"); // 공격 여부를 물어봅니다
        System.out.println("[시스템] N 입력시 프로그램을 종료합니다.");
        System.out.print("[안내] 입력하세요 : ");
        String go = input.nextLine();
        if (go.equalsIgnoreCase("y")) { // 소대문자에 상관없이 처리.
            unit.attack(unit, enemy);
        } else { // y외 명령어를 입력하였을시에는 프로그램 종료합니다
            System.exit(0);
        }
    }

    public void user_create() { // 입력 정보 받아서 info에 추가
        System.out.print("[시스템] 유닛 [이름] 을 입력해 주세요 : ");
        this.name = input.nextLine();
        System.out.print("[시스템] 유닛 [공격력] 을 입력해 주세요 : (Ex 50) ");
        this.ad = input.nextLine();
        System.out.print("[시스템] 유닛 [방어력] 을 입력해 주세요 : (Ex 1) ");
        this.def = input.nextLine();
        System.out.print("[시스템] 유닛 [체력] 을 입력해 주세요 : (Ex 100) ");
        this.hp = input.nextLine();
        info.add(this.name);
        info.add(this.ad);
        info.add(this.def);
        info.add(this.hp);
    }

    ArrayList<Integer> user_info_int(Star_char1 unit) { // 숫자로 된 문자열만 따로 리스트 정의

        for (int i = 1; i < unit.info.size(); i++) {
            info_in.add(Integer.valueOf(info.get(i)));
        }
        return info_in;
    }

    void attack(Star_char1 unit, Star_char1 enemy) { // 공격 구현
        int enemyhp = enemy.user_info_int(enemy).get(2);
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            enemyhp -= (unit.user_info_int(unit).get(0) / enemy.user_info_int(enemy).get(1));
            // 상대 체력 -= 자신 공격력/ 상대 방어력
            System.out.printf("[안내] [%s]유닛이 [공격]을 시작하였습니다.%n", this.name);
            if (enemyhp <= 0) { // 체력 0보다 작을때 공격 종료
                System.out.println("[안내] 상대 유닛의 남은 [체력]은 0 입니다.");
                System.out.println("[안내] 더이상 공격할수 없습니다.");
                System.out.println("======================================");
                break;
            } else if (enemyhp > 0) {
                System.out.printf("[안내] 상대 유닛의 남은 [체력]은 %d 입니다.%n", enemyhp);
                System.out.println("======================================");
            }
        }
        System.out.println("[안내] 상대 유닛이 제거되었습니다.");
    }
}
