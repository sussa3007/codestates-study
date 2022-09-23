package CodeStates.Section2.DailyQuiz;

import java.util.HashMap;

public class DailyQuiz {
    public static void main(String[] args) {
//        System.out.println(powerOfTwo(16));
//        System.out.println(firstCharacter("Abcd Cdef Good job hello"));

    }
    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        // TODO: arr[0] = key , arr[arrlength-1] = value
        if(arr.length==0)return null;
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put(arr[0],arr[arr.length-1]);
        return hashMap;
    }
    public int computeWhenDouble(double interestRate) {
        // TODO:연이율을 입력받아 원금이 2배 이상이 될 때까지 걸리는 시간(년)을 리턴해야 합니다
        double value = 100;
        // 시작은 100으로 목표는 200이상
        int count = 0;
        // 루프 순회 카운트
        while(true){
            // 원금의 2배가 될때까지 루프
            if(value>=100&&value<200){
                value +=(value*(interestRate/100));
            }else if(value>=200) break;
            count++;
        }
        return count;
    }
    public static boolean powerOfTwo(long num) {
        // TODO: 2의 거듭제곱 여부
        long x = 2;
        // 2의 0승은 1이라는 가정
        if (num==1) return true;
        // 2의 배수가 아닐 경우 제외
        else if (num %2!=0) return false;
        while (x <num){
            x=x*2;
        }
        return x == num;
    }
    public String firstCharacter(String str) {
        // TODO:
        if(str.isEmpty()) return "";
        String[] arr = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : arr) result.append(s.charAt(0));
        return result.toString();
    }


}
