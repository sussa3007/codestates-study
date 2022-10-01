package CodeStates.Section2.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PermutationStudy {
    public static void main(String[] args) {
        PermutationStudy a = new PermutationStudy();
        ArrayList<String[]> result = new ArrayList<>();
        String[] choiceCase = new String[]{"A", "B", "C", "D", "E"};
        int finalChoiceCount = 3;
        int choiceCount = 3;
        String[] countCase = new String[finalChoiceCount];
        a.permutationOverlap(finalChoiceCount,choiceCount,result,choiceCase,countCase);
        a.pernutationNoneOverlap(finalChoiceCount,choiceCount,result,choiceCase,countCase);
        a.combination(finalChoiceCount,choiceCount,result,choiceCase,countCase);
    }
//    public boolean isPrime(int number) {
//        for(int i = 2; i <= Math.sqrt(number); i++) {
//            if(number % i == 0) return false;
//        }
//        return true;
//    }
//    public int boringBlackjack(int[] cards) {
//        int count =0;
//        Integer[] countCase = new Integer[3];
//
//        ArrayList<Integer[]> result = new ArrayList<>();
//        result = combination(countCase.length, countCase.length, result, cards, countCase);
//        int[] resultInt = new int[result.size()];
//        for (int i=0; i<result.size(); i++) {
//            Arrays.sort(result.get(i));
//            resultInt[i] =Arrays.stream(result.get(i)).mapToInt(Integer::valueOf).sum();
//        }
//        for (int i : resultInt) {
//            if(isPrime(i)){
//                count++;
//            }
//        }
//        return count;
//    }

//    public ArrayList<String[]> findPermutation(String[] choiceCase,int choiceCount) {
//        String[] countCase = new String[choiceCount];
//        ArrayList<String[]> result = new ArrayList<>();
//        result = permutationOverlap(choiceCount, choiceCount, result, choiceCase, countCase);
//        return result;
//    }

    public ArrayList<String[]> permutationOverlap
            (int finalChoiceCount, int choiceCount, ArrayList<String[]> result, String[] choiceCase, String[] countCase) {
        // 선택지를 가지고 선택할수 있는 모든 경우의 수
        if (choiceCount == 0) {
            result.add(countCase);
            return result;
        }
        for (String s : choiceCase) {
            countCase[finalChoiceCount - choiceCount] = s;
            String[] cycleArr = countCase.clone();
            result = permutationOverlap
                    (finalChoiceCount, choiceCount - 1, result, choiceCase, cycleArr);
        }
        return result;
    }

    private ArrayList<String[]> pernutationNoneOverlap
            (int finalChoiceCount, int choiceCount, ArrayList<String[]> result, String[] choiceCase, String[] countCase) {
        // 순서가 다르면 다른 요소로 취급할때 ex) {a,b,c} != {b,c,a}
        // 하나의 선택 경우에서 선택할 인자가 중복이 불가능하다.
        if (choiceCount == 0) {
            result.add(countCase);
            return result;
        }
        for (String s : choiceCase) {
            // 배열 countCase 요소중에 s가 있다면 재귀 호출 하지 않음
            if (Arrays.stream(countCase).noneMatch(i -> Objects.equals(i, s))) {
                countCase[finalChoiceCount - choiceCount] = s;
                String[] cycleArr = countCase.clone();
                result = pernutationNoneOverlap
                        (finalChoiceCount, choiceCount - 1, result, choiceCase, cycleArr);
            }
        }
        return result;
    }
    private ArrayList<String[]> combination
            (int finalChoiceCount, int choiceCount,ArrayList<String[]> result, String[] choiceCase, String[] countCase) {
        // 순서가 달라도 같은 요소로 취급할때 ex) {a,b,c} == {b,c,a}
        // 조합 문제 - 같은 요소는 result에 넣지않는다
        if (choiceCount == 0) {
                result.add(countCase);
                return result;
        }
        for (int i = 0; i<choiceCase.length; i++) {
            // 배열 countCase 요소중에 s가 하나라도 있으면 안된다.
            int finalI = i;
            // 배열 countCase 요소중에 s가 하나라도 있으면 안된다.
            if (Arrays.stream(countCase).noneMatch(t -> Objects.equals(t, choiceCase[finalI]))) {
                countCase[finalChoiceCount - choiceCount] = choiceCase[i];
                // 다음 재귀에서 이미 삽입한 요소를 빼고 호출
                String[] cycleCase = Arrays.copyOfRange(choiceCase,i,choiceCase.length);
                String[] cycleArr = countCase.clone();
                result = combination
                        (finalChoiceCount, choiceCount - 1, result, cycleCase, cycleArr);
            }
        }
        return result;
    }
}
