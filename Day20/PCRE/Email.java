package PCRE;

import java.util.regex.Pattern;

public class Email {
    public static void main(String[] args) {
        String pattern1 = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        //a-z, A-z사이의 문자열과 특수문자 다섯가지 허용...<<해당 부분이 한글자 이상 있도록 하는 +
        //@
        //도메인과 온점, 2~6글자 사이의 영문자를 붙인 host부
        String pattern2 = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
        //문자열 + 특수문자 + 문자열...(문자열 바로 다음에 @를 오지 못하게)
        //@
        //문자열과 하나의 온점, 2,3글자 이내의 문자열을 덧붙인 host부
        String str2 = "abc_123@gmail.com";
        if(Pattern.matches(pattern1, str2)) {
            System.out.println("올바른 이메일 형식입니다. ");
        } else {
            System.out.println("올바른 이메일 형식이 아닙니다. ");
        }

    }
}
