package CodeStates.Section1.JavaBasicStudy.src;

public class IfStudy {
    static boolean isOldEnoughToDrink(int age) {
        if (age >= 18) return true;
        else return false;
    }
    static String isGreaterThan30(int temp) {
        if (temp >= 30) return "에어컨을 켜야겠다!";
        else return "여름이 매우 덥네요";
    }
    static boolean equalsTen(int num) {
        if (num == 10) return true;
        else return false;
    }
    static boolean isGreaterThan(int num1, int num2) {
        if (num1 > num2) return false;
        else if (num1 < num2) return true;
        else return false;
    }
    static boolean isEven(int num) {
        if(num%2 == 0) return true;
        else return false;
    }
    static boolean isEvenAndGreaterThanTen(int num) {
        if (num >10 && num%2 ==0) return true;
        else if(num == 10) return false;
        else return false;
    }
    static String fizzBuzz(int num) {
        if (num%3==0 && num%5 ==0) return "FizzBuzz";
        else if (num%5 ==0) return "Buzz";
        else if (num%3 ==0) return "Fizz";

        else return "No FizzBuzz";

    }
    static int miniCalculator(int num1, int num2, char operator) {
        if (operator == '+') return num1+num2;
        else if (operator == '-') return num1-num2;
        else if (operator == '/') return num1/num2;
        else if (operator == '*') return num1*num2;
        else return 0;
    }
    static int daysInMonth(int month) {
        if (month == 1||month == 3||month == 5||month == 7||month == 8||month == 10||month == 12){
            return 31;
        } else if (month == 4||month == 6||month == 9||month == 11) {
            return 30;
        }else if (month == 2) return 28;
        else return 0;
    }
    static String followingDay(String day) {
        if (day.equals("월요일")) return "화요일";
        else if (day.equals("화요일")) return "수요일";
        else if (day.equals("수요일")) return "목요일";
        else if (day.equals("목요일")) return "금요일";
        else if (day.equals("금요일")) return "토요일";
        else if (day.equals("토요일")) return "일요일";
        else if (day.equals("일요일")) return "월요일";
        else return "올바른 요일이 아닙니다";
    }
    static boolean isEitherEvenAndLessThan9(int num1, int num2) {
        boolean result = false;
        if (num1%2==0 || num2%2 ==0) {
            if (num1<9 && num2<9){
                return result = true;
            }
        }
        else return result = false;
        return result;
    }
    public static String convertScoreToGradeWithPlusAndMinus(int score) {
        String grade;
        if (score > 100 || score < 0) {
            return "INVALID SCORE";
        }
        if (score == 100) {
            return "A+";
        }
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        if (!grade.equals("F")) {
            int extra = score % 10;
            if (extra <= 2) {
                grade = grade + "-";
            } else if (extra >= 8) {
                grade = grade + "+";
            }
        }

        return grade;
    }
    public static boolean isPythagorean(int side1, int side2, int side3) {
        int a =(int)Math.pow(side1,2);
        int b =(int)Math.pow(side2,2);
        int c =(int)Math.pow(side3,2);
        return a ==b+c || b==a+c || c==a+b;
    }
    public static boolean or(boolean expression1, boolean expression2) {
        if (expression1 != expression2) return true;
        return expression1;

    }
    public static String addOneSecond(int hour, int minute, int second) {
        if(second ==59){
            second = 0;
            minute +=1;
        } else second +=1;

        if (minute == 60) {
            minute = 0;
            hour+=1;
        }
        if (hour == 24){
            hour = 0;
        }
        return String.format("1초 뒤에 %d시 %d분 %d초 입니다",hour,minute,second);
    }







    public static void main(String[] args) {
        System.out.println(addOneSecond(12,16,59));

    }
}
