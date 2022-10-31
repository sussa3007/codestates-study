package CodeStates.DailyQuiz;

public class DailyQuiz3 {
    public static void main(String[] args) {
        DailyQuiz3 q = new DailyQuiz3();
        System.out.println(q.tiling(4));
    }
    
    public int tiling(int num) {
        // n = (n-1) + (n-2)
        int[] arr = new int[num+1];
        return recur(num,arr);

    }
    private static int recur(int num, int[] arr) {
        if(num ==1) return 1;
        if(num ==2) return 2;
        if(arr[num]!=0) return arr[num];
        return arr[num] = recur(num - 1, arr) + recur(num - 2, arr);
    }

}

