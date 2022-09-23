package CodeStates.Section2.DataStructure;

import java.util.*;
import java.util.stream.Collectors;

public class DataStructureQuiz {
    public static void main(String[] args) {
        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String[] actions2 = new String[]{"B", "-1", "B", "A", "C", "-1", "-1", "D", "-1", "1", "E", "-1", "-1", "1"};
//        String[] actions = new String[]{"B", "-1", "D", "1"};
        Integer[] boxes = new Integer[]{5, 1, 4, 6, 4, 7, 4, 4, 4, 6};
        int[] boxes1 = new int[]{7, 4, 5, 8};
        String start = "A";
//        System.out.println(paveBox4(boxes));
        System.out.println(queuePrinterA(2, 10,boxes1));
    }

    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();
        if (!(start.charAt(0) > 64 && start.charAt(0) < 91)) return new ArrayList<>();
        current.push(start);
        for (String s : actions) {
            if (s.equals("-1") && !prevStack.empty()) {
                nextStack.push(current.pop());
                current.push(prevStack.pop());
            } else if (s.equals("1") && !nextStack.empty()) {
                prevStack.push(current.pop());
                current.push(nextStack.pop());
            } else if (s.equals("-1") || s.equals("1")) {
            } else {
                prevStack.push(current.pop());
                current.push(s);
                nextStack.clear();
            }
        }
        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        return result;
    }
//        Integer[] boxes = new Integer[]{  7, 4, 4, 4, 6};

    public static int paveBox1(Integer[] boxes) {
        ArrayList<Integer> result = new ArrayList<>();
        List<Integer> cut = new ArrayList<Integer>(Arrays.asList(boxes));
        // 줄여나갈 list의 크기가 0일때 까지 반복
        while (cut.size() > 0) {
            // cut의 사이즈 만큼 순회하며,
            for (int i = 0; i < cut.size(); i++) {
                //cut의 첫번째 요소 보다 큰 수가 나온다면,
                if (cut.get(0) < cut.get(i)) {
                    // 큰수의 인덱스 값을 저장
                    result.add(i);
                    // 큰수 부터 끝까지 리스트를 자름.
                    cut = cut.subList(i, cut.size());
                    // for반복문을 빠져나가며 cut 사이즈가 0이 될때까지 다시 while반복
                    break;
                    // for반복문을 순회하며 i 값과 cut의 길이가 같아진다면
                } else if (cut.size() == i + 1) {
                    // cut의 첫번째 수보다 큰수가 나오지 않았으므로
                    // 사이즈 만큼의 수를 저장해줌
                    result.add(cut.size());
                    // cut를 비워주며 while 반복문 종료
                    cut.clear();
                }
            }
        }
        // result에 저장된 수는 각 첫요소보다 큰수가 나올때까지의 인덱스 값을 저장하며,
        // 최대 몇개가 지워 졌는지 카운드 된 숫자다. 그중 최대 값을 반환
        return result.stream().mapToInt(Integer::intValue).max().orElse(-1);
    }
    public static int paveBox2(Integer[] boxes) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> max = new ArrayList<>();
        list.addAll(Arrays.asList(boxes));
        int num = 0;
        for(int i = 0; i<list.size(); i++){
            for(int t=i; t<list.size();t++){
                if(list.get(i)>=list.get(t)){
                    num++;
                }else break;
            }
            max.add(num);
            num=0;
        }
        return Collections.max(max);
    }

   /* 1. 1초가 지나면 인쇄 작업 목록에는 7Kib 크기의 문서가 추가됩니다.

   2. 2초일 때 인쇄 작업 목록의 최대 용량이 10Kib이기 때문에 4Kib 문서는 작업 목록에 들어갈 수 없습니다.
    동시에 7Kib 문서는 작업 목록에서 1칸 앞으로 이동합니다.

   3. 3초일 때 7Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다. 동시에 4Kib 문서는 인쇄 작업 목록에 추가됩니다.

   4. 4초일 때 4Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다. 동시에 5Kib 문서는 인쇄 작업 목록에 추가됩니다.

   5. 5초일 때 4Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다. 동시에 5Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다.
     최대 용량 10Kib 제한으로 6Kib 문서는 인쇄 작업 목록으로 추가될 수 없습니다.

   6. 6초일 때 5Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다. 동시에 6Kib 문서가 인쇄 작업 목록에 추가됩니다.

   7. 7초일 때 6Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다.

   8. 8초일 때 6Kib 문서가 마지막으로 인쇄됩니다.*/
