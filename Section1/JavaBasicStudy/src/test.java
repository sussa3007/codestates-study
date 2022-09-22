package CodeStates.Section1.JavaBasicStudy.src;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] t = {1,2,3,4,5,6,7,8};
        int[] a = {1,2,3,4,5,6,7,8,1,2,3};
        String q = "시발 미친 개새끼야 죽어버려라 킹받네 꺼져 미친새끼";
        q= q.replaceAll("시발", "멋진");
        System.out.println(q);

    }


//    public static String createPhoneNumber(int[] arr) {
//        String head = "010";
//        int len = arr.length;
//        String bodyArr = Arrays.toString(Arrays.copyOfRange(arr, len - 8, len - 4));
//        String body = bodyArr
//                .replaceAll(" ", "")
//                .replaceAll(",", "")
//                .replace("[", "")
//                .replace("]", "");
//        String tailArr = Arrays.toString(Arrays.copyOfRange(arr, len - 4, len));
//        String tail = tailArr
//                .replaceAll(" ", "")
//                .replaceAll(",", "")
//                .replace("[", "")
//                .replace("]", "");
//
//        if (len == 11) {
//            String headArr = Arrays.toString(Arrays.copyOfRange(arr, 0, 3));
//            head = headArr
//                    .replaceAll(" ", "")
//                    .replaceAll(",", "")
//                    .replace("[", "")
//                    .replace("]", "");
//        }
//        return String.format("(%s)%s-%s", head, body, tail);
//    }
}






//        public static String convertScoreToGradeWithPlusAndMinus(int score) {
//        //
//        String grade="";
//        if (score>100 || score<0) return "INVALID SCORE";
//        else if (score>=90){
//            grade = "A";
//            if (score>=98) return grade + "+";
//            if (score<=97) return grade + "-";
//            return grade;
//        } else if (score>=80){
//            grade = "B";
//            if (score>=88) return grade + "+";
//            if (score<=87) return grade + "-";
//            return grade;
//        } else if (score>=70){
//            grade = "C";
//            if (score>=78) return grade + "+";
//            if (score<=77) return grade + "-";
//            return grade;
//        }else if (score>=60){
//            grade = "D";
//            if (score>=68) return grade + "+";
//            if (score<=67) return grade + "-";
//            return grade;
//        } else return grade= "F";
//    }
//}
