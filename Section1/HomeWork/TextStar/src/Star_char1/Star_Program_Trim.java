package CodeStates.Section1.HomeWork.TextStar.src.Star_char1;


public class Star_Program_Trim {
    public static void main(String[] args) {
        Star_char1 unit = new Star_char1(); // 나의 유닛 객체를 생성.
        Star_char1 enemy = new Star_char1(); // 상대 유닛 객체를 생성.

        System.out.println("[안내] TRPG 스타크래프트 시작합니다.");
        System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");
        System.out.println("===========================================");
        unit.user_create(); // 입력받은 값으로 객체의 유닛 생성 메소드를 호출
        unit.user_info();

        System.out.println("[안내] 상대 유닛 정보를 입력해 주세요.");
        enemy.user_create();
        enemy.user_info();
        unit.attackNexit(unit,enemy);
    }
}
