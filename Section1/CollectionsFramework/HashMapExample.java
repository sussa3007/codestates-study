package CodeStates.Section1.CollectionsFramework;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        System.out.println("--------------");
        hashMap.put("A", 3);
        hashMap.put("B", 3);
        hashMap.put("C", 4);
        hashMap.put("D", 7);
        hashMap.put("E", 7);
        hashMap.put("F", 0);

        // SET으로 변환
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entrySet.iterator();

        while (iterator1.hasNext()) {
            Map.Entry entry = iterator1.next();
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }

        // Key 값
        Set<String> keySet = hashMap.keySet();
        System.out.println("Key : " + keySet);

        // 평균 -> value 합계 / size
        int total = 0;

        Collection values = hashMap.values();
        Iterator<Integer> iterator2 = values.iterator();

        while (iterator2.hasNext()) {
            Integer num = iterator2.next();
            total += num.intValue();
        }

        System.out.println("Avr : " + (float) total / keySet.size() );

        // 최대값
        System.out.print("Max : ");
        iterator1 = entrySet.iterator();

        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> entry = iterator1.next();
            if (entry.getValue() == Collections.max(values)) System.out.print(entry.getKey() + " ");
        }

    }
}



