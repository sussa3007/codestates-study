package CodeStates.Section1.CollectionsQuiz;

import java.util.*;

public class CollectionsQuiz {
    public static void main(String[] args) {
        CollectionsQuiz t = new CollectionsQuiz();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        hashMap.put("a",new ArrayList<>());
        hashMap.put("b",new ArrayList<>());
        hashMap.put("c",new ArrayList<>());
        System.out.println(hashMap.containsKey("d"));
        t.getElementOfListEntry(hashMap,"d",0);
    }
    public HashMap<Character, Integer> countAllCharacter(String str) {
        if (str.isEmpty()) return null;
        HashMap<Character,Integer> h = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            int count =0;
            for(int t=0; t<str.length(); t++)
                if (str.charAt(i)==str.charAt(t))
                    count++;
            h.put(str.charAt(i),count);
        }
        return h;
    }
    public HashMap<String, Integer> select(String[] arr, HashMap<String, Integer> hashMap) {
        HashMap<String,Integer> result = new HashMap<>();
        for (String s : arr) if (hashMap.containsKey(s)) result.put(s, hashMap.get(s));
        return result;
    }
    public boolean isMember(HashMap<String, String> member, String username, String password) {
        if(member.containsKey(username)) return member.get(username).equals(password);
        else return false;
    }
    public String getElementOfListEntry(HashMap<String, List<String>> hashMap, String key, int index) {
        if(!hashMap.containsKey(key)) return null;
        else if(hashMap.get(key).size()<=index) return null;
        return hashMap.get(key).get(index);
    }

    public boolean isContain(HashMap<String, Integer> hashMap, String key) {
        return hashMap.containsKey(key);
    }
    public HashMap<String, String> addFullNameEntry(HashMap<String, String> hashMap) {
        hashMap.put("fullName",hashMap.get("firstName")+hashMap.get("lastName"));
        return hashMap;
    }

    public int addOddValues(HashMap<Character, Integer> hashMap) {
        Iterator<Integer> it = hashMap.values().iterator();
        int result = 0;
        while (it.hasNext()) {
            int t = it.next();
            if(t%2==0) result += t;
        }
        return result;

//        Set<Character> a = hashMap.keySet();
//        Iterator<Character> it = a.iterator();
//        Character b;
//        int result = 0;
//        while (it.hasNext()) {
//            b = it.next();
//            if(hashMap.get(b)%2==0) result += hashMap.get(b);
//        }
//        return result;
    }

    public int getSize(HashMap<Integer, Integer> hashMap) {
        return hashMap.size();
    }
    public void clearHashMap(HashMap<Integer, Boolean> hashMap) {
        hashMap.clear();
    }
    public void removeEntry(HashMap<String, Integer> hashMap, String key) {
        hashMap.remove(key);
    }
    public HashMap<String, Integer> addKeyAndValue(HashMap<String, Integer> hashMap, String key, int value) {
        hashMap.put(key,value); return hashMap;
    }
    public Integer getValue(HashMap<String, Integer> hashMap, String key) {
        return hashMap.get(key);
    }
    public int sumAllElements(ArrayList<Integer> arrayList) {
        int result = 0;
        if(arrayList.isEmpty()) return 0;
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) result += it.next();
        return result;
    }
    public ArrayList<Integer> clearArrayList(ArrayList<Integer> arrayList) {
        arrayList.clear();
        return arrayList;
    }

    public List<String> arrayToArrayList(String[] arr) {
        ArrayList<String> al = new ArrayList<>();
        if(arr.length==0) return null;
        Collections.addAll(al,arr);
        return al;
    }
    public ArrayList<Integer> removeFromBackOfNew(ArrayList<Integer> arrayList) {
        ArrayList<Integer> arr =(ArrayList<Integer>) arrayList.clone();
        if(arrayList.isEmpty()) return null;
        arr.remove(arr.size()-1);
        return arr;
    }
    public String removeFromNth(ArrayList<String> arrayList, int index) {
            String rmStr = "";
            if(arrayList.size()<=index) return null;
            else {
                rmStr = arrayList.get(index);
                arrayList.remove(index);
                return rmStr;
            }
        }
    public Integer removeFromFront(ArrayList<Integer> arrayList) {
        Integer rmVal;
        if(arrayList.isEmpty()) return null;
        rmVal =arrayList.get(0);
        arrayList.remove(0);
        return rmVal;
    }
    public ArrayList<String> modifyNthElement(ArrayList<String> arrayList, int index, String str) {
        if(arrayList.size()<=index) return null;
        else arrayList.set(index,str);  return arrayList;
    }
    public ArrayList<Integer> addNth(ArrayList<Integer> arrayList, int index, int element) {
        if(arrayList.size()<=index) return null;
        else arrayList.add(index,element);  return arrayList;
    }
    public ArrayList<String> addLast(ArrayList<String> arrayList, String str) {
        arrayList.add(str);
        return arrayList;
    }
    public String getLastElement(ArrayList<String> arrayList) {
        if (arrayList.isEmpty()) return null;
        return arrayList.get(arrayList.size()-1);
    }
}
class CollectionsQuiz1 {
    public ArrayList<Integer> makeArrayList() {
        ArrayList<Integer> output = new ArrayList<>();
        for(int i=1; i<=5;i++) output.add(i);
        return output;
    }
}
class CollectionsQuiz2 {
    public Integer getNthElement(ArrayList<Integer> arrayList, int index) {
        Integer result;
        if(arrayList.isEmpty()) return null;
        else if (arrayList.size()<=index) {
            return null;
        } else  result = arrayList.get(index);
        return result;
    }
}