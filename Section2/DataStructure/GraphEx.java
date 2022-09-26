package CodeStates.Section2.DataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class GraphEx{
    public static void main(String[] args) {
        System.out.println("========== 인접 행렬 ==========");
        GraphAdjacencyMatrix gr = new GraphAdjacencyMatrix();
        gr.setGraph(4);
        gr.setVertex("1");
        gr.setVertex("2");
        gr.setVertex("3");
        gr.setVertex("4");
        System.out.println("Vertex : "+gr.getVertex());
        gr.addEdge(0, 1);
        gr.addEdge(0, 2);
        gr.addEdge(1, 2);
        gr.addEdge(2, 3);
        gr.printMatrix();
        System.out.println("========= 인접 리스트 =========");
        GraphAdjacencyList gl2 = new GraphAdjacencyList();
        gl2.setGraph(4);
        gl2.setVertex("1");
        gl2.setVertex("2");
        gl2.setVertex("3");
        gl2.setVertex("4");
        System.out.println("Vertex : "+gl2.getVertex());
        gl2.addEdge(0, 1);
        gl2.addEdge(0, 2);
        gl2.addEdge(1, 2);
        gl2.addEdge(2, 3);
        gl2.printList();
    }
}

class GraphAdjacencyMatrix {
    // 인접 행렬
    private int[][] graph;
    ArrayList<String> arrVertex = new ArrayList<>();

    public void setGraph(int size) {
        graph = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                graph[i][j] = 0;
            }
        }
    }
    public boolean setVertex(String vertex){
        if (arrVertex.contains(vertex)) return false;
        else if(arrVertex.size()>graph.length) return false;
        else {
            arrVertex.add(vertex);
            return true;
        }
    }
    public ArrayList<String> getVertex(){
        return arrVertex;
    }
    /*printGraph
    * 1. Vertex 값을 설정하지 않았다면, graph의 1차 배열의 인덱스 값을 Vertex로 설정해주고
    * 2. Vertex 값을 먼저 출력후 graph의 2차 배열의 요소들을 차례로 출력해준다.*/
    public void printMatrix(){
        if(arrVertex.isEmpty()){
            System.out.print("  ");
            for(int i=0;i<graph.length; i++) arrVertex.add(i+"");
            System.out.println();
        }
        System.out.print("  ");
        for(String s : arrVertex) System.out.print(s+" ");
        System.out.println();

        for(int i = 0; i < graph.length; i++) {
            System.out.printf("%s ",arrVertex.get(i));
            for(int j = 0; j < graph.length; j++) {
                System.out.printf("%d ",graph[i][j]);
            }
            System.out.println();
        }
    }
    /*addEdge 무방향 그래프를 인접 행렬로 추가한다.
    * 1. 접점의 인덱스 값으로 하는 매개변수로 받는다.
    * 2. from은 진출 간선의 출발점, to는 진출 간선의 도착점이다.
    * 3. graph에 출발점과 도착점으로 하는 인덱스의 값을 1로 정의한다.
    * 4. graph에 도착점과 출발점으로 하는 인덱스의 값을 1로 정의한다.*/
    public void addEdge(int from, int to) {
        // 두개의 매개변수는 graph의 길이보다 같거나 클수 없다.
        if(from >= graph.length || to >= graph.length) return;
        graph[from][to] = 1;
        graph[to][from] = 1; // 해당 코드를 지운다면, 방향 그래프의 행렬이 구현된다.
    }

    public  boolean hasEdge(int from, int to) {
        // 두개의 매개변수는 graph의 길이보다 같거나 클수 없다.
        if(from >= graph.length || to >= graph.length) return false;
        // 무방향 그래프로 진출 간선이 존재한다면 진입 간선도 존재한다.
        else if(graph[from][to] == 1) return true;
        else return graph[to][from] == 1; // 해당 코드를 지운다면, 방향 그래프의 행렬이 구현된다.
    }

    public void removeEdge(int from, int to) {
        // 두개의 매개변수는 graph의 길이보다 같거나 클수 없다.
        if(from >= graph.length || to >= graph.length) return;
        // 무방향 그래프로 진출 간선과 진입 간선을 동시에 삭제한다.
        graph[from][to] = 0;
        graph[to][from] = 0; // 해당 코드를 지운다면, 방향 그래프의 행렬이 구현된다.
    }

}

