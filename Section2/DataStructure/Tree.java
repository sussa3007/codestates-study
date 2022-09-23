package CodeStates.Section2.DataStructure;

import java.util.ArrayList;

public class Tree {
    private String value;
    private ArrayList<Tree> children;

    public Tree() {	//전달인자가 없을 경우의 생성자
        this.value = null;
        this.children = null;
    }
    public Tree(String data) {	//전달인자가 존재할 경우의 생성자
        this.value = data;
        this.children = null;
    }

    public void setValue(String data) {
        this.value = data; //
    }

    public String getValue() {      //현재 노드의 데이터를 반환
        return value;
    }
    public void addChildNode(Tree node) {
        if(children==null) children = new ArrayList<>();
        children.add(node);
    }
    public void removeChildNode(Tree node) {
        String data = node.getValue();

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                if(children.get(i).getValue().equals(data)) {
                    children.remove(i);
                    return;
                }
                if(children.get(i).children != null) children.get(i).removeChildNode(node);
            }
        }
    }

    public ArrayList<Tree> getChildrenNode() {
        return children;
    }

    public boolean contains(String data, boolean check) {      //재귀를 사용하여 값을 검색합니다.
        if(value.equals(data)) return true;

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                return children.get(i).contains(data,check);
            }
        }
        return false;
    }
}
