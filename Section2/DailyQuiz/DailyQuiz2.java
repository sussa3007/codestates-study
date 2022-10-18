package CodeStates.Section2.DailyQuiz;

import java.util.Arrays;
import java.util.Collections;

public class DailyQuiz2 {
    public static void main(String[] args) {
        DailyQuiz2 q = new DailyQuiz2();
        int[] a= new int[]{1,4,7,6,2,5,3};
        System.out.println(Arrays.toString(q.bubbleSort(a)));


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
    public int numberSearch(String str) {
        if(str.isEmpty()) return 0;
        String[] numStrarr = str.replaceAll("[^0-9]","").split("");
        String charStr = str.replaceAll("[^a-zA-Z]","");
        double strLength = charStr.length();
        double sum = Arrays.stream(numStrarr).mapToInt(Integer::parseInt).sum();
        return (int)Math.round(sum/strLength);
    }

    public String decryptCaesarCipher(String str, int secret) {
        if(str.isEmpty()) return "";
        char[] arr = str.toCharArray();
        char[] arrAl = new char[26];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<26; i++){
            arrAl[i] = (char) (i+97);
        }
        for(char c : arr){
            if(c ==' ') {sb.append(" "); continue;}
            for (int i=0; i< arrAl.length; i++){
                if(c==arrAl[i]){
                    if(i-secret>=0){
                        sb.append(arrAl[i-secret]);
                    } else {
                        sb.append(arrAl[26+(i-secret)]);
                    }
                    break;
                }
            }
        }
        return sb.toString();
    }

    public String compressString(String str) {
        if(str.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int count =0;
        str = str + ' ';
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i)==str.charAt(i+1)){
                count++;
                continue;
            }
            if(count>=2){
                sb.append(count+1).append(str.charAt(i));
                count = 0;
            } else if (count==1) {
                sb.append(str.charAt(i)).append(str.charAt(i));
                count=0;
            } else {
                if(str.charAt(i)!=str.charAt(i+1)) sb.append(str.charAt(i));
            }
        }
        return sb.toString().trim();
    }
    public int largestProductOfThree(int[] arr) {
        int[] comp = Arrays.stream(arr).sorted().toArray();
        int maxMulti = 0;
        int minMulti = 0;
        // 최대값 3개를 곱한값
        maxMulti = comp[comp.length - 1] * comp[comp.length - 2] * comp[comp.length - 3];
        // 음수 최소값 2개 양수 최대값 1개 곱한값
        minMulti = comp[0] * comp[1] * comp[comp.length - 1];

        return Math.max(maxMulti, minMulti);
    }

    public int[] bubbleSort(int[] arr) {
        int[] result = arr.clone();
        int count=0;
        for (int i = result.length-1; i >=0 ; i--) {
            for(int t=1; t<=i; t++){
                if(result[t-1]>result[t]){
                    swap(t-1,t,result);
                    count++;
                }
            }
            if(count == 0) break;
        }
        return result;

    }
    //int[] a= new int[]{1,4,7,6,2,5,3}
    static void swap(int a , int b, int[] arr){
        int tmp = 0;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
