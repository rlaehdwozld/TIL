/*
 변수 -<----> 상수
 상수 : 한번 값이 [초기화 ]되면 변경 불사
 상수 자원 : 고유값(주민번호)수학 : PI값. 시스템 번호(버전번호)
 상수는 관용적으로 [대문자]

java : final int NUM =10;
c#   : const integer NUM = 10;
final 키워드
1. final class Car{}	> 클래스 final> 상속 금지
public final class Math
extends Object

2. public final void print(){} 함수 final> 상속 관계에서 재정의 (override 금지)
	

 */

class Vcard {
	final String KIND = "hearr";
	final int NUM = 10;

	void method() {
		System.out.println(Math.PI);
	}
}

class Vcard2 {// 설계자 입장에서 이렇게 만들었다는 것은 만든 카드마다 다른 상수값을 가지게 하겠는 의미
	final String KIND;
	final int NUM;

	// Vcard2(){} 만약에 기본 생성자를 만들면 밑에 생성자가 선택이 안될 수도 있으니깐 엑박뜸

	Vcard2(String kind, int num) {// final은 꼭 초기화 해야하지만 이런 경우에는 인정함
		this.KIND = kind;
		this.NUM = num;

	}

	
	 @Override public String toString() { return "Vcard2 [KIND=" + KIND + ", NUM="
	 + NUM + "]"; }
	 

}

public class Ex07_final {

	public static void main(String[] args) {
		Vcard vc = new Vcard();
		// vc.KIND = "aaa"변경불가
		System.out.println(vc.KIND);
		vc.method();

		Vcard2 v1 = new Vcard2("spade", 1);
		System.out.println(v1.toString());
		Vcard2 v2 = new Vcard2("spade", 2);
		System.out.println(v2.toString());
		Vcard2 v3 = new Vcard2("spade", 3);
		System.out.println(v3.toString());

	}
}