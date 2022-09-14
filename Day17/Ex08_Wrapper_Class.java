/*
자바 8가지 기본 타입(값타입) : Java API제공

8가지 기본 타입에 대해서 객체 형태로 사용 가능하도록 만든 클래스(wrapper class)

사용 용도 
1. 매개변수가 객체가 요구 될때 
2. 기본형 값이 아닌 객체 형태로 저장이 필요할 때
3. 객체간 값을 비교할 때 
4. 타입 변환시 처리

>>generic 설계 (객체 형태)>>int > Integer


*/

public class Ex08_Wrapper_Class {

	public static void main(String[] args) {
		int i = 100;
		Integer n = new Integer(500)	;
		System.out.println("n :"+n);//toString 재정의 되어 있다.
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

	}

}
