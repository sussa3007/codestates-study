package CodeStates.Section2.RecursiveFunction;

import java.util.Arrays;

public class RecursiveFunction {
    public static void main(String[] args) {
        System.out.println("30 th fibonacci Memo: "+fibonacciMemo(30));
        System.out.println("fibonacci Memo : "+ countFibMemo);
        System.out.println("30 th fibonacci Tail : "+fibonacciTail(30,0,1));
        System.out.println("fibonacci Tail : "+ countFibTail);
        System.out.println("30 th fibonacci : "+fibonacci(30));
        System.out.println("fibonacci : "+ countFib);

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
    private static int countFibTail =0;
    private static int countFib =0;
    private static int countFactTail =0;
    private static int countFact =0;
    private static int countFibMemo =0;
    private static int[] val = new int[100];
    public static int fibonacci(int number) {
        countFib++;
        if(number <=1) return number;
        else return fibonacci(number-2)+ fibonacci(number-1);
    }
    public static int fibonacciMemo(int number) {
        countFibMemo++;
        if(number == 1) return 1;
        if(number == 2) return 1;
        if(val[number] != 0) return val[number];
        else return val[number] = (fibonacciMemo(number-2)+ fibonacciMemo(number-1));
    }
    public static int fibonacciTail(int input, int before, int after) {
        countFibTail++;
        if(input <=1) return after;
        else return fibonacciTail(input-1,after,before+after);
    }
    public static long factorialTail(long n, long acc){
        countFactTail++;
        if(n == 1) return acc;
        return factorialTail(n - 1, acc * n);
    }
    public static long factorial(long num){ // 재귀 함수
        countFact++;
        if(num == 1)return 1;
            // num의 값이 1일때도 예상하기 쉬운 케이스 이므로 1을 반환한다.
        else return num*factorial(num-1);
    }


//     5! = 5*4*4*3*1 = 120
//    public static int factorialFor(int num){ // 반복함수
//        int sum = 1;
//        for(int i = 2; i<=num; i++){
//            sum*=i;
//        }
//        return sum;
//    }
//
//    public static int factorial(int num){ // 재귀 함수
//        if(num == 1)return 1;
//        // num의 값이 1일때도 예상하기 쉬운 케이스 이므로 1을 반환한다.
//        else return num*factorialRecursion(num-1);
//    }

//    public static int fibonacci(int number){
//        int one = 1;
//        int two = 1;
//        int result = -1;
//        if(number==1) return one;
//        else if (number==2) return two;
//        else {
//            for(int i=2; i<=number; i++){
//                result = one+two;
//                one= two;
//                two=result;
//            }
//        }
//        return result;
//    }
}















