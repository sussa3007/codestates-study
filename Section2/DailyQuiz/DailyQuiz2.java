package CodeStates.Section2.DailyQuiz;

import java.util.Arrays;

public class DailyQuiz2 {
    public static void main(String[] args) {
        String str = "ABC";
        int num = 12;
        System.out.println("ABC "+str+"12 "+12+" " +num );
        System.out.printf("%d 숫자 %s 문자열 \n",num,str);
        System.out.print(str + num + "\n");
        System.out.println("끝");
        int[] arr =new int[6];
        for (int i=0; i< arr.length; i++){
            arr[i] = (int) (Math.random()*45)+1;// 0.000001~0.9999999
        }
        System.out.println(Arrays.toString(arr));


    }
    public String readVertically(String[] arr) {
        StringBuilder sb = new StringBuilder();
        int max =0;
        for(String s : arr){
            if(s.length()>max){
                max= s.length();
            }
        }
        for(int i=0; i<max; i++){
            for(String s : arr){
                if(s.length()>i) sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public boolean superIncreasing(int[] arr) {
        // TODO:
        if(arr.length==0) return false;
        int sum =0;
        for(int i=1; i<arr.length; i++ ){
            sum += arr[i-1];
            if (sum >= arr[i]) return false;
        }
        return true;
    }
    public Integer modulo(int num1, int num2) {
        if(num2==0) return null;
        while(num1>num2){
            num1-=num2;
        }
        return num1;
    }
    public boolean isIsogram(String str) {
        if(str.isEmpty()) return true;
        String comp = str.toLowerCase();
        for(int i=0; i<comp.length(); i++){
            for(int t=i+1; t<comp.length(); t++){
                if(comp.charAt(i)==comp.charAt(t)) return false;
            }
        }
        return true;
    }
}
