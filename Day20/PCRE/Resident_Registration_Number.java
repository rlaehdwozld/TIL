package PCRE;

import java.util.regex.Pattern;

/*
1. 주민등록번호 : \d{2}[0-1]\d{3}\-[1-4]\d{6}

\d{2} : 숫자[0~9]가 2개 

[0-1] : 숫자[0~1]

\d{3} : 숫자[0~9]가 3개

\- : 역슬래시 + 특수문자 = 그 문자 자체 "-"

[1-4] : 숫자[1~4]

\d{6} : 숫자[0~9]가 6개
*/
public class Resident_Registration_Number {
	String pattern1 ="\\d{2}[0-1]\\d{3}\\-[1-4]\\d{6}";
	String str= "1111111111111"
	
	 if(Pattern.matches(pattern1, str)){
         System.out.println("올바른 이메일 형식입니다. ");
     } else {
         System.out.println("올바른 이메일 형식이 아닙니다. ");
     }
}
