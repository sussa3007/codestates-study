package CodeStates.Section1.JavaBasicStudy.src;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringMethod {
    public static void main(String[] args) {
        String str = new String("Oracle Java   ");
        System.out.println("문자열" + str);
        System.out.println("=".repeat(30));

        System.out.println(str.concat("수업"));
        System.out.println(str.indexOf("a"));
        System.out.println(str.trim());
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());

        System.out.println("=".repeat(30));

        StringTokenizer tok = new StringTokenizer(str);
        System.out.println(tok.countTokens());
        while (tok.hasMoreTokens()){
            System.out.println(tok.nextToken());
        }
        System.out.println("=".repeat(30));

        StringBuilder stb = new StringBuilder();
        stb.append("나는 ").append("문자열");
        String stbr = stb.toString();
        System.out.println(stb);
        System.out.println(stbr);

        System.out.println("=".repeat(30));

        StringBuffer stbuf = new StringBuffer(); // 인스턴스 생성후 문자열추가
        System.out.println(stbuf);
        stbuf.append("나는_").append("문자열").append("_Java");
        System.out.println(stbuf);
        stbuf.insert(3, "객체");
        System.out.println(stbuf); // 문자열 인덱스 4자리에 추가 후
        System.out.println(stbuf.capacity()); // 16

        StringBuffer stbuf1 = new StringBuffer("나는_문자열_Java"); // 인스턴스 생성시 문자열 추가
        System.out.println(stbuf1);
        System.out.println(stbuf1.capacity()); // 배열구조의 총 크기 11+16
        System.out.println(stbuf1.length()); // 저장된 문자열의 크기

        System.out.println("=".repeat(30));


    }
}
