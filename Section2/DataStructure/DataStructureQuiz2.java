package CodeStates.Section2.DataStructure;

import java.util.*;

public class DataStructureQuiz2 {


    /**
     * [
     * [0, 0, 1, 0, 0],
     * [0, 0, 0, 1, 0],
     * [0, 1, 0, 0, 1],
     * [0, 1, 0, 0, 0],
     * [0, 0, 1, 0, 0],
     * ]
     */
    public static void main(String[] args) {
        int[][] input = new int[][]
                {
                        {0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {0, 1, 0, 0, 0},
                        {0, 1, 1, 0, 0},
                        {1, 1, 1, 1, 0}
                };
        DataStructureQuiz2 a = new DataStructureQuiz2();
        System.out.println(a.findDirections(input,1,4));

        int[][] input1 =new int[][]
                {
                        {0, 1},
                        {2, 3},
                        {3, 4},
                        {3, 5}
                };

    }


    public int[][] createMatrix(int[][] edges) {
        // TODO:
        int max = 0;
        for (int[] edge : edges) {
            for (int i : edge) {
                if (i > max) max = i;
            }
        }
        int[][] graph = new int[max+1][max+1];
        for (int[] edge : edges) {
            if (!(edge[2] == 1)) graph[edge[0]][edge[1]] = 1;
            else {
                graph[edge[0]][edge[1]] = 1;
                graph[edge[1]][edge[0]] = 1;
            }
        }
        return graph;
    }
    public boolean findDirections(int[][] matrix, int from, int to) {
        int[][] compareArr = new int[matrix.length][];
        for(int i=0; i< matrix.length; i++) compareArr[i]
                =Arrays.copyOf(matrix[i],matrix[i].length);
        if (from==to) return true;
        for (int i=0; i<compareArr[from].length; i++){
            if(compareArr[from][i]==1){
                compareArr[from][i]=0;
                if(findDirections(compareArr,i,to)) return true;
            }
        }
        return false;
    }
    public boolean findDirectionsQueue(int[][] matrix, int from, int to) {
           //큐를 사용한 풀이
        //연결 리스트를 사용하여 큐를 선언합니다.
        Queue<Integer> queue = new LinkedList<>();
        //첫 시작점으로 from을 할당합니다.
        queue.add(from);

        // 방문했다는 것을 표시하기 위해 1차원 배열을 생성합니다. 초기값은 false로 생성됩니다.
        boolean[] isVisited = new boolean[matrix.length];
        // 첫 정점 방문 여부를 표시합니다.
        isVisited[from] = true;

        // queue(방문할 곳)의 사이즈가 0이 될 때까지 반복합니다.
        while (queue.size() > 0) {

            // queue에서 정점을 하나 빼서 now에 할당합니다.
            int now = queue.poll();

            // 목적지인지 검사하고, 목적지라면 true를 반환합니다.
            if (now == to) return true;

            // 해당 정점의 간선들을 확인합니다.
            for (int next = 0; next < matrix[now].length; next++) {
                // 만약, 간선이 있고 방문하지 않았다면
                if (matrix[now][next] == 1 && !isVisited[next]) {
                    // queue에 next를 넣습니다. (다음 정점으로 가기 위해)
                    queue.add(next);
                    // 해당 정점을 방문했다는 것을 표시합니다.
                    isVisited[next] = true;
                }
            }
        }
        // 길이 없다면 false를 반환합니다.
        return false;
    }



    private int max=0;
    private int [][] adj;
    private int [] collect;
    private int value = 0;
    private int count = 0; // 컴포넌트 갯수 카운트

    public int countComponent(int[][] edges) {

        for (int[] edge : edges) {
            if (edge[0] > max) {
                max = edge[0];
            }
            if (edge[1] > max) {
                max = edge[1];
            }
        }
        adj = new int[max+1][max+1];
        collect = new int[max+1];
        for (int[] ints : adj) { // 행렬과 배열에 모든 값을 0으로 초기화
            Arrays.fill(collect,0);
            Arrays.fill(ints, 0);
        }
        for (int[] i : edges) { // 인자로 받은 간선 목록을 가지고 행렬에 추가
            adj[i[0]][i[1]] = 1;
            adj[i[1]][i[0]] = 1;
        }
        findComponent(); // 컴포넌트 갯수 카운터 호출
        return count;

    }
    // 행렬을 받아 두 정점이 이어져 있는지 확인
    private boolean isLinked(int[][] adj,int from, int to){
        return adj[from][to]==1&&adj[to][from]==1;
    }
    // DFS 순회
    private void dfsRecur(int v){
        /* vertex 만큼의 길이를 가진 배열을
        *  하나하나 방문할때 체크 하며 count와 동일한 value를 배열에 넣어준다*/
        collect[v] = value;
        // vertex 갯수 만큼 순회
        for(int i=0; i<collect.length; i++){
            // 두 정점이 이어져있고, vertex에 방문한적이 없다면 재귀 호출
            // 정점이 이어져있지 않다면, 다음 요소 까지 재귀호출을 하지 않는다.
            // 재귀 호출을 하지 않았다는건, i의 해당 요소가 매개 변수에 해당하는 vertex와 연결되어 있지 않았거나,
            // i에 해당하는 vertex에 방문한적이 있다는 뜻.
            if(isLinked(adj,v,i)&&collect[i]==0){
                dfsRecur(i);
            }
        }

    }
    private void findComponent(){
        count = 0;
        Arrays.fill(collect,0); // 배열 초기화

        for(int i =0; i<collect.length; i++){
            // 해당 vertex에 방문한적이 없다면
            if(collect[i]==0){
                value++;
                dfsRecur(i);
                count++;
            }
        }
        for(int i=1; i<=value; i++){
            System.out.print(i+" : ");
            for(int t = 0; t<max+1; t++){
                if(collect[t]==i){
                    System.out.print(t+" ");
                }
            }
            System.out.println();
        }
    }


}

