
/*
 OOP객체 지향 프로그래밍(여러개의 조각들을(설계도) 만들어서 조합하는 행위
 >>여러개의 설계또를 재사용하는 방법
 
 1. 상속 (재사용성)
 2. 캡슐화 (은닉화) : private....setter, getter(직접 할당을 막고 간접 할당을 통해서 데이터를 보호하겠다)
 3. 다형성 : 하나의 타입으로 여러개 객체의 주소를 가질 수 있는 것
 
 >>method overloading(오버로딩)
 하나의 이름으로 여러가지 기능을 하는 함수
 System.out.println() >> println()함수 이름은 한개... 사용 방법은 여러개
 1. 오버로딩은 성능향상과는 상관없다.(개발자 편하라고 있는 것, 만약 오버로딩이 없다면 함수 이름 다 외워야한다!!
 2. 오버로딩을 사용하지 않아도 문제되지 않는다.
 
 오버로딩은 다음과 같은 조건을 만족해야한다.
 1. 매서드 이름이 같아야한다.
 2. 매개변수의 개수 또는 타입이 달라야한다
 3. 반환타입은 관계없다.
 4. 매개변수의 순서가 다름을 인정한다.
 */

class Human{
	String name;
	int age;
}


class OverTest{
	int add(int i) {
		return 100+i;
	}
	
	//int add(int s) {//이름 충돌
		
	//}
	
	int add(int i, int j) {//파라매터 int i는 같지만 int j가 있기때문에 오버로딩의 조건을 만족한다
		return i+j;
	}
	String add(String s) {
		System.out.println("오버로딩  : "+s);
		return "hello"+s;
	}
	
	String add(String s, int i) {
		return "오버로딩";
	}
	String add(int i, String s) {//순서가 다름을 인정한다.
		return "";
	}
	void add(Human human) {//얘도 오버로딩이다  //Human 타입의 객체 주소가 들어와야한다
		human.name="홍길동";
		human.age = 100;
		System.out.println(human.name+" "+human.age);
		
	}
}

public class Ex13_Method_Overloading {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("A");//자동으로  parameter가 String녀석을 호출한다
		System.out.println('a');//자동으로 parameter가 char녀석 호출한다.
		
		
		/*
		 System.out.println();
		 System.out.printlnString();
		 System.out.printlnChar();
		 */
		
		OverTest ot = new OverTest();
		int result=ot.add(100	);
		System.out.println(result);
		int result1=ot.add(200,300);
		System.out.println(result1);
	}

}
