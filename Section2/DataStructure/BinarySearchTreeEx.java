package CodeStates.Section2.DataStructure;

import java.util.ArrayList;
import java.util.Comparator;


class BsTreeLink<Key,Value> {
    static class Node<Key,Value>{
        private Key key;
        private Value data;
        private Node<Key,Value> left;
        private Node<Key,Value> right;

        public Node(Key key, Value data, Node<Key, Value> left, Node<Key, Value> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Key getkey() { return key; }

        public void setKey(Key key) { this.key = key; }

        public Value getData() { return data; }

        public void setData(Value data) { this.data = data; }

        // 해당 노드의 데이터를 출력한다.
        public void print(){ System.out.println(data); }
    }

    private Node<Key,Value> root;
    private Comparator<? super Key> comparator = null;
    // root의 값 초기화 생성자
    public BsTreeLink (){
        root=null;
    }
    // 비어있는 루트 트리를 생성하고 전달받은 comparator을 정의한다.
    public BsTreeLink (Comparator<? super Key> c){
        this();
        comparator = c;
    }
    private int comp(Key key1, Key key2){
        return (comparator == null) ?
                // 기본 정렬 기준이 있는 데이터가 들어온다면 compareTo 메소드가 구현된다.
                ((Comparable<Key>)key1).compareTo(key2)
                // 생성자로 트리 생성을 했다면, 비교자로 비교
                : comparator.compare(key1,key2);
    }
    /* search 알고리즘 매개변수 key의 value 값을 찾아줌
     1. 루트를 p로 설정
     2. p가 null이면 검색에 실패 -종료
     3. 검색하는 값이 key와 p의 키값을 비교
     4. 작으면 왼쪽 크면 오른쪽으로 가서 1 의 과정부터 다시*/
    public  Value search(Key key){
        Node<Key, Value> p = root;
        while (true){
            if(p==null) return null; // 실패
            int cond = comp(key,p.getkey()); // key와 p의 키값 비교
            if (cond == 0) return p.getData(); // 같다면 Data 반환
            else if(cond<0) p= p.left; // 작다면 cond는 -1일 것이고 왼쪽 자식노드를 루트로 다시검색
            else p=p.right; // 크다면 cond는 1일 것이고 오른쪽 자식노드를 루트로 다시검색
        }
    }
    /* add 알고리즘
     search를 하는 알고리즘과 동일하게 진행하며 실패한 부분에서 삽입.
     1. 서브트리의 루트를 선택하고 p라고 정의
     2. 삽입할 key와 p의 키값을 비교한다. 같으면 실패
     3. 작다면 왼쪽 노드로 가서 비어있다면 삽입 값이 있다면 재귀 호출
     4. 크다면 오른쪽 노드로 가서 비어있다면 삽입 값이 있다면 재귀 호출*/
    private void addNode(Node<Key,Value> p,Key key, Value data){
        int cond = comp(key,p.getkey());
        if(cond==0) return; // 같다면 종료
        else if (cond<0) { // 작다면 왼쪽으로 가서 비교
            if(p.left==null) p.left = new Node<Key,Value>(key,data,null,null);
            else addNode(p.left,key,data);
        }else { // 크다면 오른쪽으로 가서 비교
            if(p.right==null) p.right = new Node<Key,Value>(key,data,null,null);
            else addNode(p.right,key,data);
        }
    }

