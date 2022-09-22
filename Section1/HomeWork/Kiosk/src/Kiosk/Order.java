package CodeStates.Section1.HomeWork.Kiosk.src.Kiosk;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BiFunction;

class Order {
    private BiFunction<String, String,Boolean> f = String::equalsIgnoreCase;
    // 자주 쓰이는 메소드 람다로 변경
    private Scanner input = new Scanner(System.in);
    private ArrayList<Food> orderList = new ArrayList<>(); // 선택 메뉴를 저장
    private int[] costAll = new int[10]; // 선택 메뉴의 수량에 비례한 값을 배열로 저장
    private Food[] menu = new Food[]{ // 메뉴는 추가할수 있도록 객체 배열로 접근
            new Kimbap("김밥", 1000),
            new EggKimbap("계란김밥", 1500),
            new ChungmuKimbap("충무김밥", 2000),
            new Tteokbokki("떡볶이", 3000)};

    public void count() {
        // 음식을 선택해서 List에 넣는다
        for (int i = 0; i < menu.length; i++) {             // 전메뉴를 복수로 선택할수 있게 구현
            input_print();                                  // 반복되며 메뉴를 보여주기위해 for문에 삽입
            int food = exitOrder(input.nextLine());         // exitOrder메소드에서 int 타입으로 변환해서 반환
            if (food > 0 && food <= menu.length) {          // 메뉴 갯수만큼 선택 가능하도록 구현
                orderList.add(menu[food - 1]);              // 선택한 메뉴 orderList에 삽입
            } else {
                System.out.println("[안내]메뉴에 포함된 번호를 입력하여 주세요.");
                i--;                                        // 비정상 입력시 i값 초기화후 재 반복
                continue;
            }
            System.out.println("[안내]선택하신 메뉴의 수량을 입력하여 주세요.");
            System.out.println("(※ 최대 주문 가능 수량 : 10)");
            int count = exitOrder(input.nextLine());
            if (count > 0 && count <= 10) {
                costAll[i] = orderList.get(i).getCost()*count; // 메뉴의 총 가격만 뽑아서 삽입
            } else {
                System.out.println("[안내]최대 주문 가능수량은 10 입니다.");
                orderList.remove(i);                        // 비정상 입력시 위에서 추가된 menu 삭제
                i--;                                        // 비정상 입력시 i값 초기화
                continue;
            }
            selectOption();
        }
    }

    public void cost () {                                   // 손님이 선택한 orderList를 출력 안내
        while (true){                                       // 비정상 입력시 재 확인.
            System.out.println("[안내] 주문 하신 메뉴 리스트와 가격입니다.");
            for (int i = 0; i < orderList.size(); i++) {
                System.out.printf(" / %s X %d (%d 원) ",    // 메뉴, 수량 , 총가격 출력
                        orderList.get(i).getName(),(costAll[i]/(orderList.get(i).getCost())),costAll[i]);
            }
            System.out.println();
            System.out.println("[안내] 계산 하시겠습니까? (y) / 종료 및 취소 (q)");
            String go = input.nextLine();
            if (f.apply("Q",go)){
                exitOrder(go); break;
            }else if (f.apply("Y",go)) {
                output_print(costAll); break;
            }else System.out.println("[시스템] y 또는 q 를 입력해주세요");
        }
    }
    private void input_print() {                             // 초입 안내 멘트
            System.out.println("[안내]원하시는 메뉴의 번호를 입력하여 주세요.");
            System.out.println("[안내]종료 하시려면 q를 입력해 주세요.");
            for (int i = 0; i < menu.length; i++) {         //전 메뉴 출력
                System.out.printf("%d) %s (%d 원) ", i + 1, menu[i].getName(), menu[i].getCost());
            }
            System.out.println();
    }
    private void selectOption() {
        while (true){
            // 메뉴 선택이 끝나면 계산 or 메뉴추가 or 프로그램 종료
            System.out.println("[안내] 계산하러 가기 : y / 메뉴 추가 : g / 종료 q");
            String go = input.nextLine();
            if (f.apply("G",go)) { break;
            } else if(f.apply("Y",go)) { cost(); break;
            } else if (f.apply("Q",go)) { exitOrder(go);
            } else System.out.println("[시스템] y 또는 g 또는 q 를 입력해주세요");
        }
    }


    private int exitOrder (String exit){                    // input 값 받아 프로그램 종료
        int num = 0;
        if (f.apply("Q",exit)) {
            System.out.println("[시스템] 프로그램 종료.");
            System.exit(0);
        }
        try { // 문자열 입력시 예외 처리
            num = Integer.parseInt(exit);
        } catch (Exception e){
            System.out.println("[시스템] 비정상 입력 되었습니다 처음부터 다시 입력해주세요.");
            System.out.println();
            count();
        }
        return num;
    }
    private void output_print (int[] costAll){               //마지막 총 합계 금액 출력 후 종료
        int all = 0;
        for(int i:costAll) all += i;
        System.out.printf("[안내]주문하신 메뉴의 총 금액은 %d 원 입니다.",all);
        System.out.println();
        System.out.println("[안내]이용해 주셔서 감사합니다.");
        System.out.println("[시스템] 프로그램 종료.");
        System.exit(0);
    }
}

