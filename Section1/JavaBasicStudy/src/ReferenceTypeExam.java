package CodeStates.Section1.JavaBasicStudy.src;

public class ReferenceTypeExam{

    public static void main(String []args) {
        ReferenceTypeExam exam = new ReferenceTypeExam();

        // 기본형 변수 value1을 addOne에 전달합니다.
        int value = 10;
        exam.addOne(value);
        System.out.println("기본형 변수의 값을 다른 메서드에서 변경한 결과: "+(value));

        // 참조형 변수 arr을 addOne에 전달합니다.
        int []arr = {10};
        exam.addOne(arr);
        System.out.println("참조형 변수의 값을 다른 메서드에서 변경한 결과: "+arr[0]);
    }


    public void addOne(int value) {
        value++; // 기본형 변수는 변수라는 그릇이 들어오는게아니라
        //           변수에 들어있는 값이 들어오는거다 (주소값을 참조하는게 아니라서 그렇다)
    }


    public void addOne(int[] arr) {
        for(int i = 0; i<arr.length ; i++) {
            arr[i] ++; // i가 0일때 for문이 한번 반복되어 +1됨
        }
    }
}