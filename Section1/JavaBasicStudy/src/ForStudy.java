package CodeStates.Section1.JavaBasicStudy.src;

import com.sun.source.tree.BreakTree;

public class ForStudy {
    static int sum(int num) {
        int result = 0;
        for (int i = 0; i <= num; i++) {
            result = result + i;
        }
        return result;
    }

    static boolean odd(int num) {
        while (true) {
            if ((num & 1) != 0) {
                return true;
            } else return false;
        }
    }

    static int factorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
    static String makeDigits(int num) {
        String result = "";
        for (int i =1; i<=num; i++) {
            result += i+"";
        }
        return result;
    }
    static String makeDigits2(int num) {
        String result = "1";
        int i = 2;
        while (i<=num){
            result= result +"-"+i;
            i++;
        }
        return result;
    }
    static String makeOddDigits(int num) {
        String result = "";
        int i = 1;
        while (i<=num){
            if (i%2!=0) {
                result += i;
            }
            i++;
        }
        return result;
    }
    static String makeMultiplesOfDigit(int num) {
        String result = "";
        for (int i = 1; i <= num; i++){
            if(i%3 ==0){
                result += i;
            }

        }
        return result;
    }
    static int makeMultiplesOfDigit2(int num1, int num2) {
        int result =0;
        int a;
        int b;
        if (num1>num2) {
            a = num2;
            b = num1;
        } else {
            a = num1;
            b = num2;
        }
        if (a == 0) a=1;
        for (int i = a; i<=b; i++) {
             if(i%2==0){
                result += 1;
            }
        }
        return result;
    }
    static int findTheBug(String word) {
        int result = -1 ;
        for(int i = 0; i < word.length(); i++){
            if ("#".equals(""+word.charAt(i))) {
                result = i;
            }
        } return result;
    }
    static int countCharacter(String str, char letter) {
        int result = 0;
        if(str.equals("")) return result;
        for (int i=0; i < str.length(); i++){
            if(letter == str.charAt(i)){
                result += 1;
            }
        }
        return result;

    }
    static int getMaxNumberFromString(String str) {
        int result = 0;
        for(int i=0; i<str.length(); i++){
            int a= str.charAt(i)-'0';
            if (a>result) result= a;
        }
        return result;
    }
    static String replaceAll(String str, char from, char to) {
        //문자열과 두개의 문자 a,b를 받는다
        //문자열중 a문자를 b로 바꾼다
        //바꾼 문자열을 반환
        String result ="";
        StringBuilder sb = new StringBuilder(str);
        for (int i =0; i < sb.length(); i++){
            if (from == sb.charAt(i)){
                sb.setCharAt(i,to);
                result = sb.toString();
            }
        } return result;
    }
    static String characterAndNumber(String word) {
        // 문자열을 입력받는다
        // 각 문자 뒤에 해당 문자의 인덱스를 추가한다
        // 변경된 문자열을 출력한다.
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            result += word.charAt(i)+""+i; // int i를 형변환 해주지않으면 문자도 숫자로 출력
        }
        return result;
    }
    static int computePower(int base, int exponent) {
        // 밑과 지수를 입력받는다
        // 밑과 지수의 거듭제곱을 리턴한다.
        // 3 3 3 3 3   = 3 5
        int result = 1;
        if (base >0 && exponent == 0) return result;
        else if (base==0 && exponent>=1) return result;
        else {
            for (int i = 1; i<=exponent; i++){
                result = result * base;
            }
        }
        return result;
    }
    static int getSumOfFactors(int num) {
        // 입력 값의 약수를 구한다.
        // 약수들의
        // 반복문이 돌면서 입력받은 수를 나누어 0이 되는 숫자들의 합합
        int result = 0;
        for (int i = 1; i<=num; i++){
            if (num%i ==0) {
                result += i;

            }
        } return result;
    }
    public static boolean isPrime(int num) {
        // TODO:
        if(num == 2) return true;
        if(num<2||num%2 == 0) return false;
        int a = (int) Math.sqrt(num);
        for (int i = 3; i<a; i += 2){
            if(num%i == 0){
                return false;
            }
        } return true;
    }

    static String listPrimes(int num) {
        StringBuilder result = new StringBuilder("2");

        for (int i = 3; i<=num; i+=2){
            boolean b = true;
            int a = (int) Math.sqrt(i);
            for (int t = 3; t<=a; t += 2){ // 제곱근이 3 이하면 구문 반복 없음
                if (i % t == 0) {
                    b = false;
                    break;
                }
            }
            if (b) result.append("-").append(i);

        }
        return result.toString();


    }

    static String makePermutations(String str) {
        String result = "";
        if (str.isEmpty()) return "";
        for (int i = 0; i < str.length(); i++ ){
            for (int t= 0; t<str.length(); t++){
                result= result+str.charAt(i)+str.charAt(t)+",";
            }
        }
        return result.substring(0,result.length()-1); // 마지막 ,을 없에기 위해
    }

    static boolean hasRepeatedCharacter(String str) {

        if (str.isEmpty()){
            return false;
        }
        for (int i=0; i<str.length(); i++){
            for (int t= i+1; t<str.length(); t++){

                if (String.valueOf(str.charAt(i)).equals(String.valueOf(str.charAt(t)))){
                    return true;
                }

            }
        }
        return false;
    }
    static String makeMarginalString(String str) {
        // 문자열이 들어오면
        // 문자1 출력
        // 문자 1+ 문자2 출력
        if (str.isEmpty()) return "";
        String result="";
        for(int i=0; i<str.length(); i++){
            for(int t=0; t<= i; t++){
                result = result + str.charAt(t);
            }
        }
        return result;

    }




    public static void main(String[] args) {
        System.out.println(getMaxNumberFromString("12347534"));


    }
}

