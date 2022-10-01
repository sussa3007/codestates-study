package CodeStates.Section2.DailyQuiz;

import java.util.*;

public class DailyQuiz {

    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        if(arr.length==0)return null;
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put(arr[0],arr[arr.length-1]);
        return hashMap;
    }
    public int computeWhenDouble(double interestRate) {
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
        String[] arr = str.split(" +");
        StringBuilder result = new StringBuilder();
        for (String s : arr) result.append(s.charAt(0));
        return result.toString();
    }
    public String firstReverse(String str) {
        // TODO:
        if(str.isEmpty()) return "";
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public String letterCapitalize(String str) {
        if(str.isEmpty()) return "";
        StringBuilder chStr = new StringBuilder();
        String[] strArr = str.split(" ");
        System.out.println(Arrays.toString(strArr));
        for (int t=0; t<strArr.length; t++){
            if(strArr[t].equals("")) {
                chStr.append(" ");
                continue;
            }
            chStr.append(String.valueOf(strArr[t].charAt(0)).toUpperCase());
            for(int i=1; i<strArr[t].length(); i++){
                chStr.append(strArr[t].charAt(i));
            }
            if (t!= (strArr.length-1)){
                chStr.append(" ");
            }
        }
        return chStr.toString();
    }
    public HashMap<String, String> convertListToHashMap(String[][] arr) {
        if(arr.length==0) return new HashMap<>();
        HashMap<String,String> hashMap = new HashMap<>();
        for (String[] s : arr) {
            if(s.length != 0){
                if (hashMap.containsKey(s[0])) continue;
                hashMap.put(s[0], s[1]);
            }
        }
        return hashMap;
    }
    public String convertDoubleSpaceToSingle(String str) {
        return str.replaceAll("  "," ");
    }
    public boolean ABCheck(String str) {
        String[] arr = str.split("");
        int length = arr.length;
        for(int i=0; i<length; i++){
            if(arr[i].equalsIgnoreCase("a")&&(i+4)<length
                    &&arr[i+4].equalsIgnoreCase("b")){
                    return true;
            }else if(arr[i].equalsIgnoreCase("b")&&(i+4)<length
                    &&arr[i+4].equalsIgnoreCase("a")){
                    return true;
            }
        }
        return false;
    }
    public String insertDash(String str) {
        if(str.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i-1)%2!=0&&str.charAt(i)%2!=0){
                sb.append("-").append(str.charAt(i));
            }else sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public String[] removeExtremes(String[] arr) {
        // TODO:
        if(arr==null||arr.length==0) return null;
        String maxStr=arr[0];
        String minStr=arr[0];
        LinkedList<String> strList = new LinkedList<>();
        for (String s : arr) {
            if (s==null||s.isEmpty()) return null;
            if (s.length() >= maxStr.length()) maxStr = s;
            if (s.length() <= minStr.length()) minStr = s;
            strList.add(s);
        }
        strList.remove(maxStr);
        strList.remove(minStr);
        if(!strList.isEmpty()){
            return Arrays.copyOf(strList.toArray(), strList.toArray().length,String[].class);
        }else return new String[]{};
    }

    public int[] reverseArr(int[] arr){
        if(arr.length==0) return new int[]{};
        int[] cyclePre = Arrays.copyOfRange(arr,arr.length-1,arr.length);
        int[] cycleLast =  reverseArr(Arrays.copyOfRange(arr,0,arr.length-1));
        int[] combineArr = new int[cyclePre.length+cycleLast.length];
        System.arraycopy(cyclePre,0,combineArr,0,cyclePre.length);
        System.arraycopy(cycleLast,0,combineArr,cyclePre.length,cycleLast.length);
        return combineArr;
    }
    public static void main(String[] args) {

        DailyQuiz d = new DailyQuiz();
//        {"a", "c", "the",null}
        String [] result = new String []{"a", "c", "the","aaa"};
        System.out.println(Arrays.toString(d.removeExtremes(result)));


    }


}



























