package CodeStates.Section1.JavaBasicStudy.src;

import static java.lang.String.*;

public class MathStudy {
    public static void main(String[] args) {
        char result ;
        int num ;
        num = 1;
        result = Character.forDigit(num,10);
        System.out.println(result);
        String word1 = "was";
        String word2 = "this";

        int a = (int) Math.floor((word1.length()+word2.length())/2);
        System.out.println(a);


        System.out.println(computeDifference(2,10));
        String x = word1.toUpperCase();
        String y = word1.toUpperCase();
        System.out.println(x.equals(y));



    }


    public static String computeDifference(int num1, int num2){
        System.out.println();
        return format("%d, %d의 차이는 %d입니다.",num1,num2,Math.abs(num1-num2));


    }
}
