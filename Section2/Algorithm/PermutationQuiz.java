package CodeStates.Section2.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PermutationQuiz {
    public static void main(String[] args) {
        PermutationQuiz q = new PermutationQuiz();
//        ArrayList<String[]> output = q.rockPaperScissors(5);
//        for(String[] arr : output) System.out.println(Arrays.toString(arr));
//        System.out.println(q.boringBlackjack(new int[]{3, 5, 7, 11, 19, 22, 27, 29, 33, 39, 41, 49}));
        ArrayList<Integer[]> newChickenRecipeq =
                q.newChickenRecipe(new int[]{11, 1, 10, 1111111111, 10000}, 4);
        for (Integer[] integers : newChickenRecipeq) {
            System.out.println(Arrays.toString(integers));
        }

    }

    // 가위 바위 보 라운드 당 경우의 수
    public ArrayList<String[]> rockPaperScissors(int rounds) {
        String[] rpsArr = new String[]{"rock", "paper", "scissors"};
        String[] roundCase = new String[rounds];
        ArrayList<String[]> result = new ArrayList<>();
        result =currentPlay(rounds,rounds,result,rpsArr,roundCase);
        return result;

    }
    public ArrayList<String[]> currentPlay
            (int finalRounds,int rounds,ArrayList<String[]> result,String[] rpsArr,String[] roundCase)
    {
        if(rounds ==0){
            result.add(roundCase);
            return result;
        }
        for (String s : rpsArr) {
            roundCase[finalRounds - rounds] = s;
            String[] cycleArr = roundCase.clone();
            result = currentPlay(finalRounds, rounds - 1, result, rpsArr, cycleArr);
        }
        return result;
    }


    // 카드들의 3개의 합으로 소수의 갯수
    public int boringBlackjack(int[] cards) { // 실패
        int countPrime = 0;
        int[] sumCase = new int[3];
        List<Integer> result = new ArrayList<>();
        result = sumElement(3,3,result,cards,sumCase);
        for(Integer number : result) {
            if(primeCount(number)) countPrime++;
        }
        return countPrime;
    }
    public int boringBlackjack1(int[] cards) {
        int count = 0;
        int l = cards.length;
        for(int i = 0; i < l; i++) {
            for(int j = i + 1; j < l; j++) {
                for(int k = j + 1; k < l; k++) {
                    int number = cards[i] + cards[j] + cards[k];
                    if(primeCount(number)) count++;
                }
            }
        }
        return count;
    }
    public List<Integer> sumElement // 실패
            (int finalRounds,int peek,List<Integer> result,int[] cards,int[] sumCase)
    {
        if(peek ==0){
            result.add(Arrays.stream(sumCase).sum());
            return result;
        }
        for (Integer s : cards) {
            if(Arrays.stream(sumCase).filter(i->i==s).count() <1){
                sumCase[finalRounds - peek] = s;
                int[] cycleArr = sumCase.clone();
                result = sumElement(finalRounds, peek - 1, result, cards, cycleArr);
            }
        }
        return result.stream().sorted().distinct().collect(Collectors.toList());
    }

    // 소수 여부 반환
    public static boolean primeCount(Integer number) {
        if (number%2==0) return false;
        for(int i = 3; i <number; i+=2) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
//치킨 레시피 문제
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        String comp = "";
        Integer[] choiceCase = new Integer[choiceNum];
        List<Integer> arr = Arrays.stream(stuffArr).boxed().sorted().collect(Collectors.toList());
        for(int x =0; x<arr.size(); x++){
            String t = String.valueOf(arr.get(x));
            comp ="";
            for (int i = 0; i < t.length(); i++) {
                if(t.charAt(i)=='0'){
                    comp =comp +"0";
                }
            }
            if(comp.length()>=3) arr.remove(arr.get(x));
        }
        if(arr.isEmpty()||arr.size()<choiceNum) return null;
        return findRecipe(choiceNum,choiceNum,new ArrayList<>(),arr,choiceCase);
    }
    public ArrayList<Integer[]> findRecipe
            (int finalRounds,int peek,ArrayList<Integer[]> result,List<Integer> arr,Integer[] choiceCase)
    {
        if(peek ==0){
            result.add(choiceCase);
            return result;
        }
        for (Integer s : arr) {
            if (Arrays.stream(choiceCase).noneMatch(i -> Objects.equals(i, s))) {
                choiceCase[finalRounds - peek] = s;
                Integer[] cycleArr = choiceCase.clone();
                result = findRecipe(finalRounds, peek - 1, result, arr, cycleArr);
            }
        }
        return result;
    }



}
