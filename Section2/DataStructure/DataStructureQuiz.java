package CodeStates.Section2.DataStructure;

import java.util.*;

public class DataStructureQuiz {
    public static void main(String[] args) {
        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String[] actions2 = new String[]{"B", "-1", "B", "A", "C", "-1", "-1", "D", "-1", "1", "E", "-1", "-1", "1"};
//        String[] actions = new String[]{"B", "-1", "D", "1"};
        Integer[] boxes = new Integer[]{5, 1, 4,6,4,7,4,4,4,6};
        String start = "A";
        System.out.println(paveBoxa(boxes));
    }
    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();
        if (!(start.charAt(0)>64&&start.charAt(0)<91)) return new ArrayList<>();
        current.push(start);
        for(String s : actions){
            if(s.equals("-1")&&!prevStack.empty()){
                nextStack.push(current.pop());
                current.push(prevStack.pop());
            } else if (s.equals("1")&&!nextStack.empty()) {
                prevStack.push(current.pop());
                current.push(nextStack.pop());
            } else if (s.equals("-1")||s.equals("1")) { }
            else{
                prevStack.push(current.pop());
                current.push(s);
                nextStack.clear();
            }
        }
        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        return  result;
    }
//    public static int paveBox(Integer[] boxes) {
//
//
//    }










    public static int paveBoxa(Integer[] boxes) {

        ArrayList<Integer> answer = new ArrayList<>();
        List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(boxes));
// 만약 찾았다면, 해당 key를 answer에 넣고, ArrayList에서 그만큼 제외합니다.
        while (arrayList.size() > 0) {
            for(int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i) > arrayList.get(0)) {
                    answer.add(i);
                    arrayList = arrayList.subList(i , arrayList.size());
                    break;
                }
                // 만약 찾지 못했다면 answer에 arrayList 크기를 넣은 후, arrayList 내부의 요소를 전부 삭제합니다.
                if(i == arrayList.size() - 1) {
                    answer.add(arrayList.size());
                    arrayList.clear();
                }
            }
        }
        return answer.stream().max(Integer::compare).orElse(-1);
    }
}


