package CodeStates.Section2.Algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationQuiz {


    // 가위 바위 보 라운드 당 경우의 수
    public ArrayList<String[]> rockPaperScissors(int rounds) {
        String[] rpsArr = new String[]{"rock", "paper", "scissors"};
        String[] roundCase = new String[rounds];
        ArrayList<String[]> result = new ArrayList<>();
        result = currentPlay(rounds, rounds, result, rpsArr, roundCase);
        return result;

    }

    public ArrayList<String[]> currentPlay
            (int finalRounds, int rounds, ArrayList<String[]> result, String[] rpsArr, String[] roundCase) {
        if (rounds == 0) {
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

    public int boringBlackjack1(int[] cards) {
        // 재귀로 풀이 permutationStudy파일에 있음
        int count = 0;
        int len = cards.length;// cards = { 2, 3, 4, 8, 13 } //3 // 2 3 4
        for (int i = 0; i < len; i++) { // I =1

            for (int j = i + 1; j < len; j++) {  // i =0 j =2

                for (int k = j + 1; k < len; k++) { // i 0 j 1 k=3
                    int number = cards[0] + cards[1] + cards[2]; //2 3 4
                    if(isPrime(number)) count++;
                }
            }
        }
        return count;
    }
    public boolean isPrime(int number) {
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }

    // 소수 여부 반환 37 6.08276


    //치킨 레시피 문제
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // TODO:
        // 요소들을 문자열로 바꿔 0을 3개이상 포함하고 있는지 확인하고 제거
        // 제거를 용이하기 위해 리스트로 변환 해서 사용
        // 순열 메소드로 넘긴다.
        // 1. stuffArr을 리스트로 변환
        // 1. 0이 3개 이상 포함하고 있는지 제어
        // 2. 0이 3개 이상 포함하고 있는 요소 제거
        // 3. 제거된 리스트가 choiceNum 보다 작으면 null
        // 4. result를 반환해준다.
        // 3. 재귀호출의 인자 - finalChoiceNum, choiceNum, result, stuffList, choiceCase
        // 4. 재귀 호출 내부- for문 내부에서 cycleArr 요소에 중복값이 없어야된다.
        // 5. 종료 조건은 - choiceNum== 0 일때 result에 choiceCase를 추가.
        // 6. 반복 하면서 재귀 복귀를 하면 순열 완성.
        ArrayList<Integer[]> result = new ArrayList<>();
        Integer[] choiceCase = new Integer[choiceNum];
        List<Integer> stuffList = Arrays.stream(stuffArr).boxed().sorted().collect(Collectors.toList());
        for (int i = stuffList.size() - 1; i >= 0; i--) {
            String compStr = String.valueOf(stuffList.get(i));
            String comp = "";
            for (int t = 0; t < compStr.length(); t++) {
                if (compStr.charAt(t) == '0') {
                    comp = comp + "0";
                }
            }
            if (comp.length() >= 3) stuffList.remove(stuffList.get(i));
        }
        if (stuffList.isEmpty() || stuffList.size() < choiceNum) return null;
        return caseRecipe(choiceNum, choiceNum, result, stuffList, choiceCase);
    }

    private ArrayList<Integer[]> caseRecipe
            (int finalChoiceNum, int choiceNum, ArrayList<Integer[]> result, List<Integer> stuffList, Integer[] choiceCase) {
        if (choiceNum == 0) {
            result.add(choiceCase);
            return result;
        }
        for (Integer s : stuffList) {
            // 배열 choiceCase 요소중에 s가 하나라도 있으면 안된다.
            if (Arrays.stream(choiceCase).noneMatch(i -> Objects.equals(i, s))) {
                choiceCase[finalChoiceNum - choiceNum] = s;
                Integer[] cycleArr = choiceCase.clone();
                result = caseRecipe(finalChoiceNum, choiceNum - 1, result, stuffList, cycleArr);
            }
        }
        return result;
    }

    // 뺴빼로문제
    public ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        // TODO:
        // 최대 공약수는 유클리드 호제법을 이용하여 구한다.
        // 최대 공약수는 빼빼로를 나누어 줄수 있는 직원의 수다.
        // 최대 공약수의 약수로 M,N나누게 되면 나머지가 0 이된다.
        // 1. ArrayList<Integer[]> 타입의 리스트 caseGcd를 만들어
        // 1. M,N의 최대 공약수의 약수를 구하며
        // 1. 약수라면, 동시에  caseGcd에 0- 요소 / 1- M/요소 /  2- N/요소를 가진 배열을 넣어준다.
        int gcd = findGCD(M, N);
        ArrayList<Integer[]> caseGcd = new ArrayList<>();
        // 시간 복잡도 O(n)
        for (int i = 1; i <= gcd; i++) {
            if (gcd % i == 0) caseGcd.add(new Integer[]{i, M / i, N / i});
        }
        return caseGcd;
    }

    private int findGCD(int M, int N) {
        // 최대공약수 - 재귀함수 사용
        // 시간 복잡도 O(log n)
        if (M % N == 0) return N;
        return findGCD(N, M % N);
    }


    public ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        //search 함수에서 사용할 빈 스택을 선언합니다.
        Stack<String> stack = new Stack<>();

        //결과를 담을 ArrayList를 선언합니다.
        ArrayList<String[]> result = new ArrayList<>();

        //재료들을 오름차순으로 정렬합니다.
        Arrays.sort(sideDishes);

        // 빈 스택과 0 번째 인덱스, 정렬된 재료로 구성된 배열, 결과를 담을 List를 인자로 받는 재귀 함수를 실행합니다.
        result = search(stack, 0, sideDishes, result);

        // 결과를 오름차순 순서로 정렬합니다.
        result.sort(Comparator.comparing(Arrays::toString));
        //결과를 반환합니다.
        return result;
    }

    // 모든 조합을 검사하는 재귀 함수를 작성합니다.
    public ArrayList<String[]> search
    (Stack<String> stack, int idx, String[] sideDishes, ArrayList<String[]> result) {
        // 재귀 함수이기 때문에 탈출 조건을 만듭니다.
        if (idx >= sideDishes.length) {
            // 만약, idx와 sideDishes의 길이가 같거나 크다면(마지막까지 검토한 경우) 스택을 배열로 변환한 후, 해당 스택을 result에 넣어줍니다.
            String[] arr = stack.toArray(new String[0]);
            result.add(arr);
            return result;
        } else {
            // idx가 부분집합에 포함된 경우
            stack.push(sideDishes[idx]);
            search(stack, idx + 1, sideDishes, result);

            // idx가 부분집합에 포함되지 않은 경우
            stack.pop();
            search(stack, idx + 1, sideDishes, result);
        }
        return result;
    }


    public static void main(String[] args) {
        PermutationQuiz q = new PermutationQuiz();
        q.boringBlackjack1(new int[]{2, 3, 4, 8, 13});


    }


}