    public void add(Key key, Value data){
        // 루트가 비어있다면 새로운 노드 생성
        if(root == null) root = new Node<Key,Value>(key,data,null,null);
        // 아니라면 addNode 메소드 호출하여 비어있는 노드에 키와 데이터 값 삽입
        else addNode(root,key,data);
    }
    /* remove 알고리즘
     1. 자식 노드가 없는 노드를 삭제하는 경우
     1.1 삭제할 노드가 부모노드의 왼쪽이면 왼쪽 포인터를 null
     1.2 삭제할 노드가 부모노드의 오른쪽이면 오른쪽 포인터를 null
     2.자식 노드가 하나인 노드를 삭제하는 경우
     2.1 삭제할 노드가 부모노드의 왼쪽이면 왼쪽 포인터를 삭제할 노드 자식 노드를 가르키도록 정의
     2.2 삭제할 노드가 부모노드의 오른쪽이면 오른쪽 포인터를 삭제할 노드 자식 노드를 가르키도록 정의
     3. 자식 노드가 둘인 노드를 삭제하는 경우
     3.1 삭제할 노드의 왼쪽 서브트리에서 키값이 가장 큰 노드를 검색
     3.2 검색할 노드의 데이터를 삭제할 노드로 복사
     3.3 검색한 노드를 삭제
     3.3.1 3.3에서 삭제한 노드에 자식이 없다면 1의 순서에 따라 삭제
     3.3.2 3.3에서 삭제한 노드에 자식이 1개만 있다면 2의 순서에 따라 삭제
     서브 트리에서 키값이 가장 큰 노드를 검색 하였을때 자식이 하나거나 없는 경우밖에 없다.*/
    public boolean remove(Key key){
        Node<Key,Value> p = root; // 탐색중인 노드
        Node<Key,Value> parent = null; // 탐색중인 노드의 부모 노드
        boolean isLeftChild = true; // p가 부모의 왼쪽 자식 노드인지 확인

        // 삭제할 노드를 탐색
        while (true){
            if(p==null) return false; // 탐색중인 노드가 비어있다면 삭제 실패.
            int cond = comp(key,p.getkey()); // key와 p의 키 값을 비교
            if(cond==0) break; // 찾으면 반복문 빠져나감.
            else {
                parent = p;
                if(cond<0){
                    isLeftChild = true;
                    p = p.left;
                } else {
                    isLeftChild = false;
                    p= p.right;
                }
            }
        }
        // p의 왼쪽 노드가 없을때
        if (p.left==null){
            if(p==root) root = p.right; // root를 삭제할때
                // 삭제할 노드가 부모노드의 왼쪽 일때
            else if(isLeftChild) parent.left = p.right;
                // 삭제할 노드가 부모노드의 오른쪽 일때
            else parent.right = p.right;
        // p의 양쪽 노드가 없을때
        } else if (p.right == null) {
            if(p==root) root=p.left; // root를 삭제할때
            else if(isLeftChild) parent.left = p.left;
            else parent.right = p.left;
        } else {
            // 삭제할 노드의 양쪽 모두 노드를 가지고 있을때.
            parent = p;
            Node<Key,Value> left = p.left;
            isLeftChild = true;
            // 삭제할 노드의 왼쪽 서브트리에서 가장 큰 키 값을 찾는다.
            while (left.right != null){
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            p.key = left.key;
            p.data = left.data;
            if(isLeftChild) parent.left = left.left;
            else parent.right = left.left;
        }
        return true;
    }
    // 중위 순회
    private void inorderSubTree(Node node){
        if(node != null){
            inorderSubTree(node.left);
            System.out.println(node.key+" = "+node.data);
            inorderSubTree(node.right);
        }
    }
    // 전위 순회
    private void preOrderSubTree(Node node){
        if(node != null){
            System.out.println(node.key+" = "+node.data);
            preOrderSubTree(node.left);
            preOrderSubTree(node.right);
        }
    }
    // 후위 순회
    private void postOrderSubTree(Node node){
        if(node != null){
            postOrderSubTree(node.left);
            postOrderSubTree(node.right);
            System.out.println(node.key+" = "+node.data);
        }
    }

    // 트리의 모든 데이터 출력
    public void print(){
        inorderSubTree(root);
    }
    public void preOrderPrint(){
        preOrderSubTree(root);
    }
    public void postOrderPrint(){
        postOrderSubTree(root);
    }

}
public class BinarySearchTreeEx {
    public static void main(String[] args) {
        BsTreeLink<Integer, Boolean> tree = new BsTreeLink<>();
        for (int i =0; i<6; i++){
            tree.add(i,true);
        }

        tree.print();
        tree.preOrderPrint();
        tree.postOrderPrint();

    }
}




























