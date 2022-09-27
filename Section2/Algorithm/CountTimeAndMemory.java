package CodeStates.Section2.Algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CountTimeAndMemory {
    public void B2164_outmemory () throws IOException {
        // 메모리초과
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Queue cardQ = new LinkedList();
        for(int i = 1; i<=num; i++){
            cardQ.add(i);
        }
        while (true){ // 왜 메모리 초과가 나지?
            cardQ.poll();
            if (cardQ.size()==1) break;
            cardQ.add(cardQ.poll());
        }
        bw.write(cardQ.poll().toString());
        bw.flush();

    }
    public void B2164 () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        Queue cardQ = new LinkedList();
        for(int i = 1; i<=num; i++){
            cardQ.add(i);
        }
        for (int i = 0; i < num-1; i++) {
            cardQ.poll();
            cardQ.add(cardQ.poll());
        }
        bw.write(cardQ.poll().toString());
        bw.flush();

    }
    public void B1920_TimeOut () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine().trim());
        int count;
        int[] intArr = new int[input];
        int[] compArr;
        int[] result;
        String[] strArr;
        strArr = br.readLine().trim().split(" ");
        for (int i=0; i<input; i++){
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        count = Integer.parseInt(br.readLine().trim());
        compArr = new int[count];
        result = new int[count];
        strArr =br.readLine().trim().split(" ");
        for (int i=0; i<count; i++){
            compArr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.fill(result,0);
        for(int i=0;i<compArr.length; i++){
            for (int t : intArr){
                if(compArr[i]==t){
                    result[i] = 1;
                    break;
                }
            }
        }
        for (int a : result) System.out.println(a);
    }
    public void B1920 () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        int count;
        int[] intArr;
        int[] compArr;
        int[] result;
        intArr = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .distinct()
                .sorted()
                .toArray();
        count = Integer.parseInt(br.readLine().trim());
        compArr = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        result = new int[count];
        Arrays.fill(result,0);
        for(int comp=0;comp<compArr.length;comp++){
            if(Arrays.binarySearch(intArr,compArr[comp])>=0) {
                result[comp]=1;
            }
        }
        for (int a : result) bw.write(a+"\n");
        bw.flush();
    }
}
class CountTime {

    public static void main(String[] args) throws IOException {
/* 10
4 1 5 2 3 8 9 8 6 7
10
1 3 7 9 5 5 4 3 2 3*/
        CountTimeAndMemory c = new CountTimeAndMemory();

        long before = System.currentTimeMillis(); //코드 실행 전 시간
        c.B1920_TimeOut();
        long after = System.currentTimeMillis(); // 코드 실행 후 시간
        long diff = (after - before); //두 시간에 차이
        System.out.println("시간차이(밀리세컨즈) : "+diff);

    }
}


class CountMemory {

    public static void main(String[] args) throws IOException {
        CountTimeAndMemory c = new CountTimeAndMemory();

        // Garbage Collection으로 메모리 초기화
        System.gc();


        // 실행전 메모리 사용량 조회
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Used Memory : " + before);


        // 프로그램 소스코드
        c.B2164();

        // Garbage Collection으로 메모리 정리
        System.gc();

        // 실행 후 메모리 사용량 조회
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // 메모리 사용량 측정
        long usedMemory = (before - after) / 1024;

        System.out.println("Used Memory(MB): " + usedMemory);

    }
}