class GraphAdjacencyList{
    private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private ArrayList<String> arrVertex = new ArrayList<>();
    private HashMap<String,ArrayList<String>> printArr = new LinkedHashMap<>();


    public GraphAdjacencyList() {
        graph = new ArrayList<>();
    }
    // 넘겨받은 size만큼 빈 ArrayList를 값으로 할당

    public void setGraph(int size){
        for(int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
    }
    public boolean setVertex (String vertex){
        if (arrVertex.contains(vertex)) return false;
        else if(arrVertex.size()>graph.size()) return false;
        else {
            arrVertex.add(vertex);
            return true;
        }
    }
    public ArrayList<String> getVertex(){
        return arrVertex;
    }
    /*인접 리스트를 출력하기위해 Vertex의 값이 있을때와 없을때로 나누었고
    * 없을때는 리스트를 이용하여 출력, 있을때는 HashMap을 이용하여 출력하였다.
    * Vertex 값이 없을떄
    * 1. graph의 vertex 값이 없다면, ArrayList의 인덱스와 동일하게 취급하여 각 값을 먼저
    *    출력해준다
    * 2. 인덱스 값을 먼저 출력한 후 각 Integer ArrayList 요소의 내부 요소를 순회하며 출력해준다
    * Vertex 값이 있을때
    * 1. 새로운 HashMap을 정의하고 key값에 Vertex 값을 삽입한다.
    * 2. 해쉬맵을 이용하여 Vertex의 인덱스에 해당하고 값에 대응하는 graph 2차원 요소를 value에 삽입한다.
    * 3. arrVertex의 인덱스와 graph 2차원 요소를 매칭하면 Vertex의 값과 동일해지며, Vertex 값을 출력하고,
    * 4. Vertex에 해당하는 리스트 요소들을 출력한다. */

    public void printList(){
        if(arrVertex.size()==0){
            for(int i =0; i<graph.size(); i++){
                ArrayList<Integer> arr = graph.get(i);
                System.out.printf("%d :", i);
                for (int t=0; t<arr.size(); t++){
                    System.out.printf(" %d",arr.get(t));
                }
                System.out.println();
            }
        }
        else {
            for (String vertex : arrVertex)
                printArr.put(vertex, new ArrayList<>());
            for (int i =0; i<graph.size(); i++){
                for(int t =0; t<graph.get(i).size(); t++){
                    printArr.get(arrVertex.get(i)).add(arrVertex.get(graph.get(i).get(t)));
                }
                String key =printArr.keySet().toArray()[i].toString();
                String value = printArr.get(arrVertex.get(i)).toString()
                        .replace("[","")
                        .replace("]","");
                System.out.printf("%s : %s \n",key,value);
            }
        }

    }

    public void addEdge(int from, int to) {
        //from, to가 그래프의 크기보다 작거나, 음수일때 종료
        if(from < 0 || to < 0 || from >= graph.size() || to >= graph.size()) return;
        graph.get(from).add(to);
        graph.get(to).add(from);
    }

    public boolean hasEdge(int from, int to) {
        //from, to가 그래프의 크기보다 작거나, 음수일 경우 종료
        if(from < 0 || to < 0 || from >= graph.size() || to >= graph.size()) return false;
        // 해당 간선이 존재하는지 확인.
        else if(graph.get(from).contains(to)) return true;
        else return graph.get(to).contains(from);
    }

    public void removeEdge(int from, int to) {
        //from, to가 그래프의 크기보다 작거나, 음수일 경우 종료
        if(from < 0 || to < 0 || from >= graph.size() || to >= graph.size()) return;
        //from의 인접 리스트가 to로 이어지는 간선이 존재할때
        if(graph.get(from).contains(to)) {
        //from의 인접 리스트에서 to를 삭제
            graph.get(from).remove(to);
        }

        //to의 인접 리스트가 from으로 이어지는 간선이 존재할때
        if(graph.get(to).contains(from)) {
        //to의 인접 리스트에서 from을 삭제
            graph.get(to).remove(from);
        }
    }
}
