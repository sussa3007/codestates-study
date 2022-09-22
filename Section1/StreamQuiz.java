package CodeStates.Section1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamQuiz {
    public static void main(String[] args) {
        StreamQuiz sq = new StreamQuiz();
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<String> names = Arrays.asList("김코딩", "박해커", "김코딩", "최자바", "김자바");

        System.out.println(Arrays.toString(sq.filterName(names)));
    }
    public int computeSumOfAllElements(List<Integer> list){
        // 입력받은 수의 합
        return list.isEmpty() ? 0 : list.stream().mapToInt(Integer::intValue).sum();
    }
    public double computeAverageOfNumbers(List<Integer> list) {
        // 입력받은 수의 평균
        return list.isEmpty() ? 0 : list.stream().mapToInt(i->i).average().orElse(0);
    }
    public List<Integer> filterOddNumbers(List<Integer> list){
        //2의 배수만 리스트로 출력
        return list.stream().filter(i->i%2==0).collect(Collectors.toList());
    }
    public long computeCountOfFemaleMember(List<Member> members) {
        // 여자회원의 수
        return members.stream().filter(m -> Objects.equals(m.getGender(), "Female")).count();
    }
    static class Member {
        String name;
        String gender;

        public Member(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }
    }
    public double computeAverageOfMaleMember(List<Member1> members) {
        //남자회원의 나이 평균
        return members.stream().filter(m->m.getGender().equals("Male")).mapToInt(Member1::getAge).average().orElse(0);
    }   // 다시해보기
    static class Member1 {
        String name;
        String gender;
        int age;

        public Member1(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }
    }
    public String[] makeUniqueNameArray(List<String> names) {
         // 스트림 스트링을 스트링 배열로 변환
        return names.stream().sorted().distinct().toArray(String[]::new);
    }
    public String[] filterName(List<String> names) {
        // 김씨성을 가진 사람을 정렬과 중복제거후 String 배열로 리턴
        return names.stream().filter(m->m.startsWith("김")).sorted().distinct().toArray(String[]::new);
    }
    public Integer findBiggestNumber(int[] arr) {
        // 배열을 입력받아 최대값 출력 orElse는 옵셔널의 값을 뽑기위해 사용
        return arr.length==0 ? null : Arrays.stream(arr).max().orElse(0);
    }
    public int findLongestLength(String[] strArr) {
        // 문자열 배열을 받아 요소중 가장 긴 문자열의 길이를 반환
        return  strArr.length==0 ? 0 : Arrays.stream(strArr).mapToInt(String::length).max().orElse(0);
    }
    public List<String> mergeTwoStream(List<String> list1, List<String> list2) {
        // 두개의 스트림을 하나의 스트림으로 합치고 리스트타입으로 반환
        return Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
    }
    public List<Integer> makeElementDouble(List<Integer> list) {
        // 리스트의 요소를 2를 곱하고 리스트타입으로 반환
        return list.stream().map(i->i*2).collect(Collectors.toList());
    }
    public boolean isHot(int[] temperature) {
        // 배열의 길이가 7이고 배열의 요소를 스트림으로 뽑아 30보다 크거나 같은요소가 3개이상이면 트루 반환
        return temperature.length == 7 && Arrays.stream(temperature).filter(i -> i >= 30).count() >= 3;
    }
    public List<String> findPeople(List<String> male, List<String> female, String lastName) {
        return Stream.concat(male.stream(),female.stream())
                .filter(m->m.startsWith(lastName))
                .sorted().distinct().collect(Collectors.toList());
    }
}

