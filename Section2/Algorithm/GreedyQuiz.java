package CodeStates.Section2.Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class GreedyQuiz {
    public static void main(String[] args) {
        GreedyQuiz a = new GreedyQuiz();
//        System.out.println(
//                a.movingStuff(new int[]{
//                        70, 50, 80, 50
//                }, 100));
        int[][] board1 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}

        };
        System.out.println(a.boardGame(board1,"UUUDD"));
    }
    public int movingStuff(int[] stuff, int limit) {
        int countBox = 0;
        Integer val;
        List<Integer> arr;
        arr = Arrays.stream(stuff).boxed().sorted().collect(Collectors.toList());
        int index = arr.size()-1;
        while (index>0){
            if(arr.get(index)<=limit){
                val = arr.get(index);
                arr.remove(index);
                findSpace(limit, val, arr);
            }
            System.out.println(arr);
            index=arr.size()-1;
            countBox++;
        }
        return countBox;

    }

    private void findSpace(int limit, Integer val, List<Integer> arr) {
        int boxMax =0;
        if(val<=limit){
            Integer finalVal = limit-val;
            boxMax = arr.stream().filter(i-> i <= finalVal).max(Integer::compareTo).orElse(-1);
            if(boxMax!=-1){
                int t= arr.indexOf(boxMax);
                arr.remove(t);
            }
        }
    }
//    public int movingStuff(int[] stuff, int limit) {
//        int twoStuff = 0;
//        // 짐을 무게순으로 오름차순 정렬
//        Arrays.sort(stuff);
//        // 가장 가벼운 짐의 인덱스
//        int leftIdx = 0;
//        // 가장 무거운 짐의 인덱스
//        int rightIdx = stuff.length - 1;
//        while(leftIdx < rightIdx) {
//            // 가장 가벼운 짐과 무거운 짐의 합이 limit 보다 작거나 같으면 2개를 한번에 나를 수 있다
//            if(stuff[leftIdx] + stuff[rightIdx] <= limit) {
//                // 다음 짐을 확인하기 위해 가장 가벼운 짐과 무거운 짐을 가리키는 인덱스를 옮겨주고
//                // 한번에 2개 옮길 수 있는 개수를 +1 해준다
//                leftIdx++;
//                rightIdx--;
//                twoStuff++;
//            } else {
//                // 위 조건에 맞지 않는 경우는 한번에 한 개만 나를 수 있는 경우이기 때문에
//                // 가장 무거운 짐의 인덱스만 옮겨준다
//                rightIdx--;
//            }
//        }
//        // 전체 짐의 개수에서 한번에 2개를 나를 수 있는 경우를 빼 주면 총 필요한 박스의 개수를 구할 수 있다
//        return stuff.length - twoStuff;
//    }
    public int partTimeJob(int k) {
        int [] coin = new int[]{500,100,50,10,5,1};
        if(k%coin[0]==0) return k/coin[0];
        int change = k;
        int coinCount =0;
        for (int j : coin) {
            if (change % j == 0) return coinCount + change / j;
            else {
                coinCount = coinCount + change / j;
                change = change % j;
            }
        }
        return coinCount;
    }

/*    N * N의 크기를 가진 보드판 위에서 게임을 하려고 합니다. 게임의 룰은 다음과 같습니다.

    1. 좌표 왼쪽 상단(0, 0)에 말을 놓는다.
    2. 말은 상, 하, 좌, 우로 이동할 수 있고, 플레이어가 조작할 수 있다.
    3. 조작의 기회는 딱 한 번 주어진다.
    4. 조작할 때 U, D, L, R은 각각 상, 하, 좌, 우를 의미하며 한 줄에 띄어쓰기 없이 써야 한다.
        예시: UDDLLRRDRR, RRRRR
    5. 한 번 움직일 때마다 한 칸씩 움직이게 되며, 그 칸 안의 요소인 숫자를 획득할 수 있다.
    6. 방문한 곳을 또 방문해도 숫자를 획득할 수 있다.
    7. 보드 밖을 나간 말은 OUT 처리가 된다.
    8. 칸 안의 숫자는 0 또는 1이다.
            단, 좌표 왼쪽 상단(0, 0)은 항상 0이다.
    9. 획득한 숫자를 합산하여 숫자가 제일 큰 사람이 이기게 된다.
    보드판이 담긴 board와 조작하려고 하는 문자열 operation이 주어질 때,
    말이 해당 칸을 지나가면서 획득한 숫자의 합을 구하는 함수를 작성하세요.*/

    public Integer boardGame(int[][] board, String operation) {
        // TODO:
        // board[0][0] 부터 시작한다.
        // U,D,L,R이 무작위로 있는 String이 매개 변수로 들어온다.
        // 이 인자를 하나씩 나누어 배열에 담는다.
        // 각 요소를 조건문에 붙여주면서,
        // U는 board[x+1][y]
        // D는 board[x-1][y]
        // L는 board[x][y-1]
        // R는 board[x][y+1] 만큼의 인덱스 값을 준다.
        // 이동 한 곳의 값이 있다면 요소를 count에 넣어준다.
        // 방문 한 곳을 다시 방문해도 count에 요소 값을 넣어준다.
        // x,y 의 값이 index값을 벗어난다면, 프로그램 종료
        String[] arr = operation.split("");
        System.out.println(Arrays.toString(arr));
        int x=0;
        int y=0;
        int count =0;
        for (String s : arr){
            if(s.equals("U")){
                x -=1;
                if(!(x >= board.length)&&!(x<0)){
                    count+=board[x][y];
                } else return null;
            }else if(s.equals("D")){
                x +=1;
                if(!(x >= board.length)){
                    count+=board[x][y];
                } else return null;
            }else if(s.equals("L")){
                y -=1;
                if(!(y >= board.length)&&!(y<0)){
                    count+=board[x][y];
                } else return null;
            }else if(s.equals("R")){
                y +=1;
                if(!(y >= board.length)){
                    count+=board[x][y];
                } else return null;
            }
        }
        return count;
    }
    public int ocean(int target, int[] type) {
        int change = target;
        int coinCount =0;
        for (int j : type) {
            if (change % j == 0) return coinCount + change / j;
            else {
                coinCount = coinCount + change / j;
                change = change % j;
            }
        }
        return coinCount;
    }
}