//        queuePrinter(2, 10, new int[]{7, 4, 5, 5});  //8
    public static int queuePrinter(int bufferSize, int capacities, int[] documents) {
        ArrayList<Integer> arr = (ArrayList<Integer>) Arrays.stream(documents).boxed().collect(Collectors.toList());
        Queue<Integer> print = new LinkedList<>();
        for(int i=0; i<bufferSize; i++){ print.offer(0); }
        if(print.peek()==null) return -1;
        int count = 0;
        for (int i=0; i<arr.size(); i++){
            if(print.size() == bufferSize){
                if((print.stream().mapToInt(Integer::intValue).sum()+ arr.get(i))<=capacities){
                    print.poll();
                    print.add(arr.get(i));
                    count++;
                } else {
                    print.poll();
                    if((print.stream().mapToInt(Integer::intValue).sum()+ arr.get(i))<=capacities) {
                        print.add(arr.get(i));
                    } else  { print.add(0); i--; }
                    count++;
                }
            } else {
                for(int t=0; t<(print.size()-bufferSize); i++){
                    print.poll();
                }
            }
            System.out.println(print);
        }
        if(print.size()>0) count= count+print.size();
        return count;
    }



    public static int queuePrinterA(int bufferSize, int capacities, int[] documents) {
        //        queuePrinter(2, 10, new int[]{7, 4, 5, 5});  //8

        // 프린트를 저장 큐 = 버퍼
        Queue<Integer> buffer = new LinkedList<>();
        // 용량 저장할 큐
        Queue<Integer> capaQue = new LinkedList<>();
        // 버퍼에 0으로 채워줌
        for (int i =0; i < bufferSize; i++) buffer.add(0);
        // capa 큐에서 하나씩 뽑아 내기 위해 docu요소 넣으줌
        for (Integer el : documents) {  capaQue.add(el);  }
        // 소요 카운트 = 1초
        int count = 0;
        // capa 저장
        int capa = 0;
        // 버퍼의 크기가 0이 될때까지 반복
        while (buffer.size() >0) {
            // capa에 buffer에서 프린트 되고 난 다음 capa를 저장
            capa = capa - buffer.poll();
            // =sec
            count++;
            // docu 요소가 남아 있을때
            if (capaQue.size() > 0) {
                // buffer에 docu요소가 들어갈수 있는지 capa로 확인
                if (capaQue.peek() + capa <= capacities) {
                    // 기존 capa에 docu요소의 capa를 더한 값을 저장
                    capa = capa + capaQue.peek();
                    // buffer에 ducu요소를 꺼내어 저장
                    buffer.add(capaQue.poll());
                }
                // capa 초과로 docu를 저장하지 못했을때 0을 추가해서 버퍼 크기를 맞춰줌
                else buffer.add(0);
            }
            System.out.println(buffer);
        }
        return count;
    }








    public static int paveBox3(Integer[] boxes) {
        // int[] boxes = new int[]{5, 1, 4, 6,7,5,5,5,5,5,5,1,4};
        //int output = paveBox(boxes);
        //System.out.println(output); // 3
        // 입력받은 배열중 첫 번째 요소보다 작거나 같은 요소를 먼저 순회
        // 순회 조건은 첫번째 요소보다 큰수가 나올때까지
        // 큰수의 앞 요소는 삭제  -> 삭제 크기 카운트
        // 큰수 부터 더 큰 수가 나올때가지 순회
        // 위 과정 반복중 마지막 큰수가 나왔을때 배열의 끝까지 잘라 길이 저장
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> max = new ArrayList<>();
        list.addAll(Arrays.asList(boxes));
        // i 3  t i  break
        int count = 0;
        for(int i=0; i<list.size(); i++){
            for(int t = i; t< list.size(); t++){
                if(list.get(i)>= list.get(t)) count++;
                else break;
            }
            max.add(count); count = 0;
        }
        return Collections.max(max);
    }

    public static int paveBox4(Integer[] boxes) {
        // 미완성
        int cnt = 0;
        int cntMax = 0;

        Queue<Integer> boxList = new LinkedList<Integer>();
        boxList.addAll(Arrays.asList(boxes));

        Integer currentBoxIndex = boxList.poll();   //맨 앞 요소를 기준으로


        for (int i=0; i<boxes.length+1; i++) {
            if (boxList.isEmpty()) {
                cntMax=cnt+1;
                break;
            }

            if (currentBoxIndex >= boxList.peek()) {  //뒤박스와 비교해서 작거나 같은 경우만 count
                cnt++;
                boxList.poll();
            }

            else if (currentBoxIndex < boxList.peek()) {   //큰 값이 나왔을때 기준값을 바꿔줌
                currentBoxIndex = boxList.poll();
                System.out.println("current: " + currentBoxIndex);
                //max값 설정
                if (cntMax < cnt) {
                    cntMax = cnt+1;
                }
                cnt = 0;
            }

        }
        // 마지막 최대값이 저장되었을때 cmtMax에 반영안됨
        // 제일 마지막 요소까지 순회한 후에 한번더 순회해야지 값을 지정할수 있음
        return cntMax;
    }

















}









