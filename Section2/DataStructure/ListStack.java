package CodeStates.Section2.DataStructure;

import java.util.ArrayList;

public class ListStack {
    public static void main(String[] args) {
        ListStack stack = new ListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.show());
    }
    // Stack을 직접 구현
    // Data를 저장할 ArrayList
    private ArrayList<Integer> listStack = new ArrayList<>();

    public void push(Integer data) {
        listStack.add(data);
    }

    public Integer pop() {
        if(listStack.isEmpty()) {
            return null;
        }else {
            return listStack.remove(listStack.size()-1);
        }
    }

    public int size() {
        return listStack.size();
    }

    public Integer peek() {
        if(listStack.isEmpty()) {
            return null;
        }else {
            return listStack.get(listStack.size()-1);
        }
    }

    public String show() {
        return listStack.toString();
    }
    public void clear() { listStack.clear(); }
}
