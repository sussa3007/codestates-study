package CodeStates.Section1.JavaBasicStudy.src;

import java.util.GregorianCalendar;
class Solution {}


public class DateStudy {
    public static void main(String[] args) {

        GregorianCalendar c = new GregorianCalendar();

        String result5 = String.format("현재 시각은 %tI 시 %<tM 분 %<tS 초 입니다", c);
        System.out.println(result5);

        System.out.println(showTime(9,12,24));

    }
    public static String showTime(int hour, int min, int sec) {
        // TODO:
        String now= String.format("현재 시각은 %1$d 시 %2$d 분 %3$d 초 입니다",hour,min,sec);
        return now;

    }

}

