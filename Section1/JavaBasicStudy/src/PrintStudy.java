package CodeStates.Section1.JavaBasicStudy.src;

import java.util.Scanner;                  // Scanner 클래스를 가져옵니다.

public class PrintStudy {
    public static void main(String[] args) {
        System.out.printf("%s%n", "Hello JAVA"); // 줄바꿈이 됩니다.
        System.out.printf("%s%n", "Kim" + "Coding");
        System.out.printf("%d%n", 3+6);
        System.out.printf("지금은 %s입니다", 2022 + "year"); // 자동 타입 변환이 일어납니다.
        System.out.printf("나는 %c%s입니다", '김', "코딩"); //여러 개의 인자를 넣을 수 있습니다.


        Scanner scanner = new Scanner(System.in); // Scanner 클래스의 인스턴스를 생성합니다.
        String inputValue = scanner.nextLine();   // 입력한 내용이 inputValue에 저장됩니다.
        int inputValue1 = scanner.nextInt();   //
        float inputValue2 = scanner.nextFloat();   //


        System.out.println(inputValue);           // 입력한 문자열이 출력됩니다.
    }
}

