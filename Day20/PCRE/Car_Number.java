package PCRE;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/*
 기본 정규식 단위(일부)
 ^ = 문자열의 시작
 $ = 문자열의 끝
 . = 임의의 한 문자
 * = 문자가 0번이상 발생
 + = 문자가 1번이상 발생
 ? = 문자가 0번 혹은 1번 발생
 [] = 문자의 집합 범위를 나타냄
 		[0-9] : 숫자(0부터 9까지)
 		[a-z] : 알파벳(a부터 z까지)
 		앞에 ^가 나타나면 not을 의미
 {} = 횟수 또는 범위를 의미
 () = 소괄호 안의 문자를 하나로 인식
 | = or조건
 \ = 확장 문자의 시작
 \b = 단어의 경계
 \B = 단어가 아닌 것의 경계
 \A = 입력의 시작부분
 \G = 이전 매치의 끝?
 \Z = 입력의 끝이지만 종결자가 있는 경우
 \z = 입력의 끝
 \s = 공백문자
 \S = 공백문자가 아닌 나머지 문자
 \w = 알파벳이나 숫자
 \W = 알파벳이나 숫자를 제외한 문자
 \d = [0-9]와 동일
 \D = 숫자를 제외한 모든 문자
 */
public class Car_Number {
	public static void main(String[] args) {
			String pattern = "^(([가-힣]{2}|[가-힣]{4})?\\s?(\\d{2}|\\d{3})\\s?[가-힣]\\s?\\d{4}|임\\s?[가-힣]{4,6}\\s?(\\d{6}|\\d{4}))";
			Scanner sc = new Scanner(System.in);
			System.out.println("차량번호를 입력하세요");
		String str=sc.nextLine();
		boolean regex= java.util.regex.Pattern.matches(pattern, str);
		
			  if( java.util.regex.Pattern.matches(pattern, str)) {
		            System.out.println("올바른 차량 번호  형식입니다. ");
		        } else {
		            System.out.println("올바른 차량번호가 아닙니다. ");
		        }

	}
}