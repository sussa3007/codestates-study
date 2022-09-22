package CodeStates.Section2.RecursiveFunction;

import java.util.Arrays;

public class RecursiveFunction {
    public static void main(String[] args) {
        boolean[] arr = new boolean[]{false, false, false,false,false};
        System.out.println(sumTo(10));
    }
    public static int sumTo(int num){
        //TODO..
        if(num==0) return 0;
        else if(num==1) return 1;
        else return num+sumTo(num-1);
    }
    public static boolean isOdd(int num) {
        if(num==0) return false;
        else if (num==1) return true;
        else return num<0 ? isOdd(2-num) : isOdd(num-2);


    }
    public static int arrSum(int[] arr){
        int x = 0;
        if(arr.length==0) return 0;
        else if (arr.length==1) return x+arr[0];
        else return arr[arr.length-1]+arrSum(Arrays.copyOfRange(arr,0,arr.length-1));
    }
    public static int arrProduct(int[] arr){
        int x = 1;
        if(arr.length==0) return 1;
        else if (arr.length==1) return x*arr[0];
        else return arr[arr.length-1]*arrProduct(Arrays.copyOfRange(arr,0,arr.length-1));
    }
    public static int arrLength(int[] arr){
        if(arr.length==0) return 0;
        else if (arr.length==1) return arr.length;
        else return arrLength(Arrays.copyOfRange(arr,1,arr.length))+1;
    }
    public static int[] drop(int num, int[] arr){
        // TODO:
        if(arr.length == 0||num==0) return arr;
        else if (arr.length<num)  num = arr.length;
        return drop(num-1,Arrays.copyOfRange(arr,1,arr.length));

    }
    public static int[] take(int num, int[] arr){
        // TODO:
        if(arr.length==0||num==0) return new int[]{};
        int[] arrA =new int[] {arr[0]};
        int[] arrB =take(num - 1, Arrays.copyOfRange(arr, 1, arr.length));
        int[] result = new int[1+arrB.length];
        System.arraycopy(arrA, 0, result, 0, 1);
        System.arraycopy(arrB, 0, result, 1, arrB.length);

        return result;

    }
    public static boolean and(boolean[] arr){
        // TODO:
        if(arr.length==0) return true;
        else if (arr.length==1) return arr[0];
        else return arr[arr.length-1]&&and(Arrays.copyOfRange(arr,0,arr.length-1));
    }
    public static boolean or(boolean[] arr){
        // TODO:
        if(arr.length==0) return false;
        // 제일 최소 배열로 들어갔다 나올때 true가 하나라도 있다면 true로 반환하여 끝남.
        else return arr[0] || or(Arrays.copyOfRange(arr, 1, arr.length));
    }
    public int[] reverseArr(int[] arr){
        // TODO:
        if(arr.length==0) return arr;
        int[] arrA = new int[]{arr[arr.length-1]};
        int[] arrB = reverseArr(Arrays.copyOfRange(arr,0,arr.length-1));
        int[] result = new int[1+arrB.length];
        System.arraycopy(arrA,0,result,0,1);
        System.arraycopy(arrB,0,result,1,arrB.length);
        return result;
    }
}















